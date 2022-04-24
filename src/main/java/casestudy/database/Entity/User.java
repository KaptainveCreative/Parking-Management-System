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
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User {


    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @NonNull
    @Basic
    @Column(name = "first_name", nullable = false, length = 255)
    private String firstName;

    @NonNull
    @Basic
    @Column(name = "last_name", nullable = false, length = 255)
    private String lastName;

    @NonNull
    @Basic
    @Column(name = "Email", nullable = false, length = 255)
    private String email;

    @NonNull
    @Basic
    @Column(name = "payment_method")
    private String paymentMethod;

    @NonNull
    @Basic
    @Column(name = "phone_number")
    private String phoneNumber;


    @NonNull
    @Basic
    @Column(name = "date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;


    @NonNull
    @Basic
    @Column(name = "password", nullable = false, length = 64)
    private String password;


    @OneToMany(mappedBy = "user")
    @ToString.Exclude
    private List<Reservation> reservations = new ArrayList<>();

    public User(Integer id, @NonNull String firstName, @NonNull String lastName, @NonNull String email, @NonNull String paymentMethod, @NonNull String phoneNumber, @NonNull Date date, @NonNull String password) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.paymentMethod = paymentMethod;
        this.phoneNumber = phoneNumber;
        this.date = date;
        this.password = password;
    }
}
