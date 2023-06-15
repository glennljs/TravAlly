package com.alliance.travally.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/createUser")
    public ResponseEntity<String> createUser(@RequestBody UserRegistrationDTO userRegistrationDTO) {
        boolean success = userService.createUser(userRegistrationDTO);
        if (!success) {
            ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User registration failed.");
        }

        return ResponseEntity.status(HttpStatus.CREATED).body("User registered successfully.");
    }

    @GetMapping("/getUserDetails")
    public ResponseEntity<String> getUserDetails(@RequestParam String username) {
        UserDTO response = userService.findUserByUsername(username);
        if (response == null) {
            return ResponseEntity.status(HttpStatus.OK).body("User not found");
        }
        return ResponseEntity.status(HttpStatus.OK).body(userService.findUserByUsername(username).toString());
    }

}
