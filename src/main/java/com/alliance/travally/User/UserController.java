package com.alliance.travally.User;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @GetMapping("/returnUser")
    public String returnUser(@RequestParam String username, @RequestParam String email) {
        UserDTO dto = new UserDTO(username, email);
        User user = new UserMapper().toUser(dto);

        return user.toString();
    }


}
