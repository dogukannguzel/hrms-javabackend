package kodlamaio.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import kodlamaio.hrms.entities.abstracts.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@PrimaryKeyJoinColumn(name = "id")
@Table(name = "candidates")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","resumeList"})
public class Candidate extends User {

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "identification_number")
    private String identificationNumber;

    @Column(name = "birth_date")
    private LocalDate birthDate;

    @OneToMany(mappedBy = "candidate")
    private List<Resume> resumeList;

}
