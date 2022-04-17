package casestudy.database.DAO;


import casestudy.database.Entity.ParkingSpot;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ParkingSpotDAO extends JpaRepository<ParkingSpot, Long> {

    //public User findBy(@Param("email") String email);

    public List<ParkingSpot> findAll();




    //    I can't seem to grab the company name using this query
    //@Query( value = " SELECT distinct c.company_name , p.status , p.rating , p.price , p.quantity , p.zipcode , p.date , p.state " + " from parkingspots p  join companies c on p.company_id = c.id " + "where p.state=:state " + " limit 1", nativeQuery = true)
    //public List<ParkingSpot> findParkingSpotByStateIgnoreCase(@Param("state") String state);


//    @Query( value = " SELECT distinct c.company_name , p.status , p.rating , p.price , p.quantity , p.zipcode , p.date , p.state " + " from parkingspots p  join companies c on p.company_id = c.id " + "where p.state=:state " + " limit 1", nativeQuery = true)
//    public List<Object[]> getInfo(@Param("state") String state);


    //@Query( value = " SELECT distinct c.company_name , p.status , p.rating , p.price , p.quantity , p.zipcode , p.date , p.state  from parkingspots p , companies c  where p.state=:state " + " limit 1", nativeQuery = true)
    public List<ParkingSpot> findByStateIgnoreCase(@Param("state") String state); // ask Eric for the custom Query

    //public List<ParkingSpot> findParkingSpotByStatus(@Param("status")  String status) ;


}
