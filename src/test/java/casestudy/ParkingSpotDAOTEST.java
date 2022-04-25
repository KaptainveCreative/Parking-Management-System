package casestudy;


import casestudy.database.DAO.ParkingSpotDAO;
import casestudy.database.DAO.UserDAO;
import casestudy.database.Entity.User;
import casestudy.database.Entity.ParkingSpot;

import lombok.NonNull;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;
import java.util.Optional;


@DataJpaTest
@ActiveProfiles({"test", "default"})
public class ParkingSpotDAOTEST {

    @Autowired
    UserDAO userDAO;

    @Autowired
    ParkingSpotDAO parkingSpotDAO;

    @Test

    public void findByStatus() {
        Optional<ParkingSpot> parkingSpot = parkingSpotDAO.findById(1);



      //  Assertions.assertThat(parkingSpot.getById()).isEqualTo(1);
    }


}
