package com.mobilefirstsolutions.microservices.gateway.service;

import com.mobilefirstsolutions.microservices.model.LoginRequest;
import com.mobilefirstsolutions.microservices.model.LoginResponse;

/**
 * Created by aharcsa on 2016. 05. 05..
 */
public interface LoginService {

    /**
     * login
     * @param request LoginRequest
     * @return LoginResponse
     */
    LoginResponse login(LoginRequest request);
}
