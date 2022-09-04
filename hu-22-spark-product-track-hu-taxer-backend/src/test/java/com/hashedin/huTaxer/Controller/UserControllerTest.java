package com.hashedin.huTaxer.Controller;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hashedin.huTaxer.Modal.Section10;
import com.hashedin.huTaxer.Modal.Section24;
import com.hashedin.huTaxer.Modal.Section80C;
import com.hashedin.huTaxer.Modal.User;
import com.hashedin.huTaxer.Modal.UserDeductions;
import com.hashedin.huTaxer.Modal.UserDetails;
import com.hashedin.huTaxer.Services.UserService;

import java.util.ArrayList;

import java.util.HashMap;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {UserController.class})
@ExtendWith(SpringExtension.class)
class UserControllerTest {
    @Autowired
    private UserController userController;

    @MockBean
    private UserService userService;

    /**
     * Method under test: {@link UserController#addUser(User)}
     */
    @Test
    void testAddUser() throws Exception {
        Section10 section10 = new Section10();
        section10.setActualRentPaid(1L);
        section10.setChildEducationAllowance(1L);
        section10.setChildHostelAllowance(1L);
        section10.setHra(1L);
        section10.setLta(1L);
        section10.setMetro(true);
        section10.setOtherRepay(1L);
        section10.setSection10id(1L);

        Section24 section24 = new Section24();
        section24.setInterest(1L);
        section24.setPropertyTax(1L);
        section24.setRent(1L);
        section24.setSection24id(1L);

        Section80C section80C = new Section80C();
        section80C.setElss(1L);
        section80C.setEmployeeEpfContri(1L);
        section80C.setFd(1L);
        section80C.setHomeLoanPrincipal(1L);
        section80C.setLic(1L);
        section80C.setNps_80c(1L);
        section80C.setNsc(1L);
        section80C.setPpf(1L);
        section80C.setSection80cid(1L);
        section80C.setSsy(1L);
        section80C.setTutionFees(1L);
        section80C.setUlip(1L);

        UserDeductions userDeductions = new UserDeductions();
        userDeductions.setAdditionNps(1L);
        userDeductions.setCharityDonation(1L);
        userDeductions.setDeductionid(1L);
        userDeductions.setEducationLoanInterest(1L);
        userDeductions.setEmployerEpfContri(1L);
        userDeductions.setEmployerNpsContri(1L);
        userDeductions.setHomeLoanInterest(1L);
        userDeductions.setMedicalInsurance(1L);
        userDeductions.setSavingAccountInterest(3L);
        userDeductions.setSection10(section10);
        userDeductions.setSection24(section24);
        userDeductions.setSection80C(section80C);

        UserDetails userDetails = new UserDetails();
        userDetails.setAge(22);
        userDetails.setBasicSalary(1L);
        userDetails.setBusinessIncome(1L);
        userDetails.setCapitalGains(1L);
        userDetails.setOtherIncome(1L);
        userDetails.setRentalIncome(1L);
        userDetails.setSex("male");
        userDetails.setTaxSaved(1L);
        userDetails.setUserDetailid(1);
        userDetails.setYear(2022);

        User user = new User();
        user.setUserCompany("Hashedin");
        user.setUserDeductions(userDeductions);
        user.setUserDetails(userDetails);
        user.setUserEmail("jane.doe@example.org");
        user.setUserFirstName("Jane");
        user.setUserId(123);
        user.setUserLastName("Doe");
        user.setUserName("janedoe");
        user.setUserPassword("iloveyou");
        when(this.userService.addNewUser((User) any())).thenReturn(user);

        Section10 section101 = new Section10();
        section101.setActualRentPaid(1L);
        section101.setChildEducationAllowance(1L);
        section101.setChildHostelAllowance(1L);
        section101.setHra(1L);
        section101.setLta(1L);
        section101.setMetro(true);
        section101.setOtherRepay(1L);
        section101.setSection10id(1L);

        Section24 section241 = new Section24();
        section241.setInterest(1L);
        section241.setPropertyTax(1L);
        section241.setRent(1L);
        section241.setSection24id(1L);

        Section80C section80C1 = new Section80C();
        section80C1.setElss(1L);
        section80C1.setEmployeeEpfContri(1L);
        section80C1.setFd(1L);
        section80C1.setHomeLoanPrincipal(1L);
        section80C1.setLic(1L);
        section80C1.setNps_80c(1L);
        section80C1.setNsc(1L);
        section80C1.setPpf(1L);
        section80C1.setSection80cid(1L);
        section80C1.setSsy(1L);
        section80C1.setTutionFees(1L);
        section80C1.setUlip(1L);

        UserDeductions userDeductions1 = new UserDeductions();
        userDeductions1.setAdditionNps(1L);
        userDeductions1.setCharityDonation(1L);
        userDeductions1.setDeductionid(1L);
        userDeductions1.setEducationLoanInterest(1L);
        userDeductions1.setEmployerEpfContri(1L);
        userDeductions1.setEmployerNpsContri(1L);
        userDeductions1.setHomeLoanInterest(1L);
        userDeductions1.setMedicalInsurance(1L);
        userDeductions1.setSavingAccountInterest(3L);
        userDeductions1.setSection10(section101);
        userDeductions1.setSection24(section241);
        userDeductions1.setSection80C(section80C1);

        UserDetails userDetails1 = new UserDetails();
        userDetails1.setAge(1);
        userDetails1.setBasicSalary(1L);
        userDetails1.setBusinessIncome(1L);
        userDetails1.setCapitalGains(1L);
        userDetails1.setOtherIncome(1L);
        userDetails1.setRentalIncome(1L);
        userDetails1.setSex("Sex");
        userDetails1.setTaxSaved(1L);
        userDetails1.setUserDetailid(1);
        userDetails1.setYear(1);

        User user1 = new User();
        user1.setUserCompany("User Company");
        user1.setUserDeductions(userDeductions1);
        user1.setUserDetails(userDetails1);
        user1.setUserEmail("jane.doe@example.org");
        user1.setUserFirstName("Jane");
        user1.setUserId(123);
        user1.setUserLastName("Doe");
        user1.setUserName("janedoe");
        user1.setUserPassword("iloveyou");
        String content = (new ObjectMapper()).writeValueAsString(user1);

        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/addUser")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(this.userController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"userId\":123,\"userFirstName\":\"Jane\",\"userLastName\":\"Doe\",\"userName\":\"janedoe\",\"userEmail\":\"jane.doe"
                                        + "@example.org\",\"userCompany\":\"User Company\",\"userPassword\":\"iloveyou\",\"userDetails\":{\"userDetailid\":1"
                                        + ",\"year\":1,\"age\":1,\"sex\":\"Sex\",\"basicSalary\":1,\"taxSaved\":1,\"rentalIncome\":1,\"otherIncome\":1,\"capitalGains"
                                        + "\":1,\"businessIncome\":1},\"userDeductions\":{\"deductionid\":1,\"employerEpfContri\":1,\"additionNps\":1,"
                                        + "\"employerNpsContri\":1,\"medicalInsurance\":1,\"educationLoanInterest\":1,\"savingAccountInterest\":3,"
                                        + "\"charityDonation\":1,\"section24\":{\"section24id\":1,\"rent\":1,\"propertyTax\":1,\"interest\":1},\"section80C\""
                                        + ":{\"section80cid\":1,\"ppf\":1,\"employeeEpfContri\":1,\"nsc\":1,\"elss\":1,\"ulip\":1,\"lic\":1,\"fd\":1,\"ssy\":1,"
                                        + "\"homeLoanPrincipal\":1,\"tutionFees\":1,\"nps_80c\":1},\"section10\":{\"section10id\":1,\"actualRentPaid\":1,\"hra"
                                        + "\":1,\"lta\":1,\"childEducationAllowance\":1,\"childHostelAllowance\":1,\"otherRepay\":1,\"metro\":true},"
                                        + "\"homeLoanInterest\":1}}"));
    }

    /**
     * Method under test: {@link UserController#getCountOfUsers()}
     */
    @Test
    void testGetCountOfUsers() throws Exception {
        when(this.userService.getCountOfUsers()).thenReturn(3L);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/count");
        MockMvcBuilders.standaloneSetup(this.userController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("3"));
    }

    /**
     * Method under test: {@link UserController#getCountOfUsers()}
     */
    @Test
    void testGetCountOfUsers2() throws Exception {
        when(this.userService.getCountOfUsers()).thenReturn(3L);
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/count");
        getResult.contentType("https://example.org/example");
        MockMvcBuilders.standaloneSetup(this.userController)
                .build()
                .perform(getResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("3"));
    }

    /**
     * Method under test: {@link UserController#calculateTax(String)}
     */
    @Test
    void testCalculateTax() throws Exception {
        when(this.userService.calculateTaxes((String) any())).thenReturn(new HashMap<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/taxCalculate").param("email", "foo");
        MockMvcBuilders.standaloneSetup(this.userController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("{}"));
    }

    /**
     * Method under test: {@link UserController#calculateTax(String)}
     */
    @Test
    void testCalculateTax2() throws Exception {
        when(this.userService.calculateTaxes((String) any())).thenReturn(new HashMap<>());
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/taxCalculate");
        getResult.contentType("https://example.org/example");
        MockHttpServletRequestBuilder requestBuilder = getResult.param("email", "foo");
        MockMvcBuilders.standaloneSetup(this.userController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("{}"));
    }

    /**
     * Method under test: {@link UserController#getAllUser()}
     */
    @Test
    void testGetAllUser() throws Exception {
        when(this.userService.getUsers()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/getAll");
        MockMvcBuilders.standaloneSetup(this.userController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link UserController#getAllUser()}
     */
    @Test
    void testGetAllUser2() throws Exception {
        when(this.userService.getUsers()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/getAll");
        getResult.contentType("https://example.org/example");
        MockMvcBuilders.standaloneSetup(this.userController)
                .build()
                .perform(getResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link UserController#getUserByemail(String)}
     */
    @Test
    void testGetUserByemail() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/getUser").param("emailId", "foo");
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(this.userController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(400));
    }

    /**
     * Method under test: {@link UserController#removeAll()}
     */
    @Test
    void testRemoveAll() throws Exception {
        when(this.userService.deleteAllUsers()).thenReturn("Delete All Users");
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/removeAll");
        MockMvcBuilders.standaloneSetup(this.userController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string("Delete All Users"));
    }

    /**
     * Method under test: {@link UserController#removeAll()}
     */
    @Test
    void testRemoveAll2() throws Exception {
        when(this.userService.deleteAllUsers()).thenReturn("Delete All Users");
        MockHttpServletRequestBuilder deleteResult = MockMvcRequestBuilders.delete("/removeAll");
        deleteResult.contentType("https://example.org/example");
        MockMvcBuilders.standaloneSetup(this.userController)
                .build()
                .perform(deleteResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string("Delete All Users"));
    }

    /**
     * Method under test: {@link UserController#removeSingleUser(String)}
     */
    @Test
    void testRemoveSingleUser() throws Exception {
        when(this.userService.deleteSingleUser((String) any())).thenReturn("Delete Single User");
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/remove").param("email", "foo");
        MockMvcBuilders.standaloneSetup(this.userController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string("Delete Single User"));
    }

    /**
     * Method under test: {@link UserController#removeSingleUser(String)}
     */
    @Test
    void testRemoveSingleUser2() throws Exception {
        when(this.userService.deleteSingleUser((String) any())).thenReturn("Delete Single User");
        MockHttpServletRequestBuilder deleteResult = MockMvcRequestBuilders.delete("/remove");
        deleteResult.contentType("https://example.org/example");
        MockHttpServletRequestBuilder requestBuilder = deleteResult.param("email", "foo");
        MockMvcBuilders.standaloneSetup(this.userController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string("Delete Single User"));
    }

    /**
     * Method under test: {@link UserController#updatePassword(String, String)}
     */
    @Test
    void testUpdatePassword() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.put("/forgotPassword")
                .param("userEmail", "foo")
                .param("userPassword", "foo");
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(this.userController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(400));
    }

    /**
     * Method under test: {@link UserController#updateUser(User)}
     */
    @Test
    void testUpdateUser() throws Exception {
        Section10 section10 = new Section10();
        section10.setActualRentPaid(1L);
        section10.setChildEducationAllowance(1L);
        section10.setChildHostelAllowance(1L);
        section10.setHra(1L);
        section10.setLta(1L);
        section10.setMetro(true);
        section10.setOtherRepay(1L);
        section10.setSection10id(1L);

        Section24 section24 = new Section24();
        section24.setInterest(1L);
        section24.setPropertyTax(1L);
        section24.setRent(1L);
        section24.setSection24id(1L);

        Section80C section80C = new Section80C();
        section80C.setElss(1L);
        section80C.setEmployeeEpfContri(1L);
        section80C.setFd(1L);
        section80C.setHomeLoanPrincipal(1L);
        section80C.setLic(1L);
        section80C.setNps_80c(1L);
        section80C.setNsc(1L);
        section80C.setPpf(1L);
        section80C.setSection80cid(1L);
        section80C.setSsy(1L);
        section80C.setTutionFees(1L);
        section80C.setUlip(1L);

        UserDeductions userDeductions = new UserDeductions();
        userDeductions.setAdditionNps(1L);
        userDeductions.setCharityDonation(1L);
        userDeductions.setDeductionid(1L);
        userDeductions.setEducationLoanInterest(1L);
        userDeductions.setEmployerEpfContri(1L);
        userDeductions.setEmployerNpsContri(1L);
        userDeductions.setHomeLoanInterest(1L);
        userDeductions.setMedicalInsurance(1L);
        userDeductions.setSavingAccountInterest(3L);
        userDeductions.setSection10(section10);
        userDeductions.setSection24(section24);
        userDeductions.setSection80C(section80C);

        UserDetails userDetails = new UserDetails();
        userDetails.setAge(1);
        userDetails.setBasicSalary(1L);
        userDetails.setBusinessIncome(1L);
        userDetails.setCapitalGains(1L);
        userDetails.setOtherIncome(1L);
        userDetails.setRentalIncome(1L);
        userDetails.setSex("Sex");
        userDetails.setTaxSaved(1L);
        userDetails.setUserDetailid(1);
        userDetails.setYear(1);

        User user = new User();
        user.setUserCompany("User Company");
        user.setUserDeductions(userDeductions);
        user.setUserDetails(userDetails);
        user.setUserEmail("jane.doe@example.org");
        user.setUserFirstName("Jane");
        user.setUserId(123);
        user.setUserLastName("Doe");
        user.setUserName("janedoe");
        user.setUserPassword("iloveyou");
        when(this.userService.updateExistingUser((User) any())).thenReturn(user);

        Section10 section101 = new Section10();
        section101.setActualRentPaid(1L);
        section101.setChildEducationAllowance(1L);
        section101.setChildHostelAllowance(1L);
        section101.setHra(1L);
        section101.setLta(1L);
        section101.setMetro(true);
        section101.setOtherRepay(1L);
        section101.setSection10id(1L);

        Section24 section241 = new Section24();
        section241.setInterest(1L);
        section241.setPropertyTax(1L);
        section241.setRent(1L);
        section241.setSection24id(1L);

        Section80C section80C1 = new Section80C();
        section80C1.setElss(1L);
        section80C1.setEmployeeEpfContri(1L);
        section80C1.setFd(1L);
        section80C1.setHomeLoanPrincipal(1L);
        section80C1.setLic(1L);
        section80C1.setNps_80c(1L);
        section80C1.setNsc(1L);
        section80C1.setPpf(1L);
        section80C1.setSection80cid(1L);
        section80C1.setSsy(1L);
        section80C1.setTutionFees(1L);
        section80C1.setUlip(1L);

        UserDeductions userDeductions1 = new UserDeductions();
        userDeductions1.setAdditionNps(1L);
        userDeductions1.setCharityDonation(1L);
        userDeductions1.setDeductionid(1L);
        userDeductions1.setEducationLoanInterest(1L);
        userDeductions1.setEmployerEpfContri(1L);
        userDeductions1.setEmployerNpsContri(1L);
        userDeductions1.setHomeLoanInterest(1L);
        userDeductions1.setMedicalInsurance(1L);
        userDeductions1.setSavingAccountInterest(3L);
        userDeductions1.setSection10(section101);
        userDeductions1.setSection24(section241);
        userDeductions1.setSection80C(section80C1);

        UserDetails userDetails1 = new UserDetails();
        userDetails1.setAge(1);
        userDetails1.setBasicSalary(1L);
        userDetails1.setBusinessIncome(1L);
        userDetails1.setCapitalGains(1L);
        userDetails1.setOtherIncome(1L);
        userDetails1.setRentalIncome(1L);
        userDetails1.setSex("Sex");
        userDetails1.setTaxSaved(1L);
        userDetails1.setUserDetailid(1);
        userDetails1.setYear(1);

        User user1 = new User();
        user1.setUserCompany("User Company");
        user1.setUserDeductions(userDeductions1);
        user1.setUserDetails(userDetails1);
        user1.setUserEmail("jane.doe@example.org");
        user1.setUserFirstName("Jane");
        user1.setUserId(123);
        user1.setUserLastName("Doe");
        user1.setUserName("janedoe");
        user1.setUserPassword("iloveyou");
        String content = (new ObjectMapper()).writeValueAsString(user1);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.put("/updateUser")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(this.userController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"userId\":123,\"userFirstName\":\"Jane\",\"userLastName\":\"Doe\",\"userName\":\"janedoe\",\"userEmail\":\"jane.doe"
                                        + "@example.org\",\"userCompany\":\"User Company\",\"userPassword\":\"iloveyou\",\"userDetails\":{\"userDetailid\":1"
                                        + ",\"year\":1,\"age\":1,\"sex\":\"Sex\",\"basicSalary\":1,\"taxSaved\":1,\"rentalIncome\":1,\"otherIncome\":1,\"capitalGains"
                                        + "\":1,\"businessIncome\":1},\"userDeductions\":{\"deductionid\":1,\"employerEpfContri\":1,\"additionNps\":1,"
                                        + "\"employerNpsContri\":1,\"medicalInsurance\":1,\"educationLoanInterest\":1,\"savingAccountInterest\":3,"
                                        + "\"charityDonation\":1,\"section24\":{\"section24id\":1,\"rent\":1,\"propertyTax\":1,\"interest\":1},\"section80C\""
                                        + ":{\"section80cid\":1,\"ppf\":1,\"employeeEpfContri\":1,\"nsc\":1,\"elss\":1,\"ulip\":1,\"lic\":1,\"fd\":1,\"ssy\":1,"
                                        + "\"homeLoanPrincipal\":1,\"tutionFees\":1,\"nps_80c\":1},\"section10\":{\"section10id\":1,\"actualRentPaid\":1,\"hra"
                                        + "\":1,\"lta\":1,\"childEducationAllowance\":1,\"childHostelAllowance\":1,\"otherRepay\":1,\"metro\":true},"
                                        + "\"homeLoanInterest\":1}}"));
    }
}

