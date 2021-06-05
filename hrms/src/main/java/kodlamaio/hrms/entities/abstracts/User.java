package kodlamaio.hrms.entities.abstracts;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import kodlamaio.hrms.entities.concretes.VerificationCode;
import lombok.AllArgsConstructor;
import lombok.Data;

import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;


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
    private String password;

    @Column(name = "uuid")
    private String uuid;


    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public User(int id) {
        this.id=id;

    }
}
