package com.limyel.shutbb.controller;

import com.github.pagehelper.PageInfo;
import com.limyel.shutbb.annotation.CurrentUser;
import com.limyel.shutbb.annotation.IgnoreAuth;
import com.limyel.shutbb.common.Response;
import com.limyel.shutbb.dto.PostExecution;
import com.limyel.shutbb.entity.Post;
import com.limyel.shutbb.entity.User;
import com.limyel.shutbb.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/posts")
public class PostController {

    @Autowired
    PostService postService;

    @GetMapping("/topic/{topicId}")
    @ResponseBody
    @IgnoreAuth
    public Response<PageInfo<PostExecution>> retriveExecutionByTopicId(@PathVariable long topicId, @RequestParam(value = "page", defaultValue = "1") int page, @RequestParam(value = "pageSize", defaultValue = "15") int pageSize) {
        return postService.retriveByTopicId(topicId, page, pageSize);
    }

    @PostMapping("")
    @ResponseBody
    public Response create(@CurrentUser User user, @RequestBody Post post) {
        post.setUserId(user.getId());
        return postService.create(post);
    }

    @GetMapping("")
    @ResponseBody
    public Response<List<Post>> retrive(@CurrentUser User user) {
        return postService.retriveByUser(user.getId());
    }
}
