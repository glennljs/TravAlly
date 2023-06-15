package com.alliance.travally.User;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class User {

    private final String id;
    private final String name;
    private final String username;
    private final String email;
    private final String password;

}
