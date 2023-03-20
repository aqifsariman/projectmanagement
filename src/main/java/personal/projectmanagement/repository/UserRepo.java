package personal.projectmanagement.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import personal.projectmanagement.model.User;

@Repository
public class UserRepo {

    @Autowired
    JdbcTemplate jdbcTemplate;

    private final String ALL_USERS_SQL = "select * from user";
    private final String USER_BY_ID_SQL = "select * from user where id = ?";
    private final String CREATE_USER_SQL = "insert into user (username, full_name, email, password, phone, date_of_birth, gender, role_id, designation_id) values (?, ?, ?, ?, ?, ?, ?, ?, ?)";

    public List<User> findAllUsers() {
        return jdbcTemplate.query(ALL_USERS_SQL, BeanPropertyRowMapper.newInstance(User.class));
    }

    public User findUserById(Integer id) {
        return jdbcTemplate.queryForObject(USER_BY_ID_SQL, BeanPropertyRowMapper.newInstance(User.class), id);
    }

    public Boolean createUser(User user) {
        Integer insertUser = jdbcTemplate.update(CREATE_USER_SQL, user.getUsername(),
                user.getFullName(), user.getEmail(),
                user.getPassword(), user.getPhone(),
                user.getDateOfBirth(), user.getGender(),
                user.getRoleId(), user.getDesignationId());

        return (insertUser > 0) ? true : false;
    }

}