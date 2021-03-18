package com.limyel.shutbb.controller;

import com.limyel.shutbb.annotation.IgnoreAuth;
import com.limyel.shutbb.entity.User;
import com.limyel.shutbb.service.AuthorizationService;
import com.limyel.shutbb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value = "/users")
public class UserController {
    @Autowired
    UserService userService;

    @Autowired
    AuthorizationService authorizationService;

    @IgnoreAuth
    @PostMapping(value = "/register")
    @ResponseBody
    public String register(@RequestBody User user, HttpServletRequest request) {
        userService.create(user);
        String token = authorizationService.generateJwtToken(user);
        return token;
    }

    @IgnoreAuth
    @PostMapping(value = "/login")
    @ResponseBody
    public String login(@RequestBody User user, HttpServletRequest request) {
        return "";
    }

    @GetMapping(value = "/{id:[0-9]*}")
    @ResponseBody
    public String retriveUserById(@PathVariable int id, HttpServletRequest request) {
        return "";
    }


}
