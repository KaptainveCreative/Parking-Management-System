package casestudy.database.DAO;

import casestudy.database.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDAO extends JpaRepository<User, Long> {

    public List<User> findByFirstName(@Param("firstName") String firstName);


    public User findByEmail(@Param("email") String email);

    public User findByPhoneNumber(@Param("phone_number") String phoneNumber);




}
