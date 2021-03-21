package com.limyel.shutbb.controller;

import com.limyel.shutbb.common.Response;
import com.limyel.shutbb.entity.SubForum;
import com.limyel.shutbb.service.SubForumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/subforums")
public class SubForumController {
    @Autowired
    SubForumService subForumService;

    @PostMapping("")
    @ResponseBody
    public Response<Integer> create(@RequestBody SubForum subForum, HttpServletRequest request, HttpServletResponse response) {
        System.out.println(subForum.getName());
        System.out.println(subForum.getUserId());
        Response serviceResponse = subForumService.create(subForum);
        response.setStatus(serviceResponse.getCode());
        return serviceResponse;
    }



}
