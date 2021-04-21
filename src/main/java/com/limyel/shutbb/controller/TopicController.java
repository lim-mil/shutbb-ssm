package com.limyel.shutbb.controller;

import com.limyel.shutbb.annotation.CurrentUser;
import com.limyel.shutbb.annotation.IgnoreAuth;
import com.limyel.shutbb.common.Response;
import com.limyel.shutbb.entity.Topic;
import com.limyel.shutbb.entity.User;
import com.limyel.shutbb.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping("/topics")
public class TopicController {
    @Autowired
    TopicService topicService;

    @PostMapping("")
    @ResponseBody
    public Response<Integer> create(@RequestBody Topic topic, @CurrentUser User user, HttpServletRequest request, HttpServletResponse response) {
        topic.setUser(user);
        Response serviceResponse = topicService.create(topic);

        response.setStatus(serviceResponse.getCode());
        return serviceResponse;
    }

    @GetMapping("/section/{sectionId}")
    @ResponseBody
    @IgnoreAuth
    public Response<List<Topic>> retriveBySection(@PathVariable("sectionId") int sectionId, HttpServletResponse response) {
        return topicService.retriveBySection(sectionId);
    }

    @GetMapping("/user")
    @ResponseBody
    public Response<List<Topic>> retriveByCurrentUser(@CurrentUser User user, HttpServletResponse response) {
        return topicService.retriveByUser(user.getId());
    }

    @GetMapping("/user/{userId}")
    @ResponseBody
    @IgnoreAuth
    public Response<List<Topic>> retriveByUser(@PathVariable("userId") int userId, HttpServletResponse response) {
        return topicService.retriveByUser(userId);
    }

    @GetMapping("/draft")
    @ResponseBody
    public Response<List<Topic>> retriveDraft(@CurrentUser User user, HttpServletRequest request, HttpServletResponse response) {
        return topicService.retriveDraft(user.getId());
    }

    @DeleteMapping("/{topicId}")
    @ResponseBody
    public Response<Integer> deleteById(@CurrentUser User user, @PathVariable("topicId") int topicId, HttpServletResponse response) {
        Response<Integer> serviceResponse = topicService.deleteById(topicId, user);
        response.setStatus(serviceResponse.getCode());
        return serviceResponse;
    }
}
