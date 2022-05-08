package com.example.TaskManager2.models;

import javax.persistence.*;

@Entity
@Table(name = "Group")
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String groupName;
    private String userName;

    public Group() {
    }

    public Long getId() {
        return id;
    }

    public Group(String groupName, String userName) {
        this.userName = userName;
        this.groupName = groupName;
    }

    @Override
    public String toString() {
        return "Group{" +
                "id=" + id +
                ", groupName='" + groupName + '\'' +
                ", userName='" + userName + '\'' +
                '}';
    }
}
