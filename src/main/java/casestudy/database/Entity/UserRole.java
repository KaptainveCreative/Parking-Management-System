package casestudy.database.Entity;

import lombok.*;

import javax.persistence.*;
import java.util.*;

@Getter
@Setter
@ToString

@Entity
@Table(name = "user_roles")
public class UserRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "user_role")
    private String userRole;
}
