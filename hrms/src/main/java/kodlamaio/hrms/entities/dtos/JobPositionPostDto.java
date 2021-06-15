package kodlamaio.hrms.entities.dtos;

import kodlamaio.hrms.business.validationRules.annotations.ExistsByPosition;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobPositionPostDto {

    private int id;

    @ExistsByPosition
    @NotBlank
    @NotNull(message = "Pozisyon ismi boş geçilemez")
    private String position;

}
