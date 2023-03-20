package personal.projectmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import personal.projectmanagement.model.Task;
import personal.projectmanagement.model.User;
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

    public Boolean createUser(User user) {
        return userRepo.createUser(user);
    }

    public Boolean createTask(Task task){
        return userRepo.createTask(task);
    }
}
