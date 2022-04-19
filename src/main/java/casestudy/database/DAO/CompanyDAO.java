package casestudy.database.DAO;

import casestudy.database.Entity.Company;
import casestudy.database.Entity.ParkingSpot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompanyDAO extends JpaRepository<Company, Integer> {


    public List<Company> findAll();
}
