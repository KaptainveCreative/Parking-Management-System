package casestudy.database.DAO;


import casestudy.database.Entity.User;
import casestudy.database.Entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface UserRoleDAO extends JpaRepository<UserRole, Long>{

    //List<UserRole> findByUserid(@Param("userid") Integer userId);

    List<UserRole> findByUserId(@Param("userId") Integer userId);


}
