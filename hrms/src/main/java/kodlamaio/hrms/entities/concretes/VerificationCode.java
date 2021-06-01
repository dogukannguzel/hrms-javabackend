package kodlamaio.hrms.entities.concretes;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.time.LocalDate;

import java.util.Date;

@Entity
@Table(name = "verification_codes")
@Data
@AllArgsConstructor
@NoArgsConstructor
public  class VerificationCode {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "user_id")
    private int userİd;


    @Column(name = "code")
    private String code;

    @Column(name = "is_verified")
    private boolean isVerified=false;

    @Column(name = "created_date")
    private LocalDate createdDate=LocalDate.now();

    @Column(name = "confirm_date")
    private LocalDate confirmDate;

    @Column(name="expiration_date")
    private Date expirationDate;

    public VerificationCode(int userİd, String code,Date expirationDate) {
        this.userİd = userİd;
        this.code = code;
        this.expirationDate=expirationDate;
    }


}
