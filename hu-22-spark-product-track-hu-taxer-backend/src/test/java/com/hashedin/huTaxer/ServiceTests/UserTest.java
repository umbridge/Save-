package com.hashedin.huTaxer.ServiceTests;

import com.hashedin.huTaxer.Modal.User;
import com.hashedin.huTaxer.Repository.UserRepository;
import com.hashedin.huTaxer.Services.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserTest {

    @Autowired
    private UserService userService;

    @MockBean
    private UserRepository userRepository;


    @BeforeEach
        void setup(){
        Optional<User> user = Optional.of(new User(1,"Gaurav","Kandpal","gauravgk","gk@gmail.com","HashedIn","gaurav123",null,null));
        Mockito.when(userRepository.findById(1)).thenReturn(user);
    }
    @Test
    void userTest() {
        String userName = "Gaurav";
        Optional<User> user = userRepository.findById(1);

    }
}
