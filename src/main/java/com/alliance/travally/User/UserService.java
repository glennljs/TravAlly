package com.alliance.travally.User;

import com.alliance.travally.Database.DatabaseService;
import com.alliance.travally.Exceptions.ValidationException;
import com.alliance.travally.Utils.EncryptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import static com.alliance.travally.User.UserMapper.toRegisteredUser;
import static com.alliance.travally.Utils.AuthenticationUtils.isValidEmail;
import static com.alliance.travally.Utils.AuthenticationUtils.isValidUsername;

@Service
public class UserService {

    private final DatabaseService databaseService;
    Logger logger = LoggerFactory.getLogger(UserService.class);

    public UserService(@Qualifier(value = "mockDatabaseService") DatabaseService databaseService) {
        this.databaseService = databaseService;
    }

    public boolean createUser(UserRegistrationDTO userRegistrationDTO) {
        try {
            validateUser(userRegistrationDTO);
        } catch (ValidationException e) {
            logger.error(e.getMessage());
            return false;
        }

        PasswordEncoder encoder = EncryptionUtils.getPasswordEncoder();
        String encryptedPassword = encoder.encode(userRegistrationDTO.getPassword());
        User user = toRegisteredUser(userRegistrationDTO, encryptedPassword);

        boolean success = databaseService.create(user);
        if (success); {
            logger.info("User created! " + user.toString());
            return true;
        }
//        return false;
    }

    public UserDTO findUserByUsername(String username) {
        return UserDTO.builder()
                .name("Test")
                .username(username)
                .email("email@email.com")
                .build();
    }

    private void validateUser(UserRegistrationDTO userRegistrationDTO) throws ValidationException {
        // this should be slightly redundant - preliminary checks should be done on FE
        if (!(isValidUsername(userRegistrationDTO.getUsername()) && isValidEmail(userRegistrationDTO.getEmail()))) {
            throw new ValidationException("Incorrect username or email format");
        }
    }

}
