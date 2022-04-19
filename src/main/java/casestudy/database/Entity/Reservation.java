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

//    @Column(name = "status", nullable = false, length = 45)
//    private String status;
//

    //@DateTimeFormat(pattern = "yyyy-MM-dd")
    //@Temporal()
    //    @Temporal(TemporalType.DATE)


    @Basic
    @Column(name ="date")
    @Temporal( TemporalType.TIMESTAMP)
    private Date date;
    //private LocalDate birthDate;
//    @Column(name = "date", nullable = false)



//
//    @Column(name = "confirmation_message", nullable = false, length = 100)
//    private String confirmationMessage;


//    @Basic
//    @Column(name = "users_id", nullable = false)
//    private Integer usersId;


//    @Basic
//    @Column(name = "parkingspots_id", nullable = false)
//    private Integer parkingspotsId;


    @ManyToOne ( fetch = FetchType.LAZY)
    @JoinColumn(name = "users_id", referencedColumnName = "id", nullable = false)
    private User user;


    @ManyToOne ( fetch = FetchType.LAZY)
    @JoinColumn(name = "parkingspots_id", referencedColumnName = "id", nullable = false)
    private ParkingSpot parkingspot;

//    @ManyToOne(fetch = FetchType.LAZY, optional = false)
//    @JoinColumn(name = "parkingspots_id", nullable = false)
//    private ParkingSpot parkingSpot;


}
