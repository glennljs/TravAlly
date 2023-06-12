package com.alliance.travally.User;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

    @Getter
    @Setter
    private String username;

    @Getter
    @Setter
    private String email;

}
