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
@Table(name = "reviews")
public class Review {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;


    @Column(name = "customer_name", nullable = false)
    private String customerName;

    @Lob
    @Column(name = "customer_reviews")
    private String customerReviews;




    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;



}
