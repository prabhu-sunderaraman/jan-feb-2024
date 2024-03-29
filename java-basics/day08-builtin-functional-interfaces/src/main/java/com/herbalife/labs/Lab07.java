package com.herbalife.labs;

import static com.herbalife.labs.ValidationConstants.*;

public class Lab07 {
    public static void main(String[] args) {
        String username = "samyboy";
        String password = "Samy1234";
        boolean usernameValid = isNotNull
                .and(isNotBlank)
                .and(isNotEmpty)
                //.and(isUsernameLengthValid)
                .and(lengthValidation.apply(6, 12))
                .test(username);
        System.out.println("Username: %s validity %s".formatted(username, usernameValid));

        boolean passwordValid = isNotNull
                .and(isNotBlank)
                .and(isNotEmpty)
                //.and(isPasswordLengthValid)
                .and(lengthValidation.apply(8, 14))
                .and(hasNumber)
                .and(hasUpperCase)
                .test(password);
        System.out.println("Password: %s validity: %s".formatted(password, passwordValid));

    }
}
