package com.example.TaskManager2.repositories;


import com.example.TaskManager2.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
    @Repository
    public interface UserRepository extends JpaRepository<User, Long> {
}
