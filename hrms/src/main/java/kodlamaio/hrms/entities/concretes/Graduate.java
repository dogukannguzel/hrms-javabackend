package kodlamaio.hrms.entities.concretes;


import kodlamaio.hrms.core.validation.annotations.ExistByGraduate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
@Table(name = "edu_graduates")
public class Graduate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "description")
    @ExistByGraduate
    private String description;


}
