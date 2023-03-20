package personal.projectmanagement.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Task {
    private Integer id;

    private String title;

    private String description;

    private Integer statusId;

    private Integer priorityId;

    private Integer assigneeId;

    private Integer userId;
}
