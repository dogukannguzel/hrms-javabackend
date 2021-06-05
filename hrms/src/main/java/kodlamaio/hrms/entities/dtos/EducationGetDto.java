package kodlamaio.hrms.entities.dtos;

import kodlamaio.hrms.entities.concretes.Education;
import kodlamaio.hrms.entities.concretes.Graduate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EducationGetDto {

    private int id;
    private String schoolName;
    private String description;
    private String schoolDepartment;
    private LocalDate startedDate;
    private LocalDate endedDate;
}
