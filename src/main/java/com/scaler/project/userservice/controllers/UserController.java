package com.scaler.project.userservice.controllers;

import com.scaler.project.userservice.dto.LogoutDto;
import com.scaler.project.userservice.dto.SignUpDto;
import com.scaler.project.userservice.models.User;
import com.scaler.project.userservice.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

//    @PostMapping("/login")
//    public ResponseEntity<Token> login(@RequestBody LoginDto loginDto){
//        Token token = userService.login(loginDto);
//        return new ResponseEntity<>(token, HttpStatus.OK);
//    }

    @PostMapping("/sign-up")
    public ResponseEntity<User> signUp(@RequestBody SignUpDto signUpDto){
        userService.createUser(signUpDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping("/logout")
    public ResponseEntity<Void> logOut(@RequestBody LogoutDto logoutDto){
        userService.logOut(logoutDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<User> getByEmail(@PathVariable("username") String userName){
        return new ResponseEntity<>(userService.getUserByEmail(userName), HttpStatus.OK);
    }

//    @PostMapping("/validate-token")
//    public ResponseEntity<User> logOut(@RequestBody TokenValidateDto tokenValidateDto){
//        User user = userService.validateToken(tokenValidateDto);
//        return new ResponseEntity<>(user, HttpStatus.OK);
//    }
}
