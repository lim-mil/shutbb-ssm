package com.limyel.shutbb.controller;

import com.limyel.shutbb.annotation.CurrentUser;
import com.limyel.shutbb.common.Response;
import com.limyel.shutbb.entity.SubForum;
import com.limyel.shutbb.entity.User;
import com.limyel.shutbb.service.SubForumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping("/subforums")
public class SubForumController {
    @Autowired
    SubForumService subForumService;

    @PostMapping("")
    @ResponseBody
    public Response<Integer> create(@RequestBody SubForum subForum, @CurrentUser User user, HttpServletResponse response) {
        subForum.setUserId(user.getId());
        Response<Integer> serviceResponse = subForumService.create(subForum);
        response.setStatus(serviceResponse.getCode());
        return serviceResponse;
    }

    @GetMapping("")
    @ResponseBody
    public Response<List<SubForum>> retrive() {
        return subForumService.retrive();
    }

}
