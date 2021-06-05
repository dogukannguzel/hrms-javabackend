package kodlamaio.hrms.entities.dtos;

import kodlamaio.hrms.core.validation.annotations.ExistByEmail;
import kodlamaio.hrms.core.validation.annotations.ExistByİdentificationNumber;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

import java.time.LocalDate;


@Data
@AllArgsConstructor
@NoArgsConstructor

public class CandidatesRegisterDto {

    @NotBlank(message="İsim Alanı Boş olamaz")
    private String firstName;

    @NotBlank(message="Soy isim Alanı Boş olamaz")
    private String lastName;

    @NotBlank(message="Tc kimlik no alanı boş olamaz")
    @Size(min = 11, max=11, message = "TCKimlik No 11 hane olmalıdır")
    @ExistByİdentificationNumber
    private String identificationNumber;

    @NotNull(message = "Doğum tarihi alanı boş bırakılamaz ")
    private LocalDate birthDate;

    @Email(message = "E mail adresinizi doğru formatta giriniz")
    @NotBlank(message = "E mail adresi boş olamaz ")
    @ExistByEmail
    private String email;

    @NotBlank(message = "Parola boş olamaz")
    @Size(min = 6,max = 14,message = "Parolanız en az 6 en çok 14 karekter olabilir")
    private String password;

    @NotBlank(message = "Parola boş olamaz")
    @Size(min = 6,max = 14,message = "Parolanız en az 6 en çok 14 karekter olabilir")
    private String confirmPassword;


}
