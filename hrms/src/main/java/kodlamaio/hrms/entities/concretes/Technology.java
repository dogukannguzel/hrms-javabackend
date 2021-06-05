package kodlamaio.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;

import java.util.Date;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
@Table(name = "resume_techs")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Technology {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne(targetEntity = Resume.class)
    private Resume resume;

    @Column(name="description")
    private String  techonologydescription;

    @CreationTimestamp
    @Temporal(TemporalType.DATE)
    @Column(name = "created_date")
    private Date createdDate;

}
