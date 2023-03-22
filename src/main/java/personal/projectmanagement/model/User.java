package personal.projectmanagement.model;

import java.sql.Date;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Integer id;

    @Size(min = 4, max = 20, message = "Username cannot be lesser than 4 characters and more than 20 characters.")
    @NotBlank
    private String username;

    @NotBlank(message = "Field cannot be blank.")
    @Size(min = 4, max = 50, message = "Username cannot be lesser than 4 characters and more than 50 characters.")
    private String fullName;

    @NotBlank(message = "Field cannot be blank.")
    @Email(message = "Invalid email address.")
    private String email;

    @NotBlank(message = "Field cannot be blank.")
    private String password;

    @NotNull(message = "Field cannot be blank.")
    private Integer phone;

    @NotNull(message = "Field cannot be blank.")
    private Date dateOfBirth;

    @NotBlank(message = "Field cannot be blank.")
    private String gender;

    @NotNull(message = "Field cannot be blank.")
    private Integer roleId;

    @NotNull(message = "Field cannot be blank.")
    private Integer designationId;
}
