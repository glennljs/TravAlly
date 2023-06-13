package com.alliance.travally.User;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class User {

    @Getter
    private final String id;

    @Getter
    private final String username;

    @Getter
    private final String email;

}
