package casestudy.database.DAO;

import casestudy.database.Entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewDAO extends JpaRepository<Review, Long> {


    //have a list of the companies and let the user review them accordingly to what they got from them





}
