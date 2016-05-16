package com.mobilefirstsolutions.microservices.gateway.controller;

import com.mobilefirstsolutions.microservices.gateway.service.LoginService;
import com.mobilefirstsolutions.microservices.model.LoginRequest;
import com.mobilefirstsolutions.microservices.model.LoginResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by aharcsa on 2016. 05. 16..
 */
@Controller
@RequestMapping(LoginController.LOGIN_FUNCTION)
public class LoginController {
    protected static final String LOGIN_FUNCTION = "login";
    protected static final String LOGIN_ACTION = "login";

    private LoginService loginService;

    @Autowired
    public void setLoginService(LoginService loginService) {
        this.loginService = loginService;
    }

    @RequestMapping(LOGIN_ACTION)
    @ResponseBody
    public LoginResponse login(@RequestBody LoginRequest request) {
        return loginService.login(request);
    }
}
