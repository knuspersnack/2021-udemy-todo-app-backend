package com.knuspersnack.rest.webservices.jwt;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BcryptEncoderTest {

    //Method that helps to create new users
    public static void main(String[] args) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String encodedString = bCryptPasswordEncoder.encode("password@123@#!");
        System.out.println("NEW VERIFICATION KEY: " + encodedString);
    }
}
