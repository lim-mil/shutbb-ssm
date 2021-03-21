package com.limyel.shutbb.controller;

import com.limyel.shutbb.common.Response;
import com.limyel.shutbb.entity.Post;
import com.limyel.shutbb.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/posts")
public class PostController {
    @Autowired
    PostService postService;

    @PostMapping("")
    @ResponseBody
    public Response<Integer> create(@RequestBody Post post, HttpServletRequest request, HttpServletResponse response) {
        Response serviceResponse = postService.create(post);
        response.setStatus(serviceResponse.getCode());
        return serviceResponse;
    }
}
