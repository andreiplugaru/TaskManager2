package com.example.TaskManager2;
import com.example.TaskManager2.services.TaskService;
import com.example.TaskManager2.services.UserService;
import com.example.TaskManager2.models.Task;
import com.example.TaskManager2.models.User;
import com.example.TaskManager2.repositories.TaskRepository;
import com.example.TaskManager2.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import picocli.CommandLine;
import java.util.List;
import java.util.Optional;
import static picocli.CommandLine.Command;

@Command()
@Component
public class Commands implements Runnable {
    @Override
    public void run() {
    }

    @CommandLine.Command(name = "-showAllUsers")
    @Component
    public class ShowAllUsers implements Runnable {
        private String[] messages;
        @Autowired
        UserService userService;

        @Override
        public void run() {
            List<User> users = userService.getUsers();
            for (User u : users)
                System.out.println(u.toString());
            System.out.println("Users " + users.stream().count() + " in show all users!!");

        }
    }

    @CommandLine.Command(name = "-createUser")
    @Component
    public class createUser implements Runnable {
        @Autowired
        UserService userService;
        @CommandLine.Option(names = {"-fn"}, required = true)
        public String fn;
        @CommandLine.Option(names = {"-ln"}, required = true)
        public String ln;
        @CommandLine.Option(names = {"-un"}, required = true)
        public String un;
        @CommandLine.Option(names = {"-gId"}, required = false)
        public Optional<Long> gId;

        @Override
        public void run() {
            User user;
            if (gId.isPresent())
                user = new User(fn, ln, un, gId.get());
            else
                user = new User(fn, ln, un);
            List<User> users = userService.getUsers();
            if (!users.isEmpty() && users.stream().anyMatch(x -> x.getUserName().equals(un)) == true)
                System.out.println("This username already exists!");
            else {
                userService.addUser(user);
            }
        }
    }

    @CommandLine.Command(name = "-addTask")
    @Component
    public class addTask implements Runnable {
        @Autowired
        TaskRepository taskRepository;
        @Autowired
        UserRepository userRepository;
        @CommandLine.Option(names = {"-un"}, required = true)
        public String un;
        @CommandLine.Option(names = {"-tt"}, required = true)
        public String tt;
        @CommandLine.Option(names = {"-td"}, required = true)
        public String td;

        @Override
        public void run() {
            Task t = new Task(un, tt, td);
            List<User> users = userRepository.findAll();
            if (!users.isEmpty() && users.stream().anyMatch(x -> x.getUserName().equals(un)) == false)
                System.out.println("This username doesn't exist!");
            else {
                taskRepository.save(t);
            }
        }
    }

    @CommandLine.Command(name = "-showTasks")
    @Component
    public class showTasks implements Runnable {
        @Autowired
        TaskService taskService;

        @Override
        public void run() {
            List<Task> tasks = taskService.getTasks();
            for (Task u : tasks)
                System.out.println(u.toString());
        }
    }

    @CommandLine.Command(name = "-addTaskToGroup")
    @Component
    public class addTaskToGroup implements Runnable {
        @Autowired
        TaskService taskService;
        @Autowired
        UserService userService;
        @CommandLine.Option(names = {"-gId"}, required = true)
        public Long gId;
        @CommandLine.Option(names = {"-tt"}, required = true)
        public String tt;
        @CommandLine.Option(names = {"-td"}, required = true)
        public String td;

        @Override
        public void run() {
            int groupCount = 0;
            List<User> users = userService.getUsers();
            if (!users.isEmpty()) {
                for (User u : users)
                    if (u.getGroupId() == gId) {
                        Task t = new Task(u.getUserName(), tt, td);
                        taskService.addTask(t);
                        groupCount++;
                    }
            }
            System.out.println("Task has been added to " + groupCount + " users!");
        }
    }
}
