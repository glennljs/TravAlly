package com.alliance.travally.User;

import lombok.*;

@Builder
@AllArgsConstructor
public class UserDTO {

    @Getter
    @Setter
    private String username;

    @Getter
    @Setter
    private String email;

}
