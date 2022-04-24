package casestudy;


import casestudy.database.DAO.UserDAO;
import casestudy.database.Entity.User;

import lombok.NonNull;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ActiveProfiles;


import java.util.Date;
import java.util.Optional;


@DataJpaTest
@ActiveProfiles({"test", "default"})

public class UserDAOTEST {

    @Autowired
    UserDAO userDAO;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;


    @Test
    public void findByEmail() {
        User userOne = new User("Kamaru", "Usman", "usman@ufc.com", "Credit Card",
                "123456789", new Date(), passwordEncoder.encode("password"));

        userDAO.save(userOne);


        //  User actual = userDAO.findByEmail("Khalid");

        Assertions.assertThat(userOne.getEmail()).isEqualTo("khalid");

    }

    @Test
    public void findByFirstName() {
        User userOne = new User();
        userOne.setFirstName("Aljo");

        Assertions.assertThat(userOne.getFirstName()).isEqualTo("Mohamed");
    }


    @ParameterizedTest
    void parameterizedTest(String email, String phoneNumber) {
        User expected = new User();

        expected.setEmail(email);
        expected.setPhoneNumber(phoneNumber);

        userDAO.save(expected);

        Optional<User> actual = userDAO.findById(expected.getId());

        Assertions.assertThat(expected).isEqualTo(actual);

    }


}
