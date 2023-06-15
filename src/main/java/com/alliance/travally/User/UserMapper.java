package com.alliance.travally.User;

public class UserMapper {

    public static User toRegisteredUser(UserRegistrationDTO userRegistrationDTO, String encryptedPassword) {
        return User.builder()
                .id("id")
                .name(userRegistrationDTO.getName())
                .email(userRegistrationDTO.getEmail())
                .username(userRegistrationDTO.getUsername())
                .password(encryptedPassword)
                .build();
    }

}
