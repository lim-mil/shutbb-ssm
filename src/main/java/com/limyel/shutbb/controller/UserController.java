package com.limyel.shutbb.controller;

import com.limyel.shutbb.annotation.CurrentUser;
import com.limyel.shutbb.annotation.IgnoreAuth;
import com.limyel.shutbb.annotation.JsonItem;
import com.limyel.shutbb.common.Response;
import com.limyel.shutbb.dao.UsersSectionsDao;
import com.limyel.shutbb.entity.User;
import com.limyel.shutbb.service.AuthorizationService;
import com.limyel.shutbb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value = "/users")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private AuthorizationService authorizationService;

    private UsersSectionsDao usersSectionsDao;

    @Autowired
    public void setUsersSectionsDao(UsersSectionsDao usersSectionsDao) {
        this.usersSectionsDao = usersSectionsDao;
    }

    @IgnoreAuth
    @PostMapping(value = "/register")
    @ResponseBody
    public Response<String> register(@RequestBody User user, @JsonItem String checkPassword, HttpServletRequest request) {
        return userService.create(user, checkPassword, request);
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
        if (user == null) {
            return Response.unauthorizedMsg("登录已过期，请重新登录");
        }
        User result = userService.retriveById(user.getId());
        return Response.success(result);
    }

    @GetMapping(value = "/{id:[0-9]*}")
    @ResponseBody
    public String retriveUserById(@CurrentUser User user, @PathVariable int id, HttpServletRequest request) {
        return "";
    }

    @PostMapping("/avatar")
    @ResponseBody
    public Response<String> uploadAvatar(@CurrentUser User user, @RequestParam("avatar") MultipartFile file, HttpServletRequest request) {
        return userService.uploadAvatar(user, file, request);
    }

    @PostMapping("/sections/{sectionName}")
    @ResponseBody
    public Response focusSection(@PathVariable("sectionName") String sectionName, @CurrentUser User user) {

        return Response.success();
    }
}
