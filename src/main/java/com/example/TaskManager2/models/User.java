package com.example.TaskManager2.models;

import lombok.AllArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "user")

@AllArgsConstructor

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String FirstName;
    private String LastName;
    private String userName;
    private Long groupId;

    public User() {
    }

    public User(String firstName, String lastName, String userName) {
        this.FirstName = firstName;
        this.LastName = lastName;
        this.userName = userName;
    }

    public User(String firstName, String lastName, String userName, Long groupId) {
        this.FirstName = firstName;
        this.LastName = lastName;
        this.userName = userName;
        this.groupId = groupId;
    }

    public Long getGroupId() {
        return groupId;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "User {" +
                "FirstName='" + FirstName + '\'' +
                ", LastName='" + LastName + '\'' +
                ", userName='" + userName + '\'' +
                '}';
    }

    public String getFirstName() {
        return FirstName;
    }

    public String getLastName() {
        return LastName;
    }

    public String getUserName() {
        return userName;
    }
}

