package personal.projectmanagement.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserProfile {

    private Integer id;

    private String username;

    private String fullName;

    private String email;

    private Integer phone;

    private String designationName;

    private String roleName;
}
