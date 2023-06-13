package com.alliance.travally.User;
public class UserMapper {

    public UserDTO toDTO(User user) {
        return new UserDTO(user.getUsername(), user.getEmail());
    }

    public User toUser(UserDTO userDTO) {
        return new User("randomId", userDTO.getUsername(), userDTO.getEmail());
    }

}
