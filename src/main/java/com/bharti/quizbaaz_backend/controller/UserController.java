package com.bharti.quizbaaz_backend.controller;

import com.bharti.quizbaaz_backend.dto.LoginRequest;
import com.bharti.quizbaaz_backend.entity.User;
import com.bharti.quizbaaz_backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResponseEntity<User> login(@RequestBody LoginRequest loginRequest) {
//         Get user by email from Database
        User user = userService.getUser(loginRequest.getEmail());

//         Validating user
        Boolean validUser = userService.validateUser(loginRequest, user);
        if(validUser) {
            return new ResponseEntity<>(user, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }

    @PostMapping("/signup")
    public ResponseEntity<User> signup(@RequestBody User user){
        User newUser = userService.createUser(user);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }
}
