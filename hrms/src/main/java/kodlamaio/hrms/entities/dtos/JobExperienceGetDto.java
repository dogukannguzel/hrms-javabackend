package kodlamaio.hrms.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobExperienceGetDto {

    private int id;
    private int resumId;
    private String corporatName;
    private String position;
    private LocalDate startedDate;
    private LocalDate endedDate;


}
