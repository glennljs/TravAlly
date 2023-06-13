package com.alliance.travally.User;

import com.alliance.travally.Database.DatabaseService;
import com.alliance.travally.Exceptions.ValidationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import static com.alliance.travally.Utils.AuthenticationUtils.isValidEmail;
import static com.alliance.travally.Utils.AuthenticationUtils.isValidUsername;

@Service
public class UserService {

    private final DatabaseService databaseService;

    public UserService(@Qualifier(value = "mockDatabaseService") DatabaseService databaseService) {
        this.databaseService = databaseService;
    }

    Logger logger = LoggerFactory.getLogger(UserService.class);

    public boolean createUser(UserDTO userDTO) {
        try {
            validateUser(userDTO);
        } catch (ValidationException e) {
            logger.error(e.getMessage());
            return false;
        }

        User user = new UserMapper().toUser(userDTO);
        return databaseService.create(user);
    }

    private void validateUser(UserDTO userDTO) throws ValidationException {
        // this should be slightly redundant - preliminary checks should be done on FE
        if (!(isValidUsername(userDTO.getUsername()) && isValidEmail(userDTO.getEmail()))) {
            throw new ValidationException("Incorrect username or email format");
        }
    }

}
