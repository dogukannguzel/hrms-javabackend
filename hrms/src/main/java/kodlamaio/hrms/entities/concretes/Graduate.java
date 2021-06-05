package kodlamaio.hrms.entities.concretes;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import kodlamaio.hrms.core.validation.annotations.ExistByGraduate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
@Table(name = "edu_graduates")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","educations"})
public class Graduate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "description")
    @ExistByGraduate
    private String graduateDescription;

    @OneToMany(mappedBy = "graduate")
    private List<Education> educations;
}
