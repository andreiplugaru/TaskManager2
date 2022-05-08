package com.example.TaskManager2.services;

import com.example.TaskManager2.models.Group;
import com.example.TaskManager2.repositories.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupService {
    @Autowired
    GroupRepository groupRepository;

    public List<Group> getGroups() {
        return groupRepository.findAll();
    }

    public Long addGroup(Group g) {
        Group newGroup = groupRepository.save(g);
        return newGroup.getId();
    }
}
