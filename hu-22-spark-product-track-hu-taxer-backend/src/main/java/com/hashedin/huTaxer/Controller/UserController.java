package com.hashedin.huTaxer.Controller;

import com.hashedin.huTaxer.Exception.ExistingUserException;
import com.hashedin.huTaxer.Exception.SamePasswordException;
import com.hashedin.huTaxer.Exception.UserNotFoundException;
import com.hashedin.huTaxer.Modal.User;
import com.hashedin.huTaxer.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping(value = "/getAll")
    public List<User> getAllUser() {
        return userService.getUsers();
    }


    @GetMapping(value = "/getUser")
    public ResponseEntity<User> getUserByemail(@RequestParam("email") String emailId) throws UserNotFoundException {
        return ResponseEntity.ok(userService.getUserbyEmailId(emailId));
    }

    @PostMapping(value = "/addUser")
    public ResponseEntity<User> addUser(@RequestBody @Valid User user) throws ExistingUserException {
        return ResponseEntity.ok(userService.addNewUser(user));
    }


    @PutMapping(value = "/updateUser")
    public ResponseEntity<User> updateUser(@RequestBody @Valid User user) throws UserNotFoundException {
        return ResponseEntity.ok(userService.updateExistingUser(user));

    }

    @PutMapping(value = "/forgotPassword")
    public ResponseEntity<User> updatePassword(@RequestParam("email") String userEmail, @RequestParam("pass") String userPassword) throws UserNotFoundException, SamePasswordException {
        return ResponseEntity.ok(userService.setNewPassword(userEmail, userPassword));
    }

    @GetMapping(value = "/taxCalculate")
    public ResponseEntity calculateTax(@RequestParam("email") String email) throws  UserNotFoundException {
        return ResponseEntity.ok().body(userService.calculateTaxes(email));
    }

    @DeleteMapping(value = "/removeAll")
    public String removeAll()
    {
        return userService.deleteAllUsers();
    }

    @DeleteMapping(value = "/remove")
    public  ResponseEntity removeSingleUser(@Param("email") String email) throws  UserNotFoundException
    {
        return ResponseEntity.ok(userService.deleteSingleUser(email));
    }

    @GetMapping(value = "/count")
    public long getCountOfUsers()
    {
        return userService.getCountOfUsers();
    }

}
