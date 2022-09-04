package com.hashedin.huTaxer.ControllerTest;


import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hashedin.huTaxer.Modal.User;
import com.hashedin.huTaxer.Modal.UserDetails;
import com.hashedin.huTaxer.Repository.UserRepository;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest
public class UserControlerTest {

    private MockMvc mvc;
    @Autowired
    private WebApplicationContext context;
    @Autowired
    UserRepository repository;

    ObjectMapper objectMapper = new ObjectMapper();

    public String mapToJson(Object obj) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(obj);
    }

    public <T> T mapFromJson(String json, Class<T> clazz)
            throws JsonParseException, JsonMappingException, IOException {

        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(json, clazz);
    }

    @BeforeEach
    public void setUp() {
        mvc = MockMvcBuilders.webAppContextSetup(context).build();

    }

    @Order(1)
    @Test
    public void addUser() throws Exception {

        User user = new User();
        user.setUserId(13);
        user.setUserPassword("hello1234");
        user.setUserName("gauravgk");
        user.setUserFirstName("Gaurav");
        user.setUserLastName("Kandpal");
        user.setUserEmail("gk@gmail.com");
        user.setUserCompany("Hashedin");

        String JsonRequest = objectMapper.writeValueAsString(user);

//        System.out.println(mvc);
        MvcResult result = (MvcResult) mvc.perform(post("/addUser").content(JsonRequest).contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk()).andReturn();

        String resultContext = result.getResponse().getContentAsString();

        User responseUser = objectMapper.readValue(resultContext, User.class);

        assertTrue(responseUser.getUserFirstName().equals("Gaurav"));

    }

    @Order(2)
    @Test
    public void getUsers() throws Exception {
        String uri = "/getAll";
        MvcResult result = mvc.perform(get(uri).contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk()).andReturn();
        int status = result.getResponse().getStatus();
        assertEquals(200, status);
        String resultContext = result.getResponse().getContentAsString();
        User[] users = mapFromJson(resultContext, User[].class);
        assertTrue(users.length > 0);
    }


    @Order(3)
    @Test
    public User getByEmail() throws Exception {
        String uri = "/getUser";

        MvcResult result = mvc.perform(get(uri).contentType(MediaType.APPLICATION_JSON_VALUE).param("email", "gk@gmail.com"))
                .andExpect(status().isOk()).andReturn();

        String resultContext = result.getResponse().getContentAsString();

        User responseUser = objectMapper.readValue(resultContext, User.class);

        assertTrue(responseUser.getUserCompany().equals("Hashedin"));
        return responseUser;
    }

    @Order(4)
    @Test
    public void updateUser() throws Exception {
        String uri = "/updateUser";
        User user = getByEmail();
        UserDetails userDetails = new UserDetails();
        userDetails.setAge(25);
        userDetails.setBasicSalary(1000000);
        user.setUserDetails(userDetails);
        String JsonRequest = objectMapper.writeValueAsString(user);

        MvcResult result = (MvcResult) mvc.perform(put("/updateUser").content(JsonRequest).contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk()).andReturn();


        String resultContext = result.getResponse().getContentAsString();

        User responseUser = objectMapper.readValue(resultContext, User.class);

        assertTrue(responseUser.getUserDetails()!=null);
        assertEquals(responseUser.getUserDetails().getBasicSalary(),1000000);

    }

    @Order(5)
    @Test
    public void updatePassword() throws Exception {
        String uri = "/forgotPassword";

        MvcResult result = mvc.perform((put(uri).contentType(MediaType.APPLICATION_JSON_VALUE)).param("email","gk@gmail.com").param("pass","Gaurav@123"))
                .andExpect(status().isOk()).andReturn();

        String resultContext = result.getResponse().getContentAsString();

        User responseUser = objectMapper.readValue(resultContext, User.class);

        assertEquals(responseUser.getUserPassword(),"Gaurav@123");
    }

    @Order(6)
    @Test
    public void removeUsers() throws Exception {
        String uri = "/removeAll";
        MvcResult result = mvc.perform(delete(uri).contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk()).andReturn();
        int status = result.getResponse().getStatus();
        assertEquals(200, status);

    }


}
