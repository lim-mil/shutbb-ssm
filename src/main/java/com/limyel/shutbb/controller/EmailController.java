package com.limyel.shutbb.controller;

import com.limyel.shutbb.annotation.IgnoreAuth;
import com.limyel.shutbb.common.RETCODE;
import com.limyel.shutbb.common.Response;
import com.limyel.shutbb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/email")
public class EmailController {
    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/active/{code}")
    @IgnoreAuth
    @ResponseBody
    public Response<Integer> active(@PathVariable("code") String code, HttpServletResponse response) {
        int result = userService.active(code);
        if (result == 0) {
            response.setStatus(RETCODE.BADREQUEST.getCode());
            return Response.badRequest(result);
        }
        return Response.success(result);
    }
}
