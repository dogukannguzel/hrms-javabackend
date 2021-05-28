package kodlamaio.hrms.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployerRegisterDto {

    @NotBlank(message = "Şirket adı boş bırakılamaz.")
    private String companyName;
    @NotBlank(message = "Web sitesi adresi boş bırakılamaz.")
    private String webAddress;

    @NotBlank(message = "E mail alanı boş bırakılamaz")
    private String email;

    @NotBlank(message = "Telefon numarası alanı boş bırakılamaz")
    private String phoneNumber;

    @NotBlank(message = "Parola alanı boş bırakılamaz")
    @Size(min = 6,max = 14,message = "Parolanız en az 6 en çok 14 karekter olabilir")
    private String password;


    @NotBlank(message = "Parola alanı boş bırakılamaz")
    @Size(min = 6,max = 14,message = "Parolanız en az 6 en çok 14 karekter olabilir")
    private String confirmPassword;
}
