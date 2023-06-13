package com.alliance.travally.User;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDTO {

    private final String name;
    private final String username;
    private final String email;

}
