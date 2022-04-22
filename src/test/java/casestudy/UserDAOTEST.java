package casestudy;


import casestudy.database.DAO.UserDAO;
import casestudy.database.Entity.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;


@DataJpaTest
public class UserDAOTEST {

        @Autowired
        UserDAO userDAO;



//    @Test
//    public void findByEmail() {
//            User expected = new User();
//            expected.setEmail("uuusman@ufc.com");
//
//            User actual = userDAO.findByEmail("usman@ufc.com");
//
//        Assertions.assertEquals(expected.getEmail(), actual.getEmail());
//
//    }
//
//    @Test
//    public void findByEmailTest(){
//
//        User user = User.builder().emailTest("usman@ufc.com").build();
//
//        userDAO.save(user);
//
//        Assertions.assertThat(user.getId());
//
//    }


}
