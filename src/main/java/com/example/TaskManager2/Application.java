package com.example.TaskManager2;

import com.example.TaskManager2.Commands;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import picocli.CommandLine;

@SpringBootApplication
public class Application implements CommandLineRunner {
    private Commands commands;
    private Commands.ShowAllUsers showAllUsers;
    private Commands.createUser createUser;
    private Commands.addTask addTask;
    private Commands.showTasks showTasks;
    private Commands.addTaskToGroup addTaskToGroup;
    @Autowired
    public Application(Commands commands, Commands.ShowAllUsers showAllUsers,
                       Commands.createUser createUser, Commands.addTask addTask,
                       Commands.showTasks showTasks, Commands.addTaskToGroup addTaskToGroup) {
        this.commands = commands;
        this.showAllUsers = showAllUsers;
        this.createUser = createUser;
        this.addTask = addTask;
        this.showTasks = showTasks;
        this.addTaskToGroup = addTaskToGroup;
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) {
        CommandLine commandLine = new CommandLine(commands);
        commandLine.addSubcommand("-showAllUsers", showAllUsers);
        commandLine.addSubcommand("-createUser", createUser);
        commandLine.addSubcommand("-addTask", addTask);
        commandLine.addSubcommand("-showTasks", showTasks);
        commandLine.addSubcommand("-addTaskToGroup", addTaskToGroup);
        commandLine.parseWithHandler(new CommandLine.RunLast(), args);
    }
}
