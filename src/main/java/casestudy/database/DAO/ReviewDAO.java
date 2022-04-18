package casestudy.database.DAO;

import casestudy.database.Entity.ParkingSpot;
import casestudy.database.Entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewDAO extends JpaRepository<Review, Integer> {


    //have a list of the companies and let the user review them accordingly to what they got from them

    public List<Review> findAll();




}
