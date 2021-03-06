package kodlamaio.hrms.entities.concretes;


import kodlamaio.hrms.entities.abstracts.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@PrimaryKeyJoinColumn(name = "id")
@Table(name = "employees")
public class Employee extends User {

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

}
