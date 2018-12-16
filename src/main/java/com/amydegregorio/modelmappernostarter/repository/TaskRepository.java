package com.amydegregorio.modelmappernostarter.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.amydegregorio.modelmappernostarter.domain.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {
      
}
