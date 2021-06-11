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
@Table(name = "resume_job_exp")
public class JobExperience {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne(targetEntity = Resume.class)
    private Resume resume;

    @Column(name = "corporat_name")
    private String corporatName;

    @Column(name = "position")
    private String position="ceo";

    @Column(name = "started_date")
    private LocalDate startedDate;

    @Column(name = "ended_date")
    private LocalDate endedDate;

    @CreationTimestamp
    @Temporal(TemporalType.DATE)
    @Column(name = "created_date")
    private Date createdDate;


}
