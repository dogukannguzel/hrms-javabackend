package kodlamaio.hrms.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class JobAdvertisementPostDto {

    // iş ilanı eklemek için dto

    @NotNull(message = "Şehir alanı boş bırakılamaz")
    private int cityId;

    private int id;

    private int companyId;

    @NotNull(message = "Pozisyon Adı alanı boş bırakılamaz")
    private int jobPositionId;

    private int minSalary;

    private int maxSalary;

    @NotNull(message = "Pozisyon adeti alanı boş bırakılamaz")
    private int openPosition;

    @NotNull(message = "İş ilanı açıklaması boş bırakılamaz")
    private String jobDescription;

    @NotNull(message = "İş ilanı bitiş süresi alanı boş bırakılamaz ")
    private LocalDate applicationDeadline;

    private boolean enable;
}
