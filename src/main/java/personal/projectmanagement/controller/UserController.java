package personal.projectmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;
import personal.projectmanagement.model.Designation;
import personal.projectmanagement.model.Role;
import personal.projectmanagement.model.User;
import personal.projectmanagement.model.UserProfile;
import personal.projectmanagement.service.UserService;

@Controller
@RequestMapping
public class UserController {

    @Autowired
    UserService userSvc;

    @GetMapping("/registration")
    public String registration(Model model) {
        List<Role> roleList = userSvc.retrieveRoles();
        List<Designation> designationList = userSvc.retrieveDesignations();
        model.addAttribute("roleList", roleList);
        model.addAttribute("designationList", designationList);
        model.addAttribute("userValidation", new User());
        return "registration";
    }

    @PostMapping(value = "/registration")
    public String userProfile(@Valid @ModelAttribute("userValidation") User userValidation, BindingResult binding,
            Model model) {
        if (binding.hasErrors()) {
            return "registration";
        }
        userSvc.createUser(userValidation);
        List<User> userList = userSvc.findAllUsers();
        User user = userList.get(userList.size() - 1);
        UserProfile userProfile = userSvc.findUserProfileById(user.getId());
        model.addAttribute("userProfile", userProfile);
        return "user-profile";
    }

    @GetMapping("/profile/{userId}")
    public String userProfileById(@PathVariable("userId") Integer userId, Model model) {
        UserProfile userProfile = userSvc.findUserProfileById(userId);
        model.addAttribute("userProfile", userProfile);
        return "user-profile";
    }

    @GetMapping("/task/{userId}")
    public String taskForm(@PathVariable("userId") Integer userId, Model model) {
        model.addAttribute("userProfile", userId);
        return "task";
    }

}