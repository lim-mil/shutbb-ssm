package com.limyel.shutbb.controller;

import com.limyel.shutbb.annotation.CurrentUser;
import com.limyel.shutbb.annotation.IgnoreAuth;
import com.limyel.shutbb.common.Response;
import com.limyel.shutbb.entity.User;
import com.limyel.shutbb.service.AuthorizationService;
import com.limyel.shutbb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

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
    public Response<String> register(@RequestBody User user, HttpServletRequest request) {
        userService.create(user);
        String token = authorizationService.generateJwtToken(user);

        return Response.success(token);
    }

    @IgnoreAuth
    @PostMapping(value = "/login")
    @ResponseBody
    public Response<String> login(@RequestBody User user, HttpServletRequest request) {
        String token = null;
        User userTmp = userService.retrive(user);
        if (userTmp != null) {
            token = authorizationService.generateJwtToken(userTmp);
        } else {
            return Response.unauthorized();
        }
        System.out.println(user.getUsername());
        return Response.success(token);
    }

    @GetMapping(value = "/{id:[0-9]*}")
    @ResponseBody
    public String retriveUserById(@CurrentUser User user, @PathVariable int id, HttpServletRequest request) {
        System.out.println(user.getUsername());
        return "";
    }


}
