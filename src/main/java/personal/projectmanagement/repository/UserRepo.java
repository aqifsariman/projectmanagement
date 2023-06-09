package personal.projectmanagement.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import personal.projectmanagement.model.Designation;
import personal.projectmanagement.model.Role;
import personal.projectmanagement.model.Task;
import personal.projectmanagement.model.User;
import personal.projectmanagement.model.UserProfile;

@Repository
public class UserRepo {

    @Autowired
    JdbcTemplate jdbcTemplate;

    private final String ALL_USERS_SQL = "select * from user";
    private final String USER_BY_ID_SQL = "select * from user where id = ?";
    private final String USER_PROFILE_SQL = "select user.id, user.username, user.full_name, user.email, user.phone, designation.designation_name, role.role_name, user.date_of_birth from user inner join designation on user.designation_id = designation.id inner join role on role.id = user.role_id where user.id =  ?";
    private final String CREATE_USER_SQL = "insert into user (username, full_name, email, password, phone, date_of_birth, gender, role_id, designation_id) values (?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private final String CREATE_TASK_SQL = "insert into task (title, description, status_id, priority_id, assignee_id, user_id) values (?, ?, ? ,? ,? ,?)";
    private final String DELETE_TASK_SQL = "delete from task where id = ?";
    private final String ALL_TASK_BY_USER_SQL = "select * from task where user_id = ?";
    private final String EDIT_TASK_SQL = "update task set title = ?, description = ?, status_id = ?, priority_id = ? where id = ?";
    private final String ROLES_SQL = "select * from role";
    private final String DESIGNATION_SQL = "select * from designation";

    public List<User> findAllUsers() {
        return jdbcTemplate.query(ALL_USERS_SQL, BeanPropertyRowMapper.newInstance(User.class));
    }

    public User findUserById(Integer id) {
        return jdbcTemplate.queryForObject(USER_BY_ID_SQL, BeanPropertyRowMapper.newInstance(User.class), id);
    }

    public UserProfile findUserProfileById(Integer id) {
        return jdbcTemplate.queryForObject(USER_PROFILE_SQL, BeanPropertyRowMapper.newInstance(UserProfile.class), id);
    }

    public List<Role> retrieveRoles() {
        return jdbcTemplate.query(ROLES_SQL, BeanPropertyRowMapper.newInstance(Role.class));
    }

    public List<Designation> retrieveDesignations() {
        return jdbcTemplate.query(DESIGNATION_SQL, BeanPropertyRowMapper.newInstance(Designation.class));
    }

    public Boolean createUser(User user) {
        Integer insertUser = jdbcTemplate.update(CREATE_USER_SQL, user.getUsername(),
                user.getFullName(), user.getEmail(),
                user.getPassword(), user.getPhone(),
                user.getDateOfBirth(), user.getGender(),
                user.getRoleId(), user.getDesignationId());
        return (insertUser > 0) ? true : false;
    }

    public Boolean createTask(Task task) {
        Integer insertTask = jdbcTemplate.update(CREATE_TASK_SQL, task.getTitle(),
                task.getDescription(), task.getStatusId(), task.getPriorityId(), task.getAssigneeId(),
                task.getUserId());
        return (insertTask > 0) ? true : false;
    }

    public Boolean deleteTask(Integer taskId) {
        Integer deleteTask = jdbcTemplate.update(DELETE_TASK_SQL, taskId);
        return (deleteTask > 0) ? true : false;
    }

    public List<Task> findAllTaskByUser(Integer userId) {
        return jdbcTemplate.query(ALL_TASK_BY_USER_SQL, BeanPropertyRowMapper.newInstance(Task.class), userId);
    }

    public Boolean editTask(Task task) {
        Integer edited = jdbcTemplate.update(EDIT_TASK_SQL, task.getTitle(), task.getDescription(), task.getStatusId(),
                task.getPriorityId(), task.getId());
        return (edited > 0) ? true : false;
    }

}
