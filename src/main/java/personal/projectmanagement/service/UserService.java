package personal.projectmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import personal.projectmanagement.model.Designation;
import personal.projectmanagement.model.Role;
import personal.projectmanagement.model.Task;
import personal.projectmanagement.model.User;
import personal.projectmanagement.model.UserProfile;
import personal.projectmanagement.repository.UserRepo;

@Service
public class UserService {

    @Autowired
    UserRepo userRepo;

    public List<User> findAllUsers() {
        return userRepo.findAllUsers();
    }

    public User findUserById(Integer id) {
        return userRepo.findUserById(id);
    }

    public UserProfile findUserProfileById(Integer id) {
        return userRepo.findUserProfileById(id);
    }

    public List<Role> retrieveRoles() {
        return userRepo.retrieveRoles();
    }

    public List<Designation> retrieveDesignations() {
        return userRepo.retrieveDesignations();
    }

    public Boolean createUser(User user) {
        return userRepo.createUser(user);
    }

    public Boolean createTask(Task task) {
        return userRepo.createTask(task);
    }

    public Boolean deleteTask(Integer taskId) {
        return userRepo.deleteTask(taskId);
    }

    public List<Task> findTaskByUser(Integer userId) {
        return userRepo.findAllTaskByUser(userId);
    }

    public Boolean editTask(Task task) {
        return userRepo.editTask(task);
    }
}
