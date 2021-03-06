package com.example.TaskManager2.services;

import com.example.TaskManager2.models.Task;
import com.example.TaskManager2.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    @Autowired
    TaskRepository taskRepository;

    public List<Task> getTasks() {
        return taskRepository.findAll();
    }

    public Long addTask(Task task) {
        Task newTask = taskRepository.save(task);
        return newTask.getId();

    }
}