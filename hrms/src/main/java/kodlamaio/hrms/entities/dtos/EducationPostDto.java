package kodlamaio.hrms.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EducationPostDto {
    private int id;
    private int resumeId;
    private int graduateId;
    private String schoolName;
    private String schoolDepartment;
    private LocalDate startedDate;
    private LocalDate endedDate;

}
