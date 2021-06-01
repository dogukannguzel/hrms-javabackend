package kodlamaio.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
@Table(name = "resume_langs")
public class Language {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne(targetEntity = Resume.class)
    private Resume resume;

    @Column(name = "language")
    private String language;

    @Column(name = "lang_level")
    private char langLevel;

    @CreationTimestamp
    @Temporal(TemporalType.DATE)
    @Column(name = "created_date")
    private Date createdDate;

}
