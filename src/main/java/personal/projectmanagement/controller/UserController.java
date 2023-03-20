package personal.projectmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import personal.projectmanagement.model.User;
import personal.projectmanagement.service.UserService;

@RestController
@RequestMapping("/api/project-management")
public class UserController {
    @Autowired
    UserService userSvc;

    @GetMapping
    public ResponseEntity<List<User>> findAllUsers() {
        List<User> users = userSvc.findAllUsers();

        return ResponseEntity.ok().body(users);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> findUserById(@PathVariable("id") Integer id) {
        User user = userSvc.findUserById(id);
        return ResponseEntity.ok().body(user);
    }

    @PostMapping("/register")
    public ResponseEntity<Boolean> createUser(@ModelAttribute("userForm") User user) {
        Boolean created = userSvc.createUser(user);
        return ResponseEntity.ok().body(created);
    }
}