package com.amydegregorio.modelmappernostarter.dto;

import java.time.LocalDate;

import javax.validation.constraints.NotNull;

public class TaskDto {
   private Long Id;
   @NotNull
   private String description;
   private LocalDate startDate;
   private LocalDate completionDate;
   private String priority;
   private String status;
   
   public Long getId() {
      return Id;
   }
   
   public void setId(Long id) {
      Id = id;
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
   
   public String getPriority() {
      return priority;
   }
   
   public void setPriority(String priority) {
      this.priority = priority;
   }
   
   public String getStatus() {
      return status;
   }
   
   public void setStatus(String status) {
      this.status = status;
   }

   @Override
   public String toString() {
      return "TaskDto [Id=" + Id + ", description=" + description + ", startDate=" + startDate + ", completionDate="
               + completionDate + ", priority=" + priority + ", status=" + status + "]";
   }
}
