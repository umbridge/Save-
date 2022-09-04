package com.hashedin.huTaxer.RepositoryTest;

import com.hashedin.huTaxer.Modal.User;
import com.hashedin.huTaxer.Repository.UserRepository;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class UserRepoTest {

    @Autowired
    UserRepository userRepository;



    @Test
    public void testFindByUserEmail() {
        User expectedUser = new User(1, "Gaurav","Kandpal","gauravgk", "gk@gmail.com", "HashedIn", "gauravgk123", null, null);
        userRepository.save(expectedUser);

        String UserName = "Gaurav";

        User actualResult = userRepository.findByUserEmail("gk@gmail.com");

        assertThat("Gaurav").isEqualTo(actualResult.getUserName());
        assertThat("HashedIn").isEqualTo(actualResult.getUserCompany());

    }

    @Test
    public void testFindByUserName() {
        User expectedUser = new User(2, "Rahul","Bhardwaj","rahulrb", "rb@gmail.com", "HashedIn", "rahulrb123", null, null);
        userRepository.save(expectedUser);



        User actualResult = userRepository.findByUserName("rahulrb");

        assertThat("rahulrb").isEqualTo(actualResult.getUserName());
        assertThat("HashedIn").isEqualTo(actualResult.getUserCompany());

    }

    @AfterEach
    public void removeObject()
    {
        userRepository.deleteAll();
    }

}
