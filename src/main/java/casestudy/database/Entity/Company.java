package casestudy.database.Entity;

import lombok.*;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "companies")
public class Company {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)

    private Integer id;

    @Column(name = "company_name", nullable = false, length = 45)
    private String companyName;


    @OneToMany(mappedBy = "company")
    private List<ParkingSpot> parkingSpots = new ArrayList<>();


}
