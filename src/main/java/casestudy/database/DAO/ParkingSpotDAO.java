package casestudy.database.DAO;


import casestudy.database.Entity.ParkingSpot;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ParkingSpotDAO extends JpaRepository<ParkingSpot, Integer> {

    @Query(value = "select * from parkingspots", nativeQuery = true)
    public List<ParkingSpot> findAll();


    public List<ParkingSpot> findByStatus(String status);


    public List<ParkingSpot> findByStateIgnoreCase(@Param("state") String state); // ask Eric for the custom Query


}
