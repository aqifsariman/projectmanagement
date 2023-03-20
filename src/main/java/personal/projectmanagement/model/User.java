package personal.projectmanagement.model;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Integer id;

    private String username;

    private String fullName;

    private String email;

    private String password;

    private Integer phone;

    private Date dateOfBirth;

    private String gender;

    private Integer roleId;

    private Integer designationId;
}
