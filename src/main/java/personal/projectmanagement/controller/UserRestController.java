package personal.projectmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import personal.projectmanagement.model.Task;
import personal.projectmanagement.model.User;
import personal.projectmanagement.service.UserService;

@RestController
@RequestMapping("/api/project-management")
public class UserRestController {
    @Autowired
    UserService userSvc;

    @GetMapping
    public ResponseEntity<List<User>> findAllUsers() {
        List<User> users = userSvc.findAllUsers();

        return ResponseEntity.ok().body(users);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<User> findUserById(@PathVariable("userId") Integer userId) {
        User user = userSvc.findUserById(userId);
        return ResponseEntity.ok().body(user);
    }

    @PostMapping("/register")
    public ResponseEntity<Boolean> createUser(@ModelAttribute("userForm") User user) {
        Boolean created = userSvc.createUser(user);
        return ResponseEntity.ok().body(created);
    }

    @PostMapping("/task")
    public ResponseEntity<Boolean> createTask(@ModelAttribute("taskForm") Task task) {
        Boolean created = userSvc.createTask(task);
        return ResponseEntity.ok().body(created);
    }

    @DeleteMapping("/{taskId}")
    public ResponseEntity<Boolean> deleteTask(@PathVariable("taskId") Integer taskId) {
        Boolean deleted = userSvc.deleteTask(taskId);
        return ResponseEntity.ok().body(deleted);
    }

    @GetMapping("/task/{userId}")
    public ResponseEntity<List<Task>> findTaskByUser(@PathVariable("userId") Integer userId) {
        List<Task> tasks = userSvc.findTaskByUser(userId);
        return ResponseEntity.ok().body(tasks);
    }

    @PutMapping
    public ResponseEntity<Boolean> editTask(@RequestBody Task task) {
        Boolean edited = userSvc.editTask(task);
        return ResponseEntity.ok().body(edited);
    }

}
