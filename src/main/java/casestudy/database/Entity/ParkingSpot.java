package casestudy.database.Entity;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;



@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "parkingspots")
public class ParkingSpot {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @NonNull
    @Column(name = "zipcode", nullable = false)
    private Integer zipcode;

    @NonNull
    @Column(name = "price", nullable = false, precision = 2)
    private Double price;

   // @NonNull
    @Column(name = "rating", nullable = false)
    private Integer rating;

    @NonNull
    @Column(name = "status", nullable = false, length = 50)
    private String status;


    @NonNull
    @Column(name = "state", nullable = false, length = 50)
    private String state;

    @NonNull
    @Basic
    @Column(name = "date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;


    @NonNull
    @Column(name = "quantity", nullable = false)
    private int quantity;


    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "company_id")
    @ToString.Exclude
    private Company company;

    public ParkingSpot() {

    }


}
