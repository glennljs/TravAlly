package com.alliance.travally.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/createUser")
    public String returnUser(@RequestParam String username, @RequestParam String email) {
        UserDTO userDTO = new UserDTO(username, email);
        boolean success = userService.createUser(userDTO);

        if (!success) {
            return "Error creating user.";
        }

        return "User created!";
    }

}
