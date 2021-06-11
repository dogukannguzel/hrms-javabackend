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

    //Tüm bilgiler için dto

    private int id;

    private String jobDescription;

    private int minSalary;

    private int maxSalary;

    private int openPosition;

    private LocalDate applicationDeadline;

    private String cityName;

    private String companyName;

    private String jobPosition;

    private String workPlaceType;

    private String workType;

    @JsonFormat(shape= JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date createdDate;





}
