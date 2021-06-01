package kodlamaio.hrms.entities.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobAdvertisementGetDto {

    private int id;

    private String jobDescription;

    private int minSalary;

    private int maxSalary;

    private int openPosition;

    private LocalDate applicationDeadline;

    private String city;

    private String companyName;

    private String jobPosition;

    @JsonFormat(shape= JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date createdDate;





}