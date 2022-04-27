package casestudy;


import casestudy.database.DAO.CompanyDAO;
import casestudy.database.DAO.ParkingSpotDAO;
import casestudy.database.Entity.Company;
import casestudy.database.Entity.ParkingSpot;
import casestudy.database.Entity.Reservation;

import lombok.NonNull;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.repository.query.Param;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ActiveProfiles;


import java.util.Date;


@DataJpaTest
@ActiveProfiles({"test", "default"})

public class ReserveDAOTest {

    @Autowired
     ParkingSpotDAO parkingSpotDAO;


    @Autowired
    CompanyDAO companyDAO;

//Reservation getByZipcode(@Param("zipcode") Integer zipcode);

//    @Test
//    public void getByZipcode(){
//        Company company = new Company();
//        company.setCompanyName("Parkers");
//        company.setId(1);
//        companyDAO.save(company);
//
//        ParkingSpot spotOne = new ParkingSpot(55124, 6.25, 5, "Not Available", "MN",new Date(), 3);
//        spotOne.setCompany(company);
//
//
//        parkingSpotDAO.save(spotOne);
//
//        Assertions.assertThat(spotOne.getZipcode()).isEqualTo(spotOne.getZipcode());
//    }


}
