package com.limyel.shutbb.controller;

import com.limyel.shutbb.annotation.CurrentUser;
import com.limyel.shutbb.annotation.IgnoreAuth;
import com.limyel.shutbb.annotation.JsonItem;
import com.limyel.shutbb.common.Response;
import com.limyel.shutbb.entity.User;
import com.limyel.shutbb.service.AuthorizationService;
import com.limyel.shutbb.service.UserService;
import org.apache.commons.codec.digest.DigestUtils;
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
    public Response<String> register(@RequestBody User user, @JsonItem String confirmPassword, HttpServletRequest request) {
        return userService.create(user, confirmPassword);
    }

    @IgnoreAuth
    @PostMapping(value = "/login")
    @ResponseBody
    public Response<String> login(@JsonItem String usernameOrEmail, @JsonItem String password, HttpServletRequest request) {

        return userService.login(usernameOrEmail, password);
    }

    @GetMapping("/info")
    @ResponseBody
    public Response<User> currentUserInfo(@CurrentUser User user) {
        User userTmp = new User();
        userTmp.setUsername(user.getUsername());
        userTmp.setId(user.getId());
        userTmp.setStatus(user.getStatus());
        return Response.success(userTmp);
    }

    @GetMapping(value = "/{id:[0-9]*}")
    @ResponseBody
    public String retriveUserById(@CurrentUser User user, @PathVariable int id, HttpServletRequest request) {
        return "";
    }
}
