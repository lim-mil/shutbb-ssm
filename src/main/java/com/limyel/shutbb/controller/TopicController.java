package com.limyel.shutbb.controller;

import com.limyel.shutbb.common.Response;
import com.limyel.shutbb.entity.Topic;
import com.limyel.shutbb.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/topics")
public class TopicController {
    @Autowired
    TopicService topicService;

    @PostMapping("")
    @ResponseBody
    public Response<Integer> create(@RequestBody Topic topic, HttpServletRequest request, HttpServletResponse response) {
        Response serviceResponse = topicService.create(topic);

        response.setStatus(serviceResponse.getCode());
        return serviceResponse;
    }

}
