package kodlamaio.hrms.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobExperiencePostDto {

    private int id;
    private String corporatName;
    private int resumeId;
    private int jobPositionId;
    private LocalDate startedDate;
    private LocalDate endedDate;

}
