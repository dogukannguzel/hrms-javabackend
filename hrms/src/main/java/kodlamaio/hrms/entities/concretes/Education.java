package kodlamaio.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
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
@Table(name = "resume_edu")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Education {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToOne(targetEntity = Resume.class)
    private Resume resume;

    @Column(name = "school_name")
    private String schoolName;

    @ManyToOne(targetEntity = Graduate.class,optional = false)
    @JoinColumn(name = "graduate_id",referencedColumnName = "id",nullable = false)
    private Graduate graduate;

    @Column(name = "school_department")
    private String schoolDepartment;

    @Column(name = "started_date")
    private LocalDate startedDate;

    @Column(name = "ended_date")
    private LocalDate endedDate;

    @CreationTimestamp
    @Temporal(TemporalType.DATE)
    @Column(name = "created_date")
    private Date createdDate;

}
