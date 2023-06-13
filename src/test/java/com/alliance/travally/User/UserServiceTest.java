package com.alliance.travally.User;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class UserServiceTest {

    @Autowired
    UserService userService;

    @Nested
    @DisplayName("When creating a user")
    class NewUser {
        @Test
        @DisplayName("Correct details returns true")
        public void testCreateUser() {
            String username = "test_username";
            String email = "test_email@test.com";

            UserDTO userDTO = UserDTO.builder()
                    .username(username)
                    .email(email)
                    .build();

            boolean success = userService.createUser(userDTO);
            assertTrue(success);
        }

        @Test
        @DisplayName("Blank details returns false")
        public void testCreateUser_blank() {
            String username = "";
            String email = "";

            UserDTO userDTO = UserDTO.builder()
                    .username(username)
                    .email(email)
                    .build();

            boolean success = userService.createUser(userDTO);
            assertFalse(success);
        }

        @Test
        @DisplayName("Incorrect username format returns false")
        public void testCreateUser_incorrectUsername() {
            String username = ".";
            String email = "test_email@test.com";

            UserDTO userDTO = UserDTO.builder()
                    .username(username)
                    .email(email)
                    .build();

            boolean success = userService.createUser(userDTO);
            assertFalse(success);
        }

        @Test
        @DisplayName("Incorrect email format returns false")
        public void testCreateUser_incorrectEmail() {
            String username = "test_username";
            String email = "test_email.com";

            UserDTO userDTO = UserDTO.builder()
                    .username(username)
                    .email(email)
                    .build();

            boolean success = userService.createUser(userDTO);
            assertFalse(success);
        }
    }

}
