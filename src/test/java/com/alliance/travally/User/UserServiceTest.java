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
            String name = "Test";
            String username = "test_username";
            String email = "test_email@test.com";
            String password = "password";

            UserRegistrationDTO userRegistrationDTO = UserRegistrationDTO.builder()
                    .name(name)
                    .username(username)
                    .email(email)
                    .password(password)
                    .build();

            boolean success = userService.createUser(userRegistrationDTO);
            assertTrue(success);
        }

        @Test
        @DisplayName("Blank details returns false")
        public void testCreateUser_blank() {
            String name = "Test";
            String username = "";
            String email = "";
            String password = "password";

            UserRegistrationDTO userRegistrationDTO = UserRegistrationDTO.builder()
                    .name(name)
                    .username(username)
                    .email(email)
                    .password(password)
                    .build();
            boolean success = userService.createUser(userRegistrationDTO);
            assertFalse(success);
        }

        @Test
        @DisplayName("Incorrect username format returns false")
        public void testCreateUser_incorrectUsername() {
            String name = "Test";
            String username = ".";
            String email = "test_email@test.com";
            String password = "password";

            UserRegistrationDTO userRegistrationDTO = UserRegistrationDTO.builder()
                    .name(name)
                    .username(username)
                    .email(email)
                    .password(password)
                    .build();

            boolean success = userService.createUser(userRegistrationDTO);
            assertFalse(success);
        }

        @Test
        @DisplayName("Incorrect email format returns false")
        public void testCreateUser_incorrectEmail() {
            String name = "Test";
            String username = "test_username";
            String email = "test_email.com";
            String password = "password";

            UserRegistrationDTO userRegistrationDTO = UserRegistrationDTO.builder()
                    .name(name)
                    .username(username)
                    .email(email)
                    .password(password)
                    .build();

            boolean success = userService.createUser(userRegistrationDTO);
            assertFalse(success);
        }
    }

}
