package com.mobilefirstsolutions.microservices.model;

/**
 * Created by aharcsa on 2016. 05. 16..
 */
public class LoginResponse {
    String token;

    public String getToken() {
        return token;
    }

    public LoginResponse setToken(String token) {
        this.token = token;
        return this;
    }
}
