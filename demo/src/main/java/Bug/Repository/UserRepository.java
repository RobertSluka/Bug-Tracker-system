package java.Bug.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.Bug.Entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUserName(String UserName);
    @Query("SELECT CASE WHEN COUNT(u) > 0 THEN true ELSE false END FROM User u WHERE u.userName = :userName AND u.password = :password")

    boolean checkPassword(@Param("userName") String userName, @Param("password") String password);
    Boolean existsByUserName(String UserName);
}
