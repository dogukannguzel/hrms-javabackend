package kodlamaio.hrms.entities.abstracts;



import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
@Inheritance(strategy = InheritanceType.JOINED)
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public abstract class User {

    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private int id;

    @Column(name = "email_address")
    private String email;


    @Column(name = "password")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    @Column(name = "uuid")
    private String uuid;

    @Column(name = "is_verified")
    private boolean isVerified;


    @Column(name = "created_date")
    private LocalDateTime createdDate=LocalDateTime.now();


    @LastModifiedDate()
    @Column(name = "updated_date")
    private LocalDateTime uptadedDate;


    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public User(int id) {
        this.id=id;

    }
}
