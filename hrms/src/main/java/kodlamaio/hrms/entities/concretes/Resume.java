package kodlamaio.hrms.entities.concretes;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
@Table(name = "resumes")
public class Resume {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne(targetEntity = Candidate.class)
    @JoinColumn(name = "candidate_id",referencedColumnName = "id",nullable = false)
    private Candidate candidate;

    @Column(name = "github_link")
    private String githubLink;

    @Column(name = "linked_link")
    private String linkedLink;

    @Column(name = "photo")
    private String photo;

    @Column(name = "description")
    private String cvDescription;

    @Column(name = "is_active")
    private boolean isActive;

    @OneToMany(mappedBy = "resume")
    private List<Language> languages;

    @OneToMany(mappedBy = "resume")
    private List<Education> educations;

    @OneToMany(mappedBy = "resume")
    private List<Technology> technologies;

    @OneToMany(mappedBy = "resume")
    private List<JobExperience> jobExperiences;

    @CreationTimestamp
    @Temporal(TemporalType.DATE)
    @Column(name = "created_date")
    private Date createdDate;


}
