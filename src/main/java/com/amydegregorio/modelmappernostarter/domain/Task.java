package com.amydegregorio.modelmappernostarter.domain;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.amydegregorio.modelmappernostarter.util.Priorities;
import com.amydegregorio.modelmappernostarter.util.Statuses;


@Entity
public class Task {
   
   @Id
   @GeneratedValue(strategy=GenerationType.AUTO)
   private Long id;
   private String description;
   private LocalDate startDate;
   private LocalDate completionDate;
   private Priorities priority;
   private Statuses status;
   
   public Long getId() {
      return id;
   }
   
   public void setId(Long id) {
      this.id = id;
   }
   
   public String getDescription() {
      return description;
   }
   
   public void setDescription(String description) {
      this.description = description;
   }
   
   public LocalDate getStartDate() {
      return startDate;
   }
   
   public void setStartDate(LocalDate startDate) {
      this.startDate = startDate;
   }
   
   public LocalDate getCompletionDate() {
      return completionDate;
   }
   
   public void setCompletionDate(LocalDate completionDate) {
      this.completionDate = completionDate;
   }
   
   public Priorities getPriority() {
      return priority;
   }
   
   public void setPriority(Priorities priority) {
      this.priority = priority;
   }
   
   public Statuses getStatus() {
      return status;
   }
   
   public void setStatus(Statuses status) {
      this.status = status;
   }

   @Override
   public String toString() {
      return "Task [id=" + id + ", description=" + description + ", startDate=" + startDate + ", completionDate="
               + completionDate + ", priority=" + priority + ", status=" + status + "]";
   }

}
