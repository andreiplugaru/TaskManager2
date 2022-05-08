package com.example.TaskManager2.models;

import javax.persistence.*;

@Entity
@Table(name = "Task")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String userName;
    private String taskTitle;
    private String taskDescription;

    public Task() {
    }

    public Task(String userName, String taskTitle, String taskDescription) {
        this.userName = userName;
        this.taskTitle = taskTitle;
        this.taskDescription = taskDescription;
    }

    @Override
    public String toString() {
        return "Task{" + "userName='" + userName + '\'' + ", taskTitle='" + taskTitle + '\'' + ", taskDescription='" + taskDescription + '\'' + '}';
    }

    public Long getId() {
        return id;
    }
}
