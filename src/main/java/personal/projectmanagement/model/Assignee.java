package personal.projectmanagement.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Assignee {
    private Integer id;

    private String assigneeName;

    private Integer userId;
}
