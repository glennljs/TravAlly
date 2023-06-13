package com.alliance.travally.Utils;

import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

public class EncryptionUtils {

    private static final PasswordEncoder INSTANCE = PasswordEncoderFactories.createDelegatingPasswordEncoder();

    public static PasswordEncoder getPasswordEncoder() {
        return INSTANCE;
    }

}
