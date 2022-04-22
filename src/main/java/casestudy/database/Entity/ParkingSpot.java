package casestudy.database.Entity;
import lombok.*;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@ToString
@Entity
@Table(name = "parkingspots")
public class ParkingSpot {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;


    @Column(name = "zipcode", nullable = false)
    private Integer zipcode;



    @Column(name = "price", nullable = false, precision = 2)
    private BigDecimal price;



    @Column(name = "rating", nullable = false)
    private Integer rating;



    @Column(name = "status", nullable = false, length = 50)
    private String status;

    @Column(name = "state", nullable = false, length = 50)
    private String state;

    @Basic
    @Column(name ="date")
    @Temporal( TemporalType.TIMESTAMP)
    private Date date;


    @Column(name = "quantity", nullable = false)
    private int quantity;

//
//    @Column(name = "cities_id", nullable = false)
//    private Integer citiesId;


//    @ManyToOne
//    @JoinColumn(name = "cities_id", referencedColumnName = "id", nullable = false)
//    private City cityId;

//    @OneToMany(mappedBy = "parkingspot")
//    private List<Reservation> reservations = new ArrayList<>();



    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "company_id", nullable = false)
    @ToString.Exclude
    private Company company;

}
