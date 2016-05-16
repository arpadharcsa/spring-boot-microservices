package com.mobilefirstsolutions.microservices.gateway.service;

import com.mobilefirstsolutions.microservices.model.LoginRequest;
import com.mobilefirstsolutions.microservices.model.LoginResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Created by aharcsa on 2016. 05. 05..
 */
@Service
@SuppressWarnings("unused")
public class LoginServiceImpl implements LoginService {

    private static final String LOGIN_SERVICE_URL = "http://login-service/api";
    private static final String LOGIN = "login";
    protected RestTemplate restTemplate;

    @Autowired
    public void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public LoginResponse login(LoginRequest request) {

        return restTemplate.postForObject(LOGIN_SERVICE_URL + "/" + LOGIN, request, LoginResponse.class);
    }
}
