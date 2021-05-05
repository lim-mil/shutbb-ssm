package com.limyel.shutbb.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.limyel.shutbb.annotation.CurrentUser;
import com.limyel.shutbb.annotation.IgnoreAuth;
import com.limyel.shutbb.annotation.Page;
import com.limyel.shutbb.annotation.Size;
import com.limyel.shutbb.common.Response;
import com.limyel.shutbb.entity.Post;
import com.limyel.shutbb.entity.User;
import com.limyel.shutbb.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping("/posts")
public class PostController {
    @Autowired
    PostService postService;

    /**
     * 获取某 topic 下的 post
     * @param topicId
     * @param page
     * @param pageSize
     * @return
     */
    @GetMapping("/topic/{topicId}")
    @IgnoreAuth
    @ResponseBody
    public Response<PageInfo<Post>> retriveByTopic(@PathVariable("topicId") int topicId, @RequestParam(value = "page", defaultValue = "1") int page, @RequestParam(value = "pageSize", defaultValue = "20") int pageSize) {
        return postService.retriveByTopic(topicId, page, pageSize);
    }

    /**
     * 获取当前用户的 post
     * @param user
     * @param request
     * @param response
     * @return
     */
    @GetMapping("/user")
    @ResponseBody
    public Response<List<Post>> retriveByCurrentUser(@CurrentUser User user, HttpServletRequest request, HttpServletResponse response) {
        return postService.retriveByUser(user.getId());
    }

    /**
     * 获取指定用户的 post
     * @param userId
     * @param request
     * @param response
     * @return
     */
    @GetMapping("/user/{userId}")
    @ResponseBody
    @IgnoreAuth
    public Response<List<Post>> retriveByUser(@PathVariable("userId") int userId, HttpServletRequest request, HttpServletResponse response) {
        return postService.retriveByUser(userId);
    }

    /**
     * 获取草稿 post
     * @param user
     * @param request
     * @param response
     * @return
     */
    @GetMapping("/draft")
    @ResponseBody
    public Response<List<Post>> retriveDrfat(@CurrentUser User user, HttpServletRequest request, HttpServletResponse response) {
        return postService.retriveDraft(user.getId());
    }

    @PostMapping("")
    @ResponseBody
    public Response<Integer> create(@RequestBody Post post, @CurrentUser User user, HttpServletResponse response) {
        post.setUser(user);
        Response<Integer> serviceResponse = postService.create(post);
        response.setStatus(serviceResponse.getCode());
        return serviceResponse;
    }

    @DeleteMapping("/{postId}")
    @ResponseBody
    public Response<Integer> deleteByid(@CurrentUser User user, @PathVariable("postId") int postId, HttpServletResponse response) {
        Response<Integer> serviceResponse = postService.deleteById(postId, user);
        response.setStatus(serviceResponse.getCode());
        return serviceResponse;
    }
}
