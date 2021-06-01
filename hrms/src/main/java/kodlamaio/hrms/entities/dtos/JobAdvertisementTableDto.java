package kodlamaio.hrms.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Data

@NoArgsConstructor
public class JobAdvertisementTableDto {

    //Listede firmadı, genel iş pozisyonu adı, açık pozisyon adedi, yayın tarihi, son başvuru tarihi bilgileri olmalıdır.
    private int id;
    private String companyName;
    private String jobPosition;
    private int openPosition;
    private Date createdDate;
    private LocalDate applicationDeadline;

    public JobAdvertisementTableDto(int id, String companyName, String jobPosition, int openPosition, Date createdDate, LocalDate applicationDeadline) {
        this.id = id;
        this.companyName = companyName;
        this.jobPosition = jobPosition;
        this.openPosition = openPosition;
        this.createdDate = createdDate;
        this.applicationDeadline = applicationDeadline;
    }
}
