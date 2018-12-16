package com.amydegregorio.modelmappernostarter.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.amydegregorio.modelmappernostarter.domain.Task;
import com.amydegregorio.modelmappernostarter.dto.TaskDto;
import com.amydegregorio.modelmappernostarter.repository.TaskRepository;
import com.amydegregorio.modelmappernostarter.util.Priorities;
import com.amydegregorio.modelmappernostarter.util.Statuses;

@Controller
public class TaskController {
   @Autowired
   private TaskRepository taskRepository;
   @Autowired
   private ModelMapper modelMapper;
   
   @RequestMapping("/")
   public String listAll(Model model) {
      List<Task> tasks = taskRepository.findAll();
      
      List<TaskDto> taskDtos = tasks.stream().map(task -> modelMapper.map(task, TaskDto.class)).collect(Collectors.toList());
      model.addAttribute("tasks", taskDtos);
      return "task/list";
   }
   
   @RequestMapping(value="/task/add", method=RequestMethod.GET)
   public String addTask(TaskDto taskDto, Model model) {
      model.addAttribute("action", "task/add");
      return "task/entry";
   }
   
   @RequestMapping(value="/task/add",  params={"save"}, method=RequestMethod.POST)
   public String saveNewTask(@Valid TaskDto taskDto, BindingResult bindingResult, Model model) {
      if (bindingResult.hasErrors()) {
         model.addAttribute("action", "task/add");
         return "task/entry";
      }
      
      Task task = modelMapper.map(taskDto, Task.class);
      taskRepository.save(task);
      return "redirect:/";
   }
   
   @RequestMapping(value="/task/add", params={"cancel"}, method=RequestMethod.POST)
   public String cancelNewTask() {
      return "redirect:/";
   }
   
   @RequestMapping(value="/task/edit", method=RequestMethod.GET)
   public String editTask(TaskDto taskDto, Model model, @RequestParam("id") Long id) {
      model.addAttribute("action", "task/edit");
      Task task = taskRepository.getOne(id);
      System.out.println("Domain: " + task.toString());
      taskDto = modelMapper.map(task, TaskDto.class);
      model.addAttribute("taskDto", taskDto);
      return "task/entry";
   }
   
   @RequestMapping(value="/task/edit",  params={"save"}, method=RequestMethod.POST)
   public String saveTask(@Valid TaskDto taskDto, BindingResult bindingResult, Model model) {
      if (bindingResult.hasErrors()) {
         model.addAttribute("action", "task/edit");
         return "task/entry";
      }
      
      Task task = modelMapper.map(taskDto, Task.class);
      taskRepository.save(task);
      return "redirect:/";
   }
   
   @RequestMapping(value="/task/edit", params={"cancel"}, method=RequestMethod.POST)
   public String cancelTask() {
      return "redirect:/";
   }
   
   @RequestMapping(value="/task/delete", method=RequestMethod.GET) 
   public String deleteTask(@RequestParam("id") Long id){
      Task task = taskRepository.getOne(id);
      taskRepository.delete(task);
      return "redirect:/";
   }
   
   @ModelAttribute("priorities")
   public Priorities[] getPriorities() {
      return Priorities.values();
   }
   
   @ModelAttribute("statuses") 
   public Statuses[] getStatuses() {
      return Statuses.values();
   }
}
