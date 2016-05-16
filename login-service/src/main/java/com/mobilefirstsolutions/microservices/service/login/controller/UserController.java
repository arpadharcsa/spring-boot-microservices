package com.mobilefirstsolutions.microservices.service.login.controller;

import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import com.mobilefirstsolutions.microservices.model.LoginRequest;
import com.mobilefirstsolutions.microservices.model.LoginResponse;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import org.springframework.web.bind.annotation.*;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
@RequestMapping(UserController.FUNCTION)
@SuppressWarnings("unused")
public class UserController {
    public static final String FUNCTION = "api";
    protected static final String LOGIN = "login";

    private final Map<String, List<String>> userDb = new HashMap<>();

    public UserController() {
        userDb.put("arpi", Arrays.asList("user"));
        userDb.put("bela", Arrays.asList("user", "admin"));
    }

    @RequestMapping(value = LOGIN, method = RequestMethod.POST)
    @ResponseBody
    public LoginResponse login(@RequestBody final LoginRequest request)
        throws ServletException {
        String username = request.getUsername();
        if (username == null || !userDb.containsKey(username)) {
            throw new ServletException("Invalid login");
        }
        String token = createToken(username);
        return new LoginResponse().setToken(token);
    }

    @RequestMapping(value = "role/{role}", method = RequestMethod.GET)
    public Boolean login(@PathVariable final String role,
                         final HttpServletRequest request) throws ServletException {
        final Claims claims = (Claims) request.getAttribute("claims");

        return ((List<String>) claims.get("roles")).contains(role);
    }

    private String createToken(String username) {
        JwtBuilder jwtBuilder = Jwts.builder();
        jwtBuilder.setSubject(username);
        jwtBuilder.claim("roles", userDb.get(username)).setIssuedAt(new Date());
        jwtBuilder.signWith(SignatureAlgorithm.HS256, "secretkey");
        return jwtBuilder.compact();
    }

}
