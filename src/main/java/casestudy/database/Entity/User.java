package casestudy.database.Entity;
import lombok.*;
import javax.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Basic
    @Column(name = "first_name", nullable = false, length = 255)
    private String firstName;

    @Basic
    @Column(name = "last_name", nullable = false, length = 255)
    private String lastName;

    @Basic
    @Column(name = "Email", nullable = false, length = 255)
    private String email;

    @Basic
    @Column(name = "payment_method")
    private String paymentMethod;

    @Basic
    @Column(name = "phone_number")
    private String phoneNumber;

    @Basic
    @Column(name ="date")
    @Temporal( TemporalType.TIMESTAMP)
    private Date date;

//    @Column(name = "date", nullable = false)
////    @Temporal(TemporalType.DATE)
//    @Temporal( TemporalType.TIMESTAMP)
//    private Date date;


    @Basic
    @Column(name = "password", nullable = false, length = 45)
    private String password;

//    @OneToMany(mappedBy = "user")
//    private List<Reservation> reservations = new ArrayList<>();


}
