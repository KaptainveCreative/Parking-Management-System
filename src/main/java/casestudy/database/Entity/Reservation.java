package casestudy.database.Entity;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Date;


@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "reservations")
public class Reservation {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;


    @Column(name = "zipcode", nullable = false)
    private Integer zipcode;



    @Basic
    @Column(name ="date")
    @Temporal( TemporalType.TIMESTAMP)
    private Date date;
    //private LocalDate birthDate;
//    @Column(name = "date", nullable = false)



    @ToString.Exclude
    @ManyToOne ( fetch = FetchType.LAZY)
    @JoinColumn(name = "users_id", referencedColumnName = "id", nullable = false)
    private User user;



    @ToString.Exclude
    @ManyToOne ( fetch = FetchType.LAZY)
    @JoinColumn(name = "parkingspots_id", referencedColumnName = "id", nullable = false)
    private ParkingSpot parkingspot;



}
