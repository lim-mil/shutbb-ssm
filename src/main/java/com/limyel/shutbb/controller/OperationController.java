package com.limyel.shutbb.controller;

import com.limyel.shutbb.annotation.CurrentUser;
import com.limyel.shutbb.common.Response;
import com.limyel.shutbb.entity.Section;
import com.limyel.shutbb.entity.User;
import com.limyel.shutbb.entity.UsersSections;
import com.limyel.shutbb.service.OperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/operation")
public class OperationController {

    @Autowired
    private OperationService operationService;

    @PatchMapping("/usersSections")
    @ResponseBody
    public Response usersSections(@CurrentUser User user, @RequestBody Section section) {
        return operationService.updateUsersSections(user, section);
    }

    @PatchMapping("/usersTopics")
    @ResponseBody
    public Response usersTopics(@CurrentUser User user) {
        return null;
    }
}
