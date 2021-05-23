package kodlamaio.hrms.entities.abstracts;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
@Inheritance(strategy = InheritanceType.JOINED)
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private int id;

    @Column(name = "email_address")
    private String email;

    @Column(name = "password")
    private String password;


}
