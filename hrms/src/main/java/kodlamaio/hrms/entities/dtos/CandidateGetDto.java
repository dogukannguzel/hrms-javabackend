package kodlamaio.hrms.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CandidateGetDto {

    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private LocalDate birthDate;

}
