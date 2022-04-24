package casestudy.database.DAO;

import casestudy.database.Entity.ParkingSpot;
import casestudy.database.Entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ReviewDAO extends JpaRepository<Review, Integer> {


    public List<Review> findAll();


}
