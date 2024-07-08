package com.example.demo;

import Bug.Entity.User;
import Bug.Repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;


//@DataJpaTest
//@SpringBootTest
//public class UserRepositoryTests {
//    @Autowired
//    private TestEntityManager entityManager;
//
//    @Autowired
//    private UserRepository userRepository;
//
//    @Test
//    public void whenFindAll_thenReturnUsers() {
//        // given
//        User user = new User();
//        user.setUserName("testUser");
//        user.setEmail("test@example.com");
//        entityManager.persist(user);
//        entityManager.flush();
//
//
//        List<User> foundUsers = userRepository.findAll();
//
//        assertThat(foundUsers).isNotEmpty();
//        assertThat(foundUsers.get(0).getUserName()).isEqualTo(user.getUserName());
//    }
//}
