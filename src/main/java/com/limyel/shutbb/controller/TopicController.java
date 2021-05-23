package com.limyel.shutbb.controller;

import com.github.pagehelper.PageInfo;
import com.limyel.shutbb.annotation.CurrentUser;
import com.limyel.shutbb.annotation.IgnoreAuth;
import com.limyel.shutbb.common.Response;
import com.limyel.shutbb.dto.TopicExecution;
import com.limyel.shutbb.entity.Section;
import com.limyel.shutbb.entity.Topic;
import com.limyel.shutbb.entity.User;
import com.limyel.shutbb.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/topics")
public class TopicController {

    @Autowired
    private TopicService topicService;

    @GetMapping("/section/{sectionId}")
    @ResponseBody
    @IgnoreAuth
    public Response<PageInfo<TopicExecution>> selectBySectionId(@PathVariable Long sectionId, @RequestParam(value = "page", defaultValue = "1") int page, @RequestParam(value = "pageSize", defaultValue = "15") int pageSize) {
        Topic topic = new Topic();
        topic.setSectionId(sectionId);
        return topicService.selectBySectionId(topic, page, pageSize);
    }

    @GetMapping("/latest")
    @ResponseBody
    @IgnoreAuth
    public Response<PageInfo<TopicExecution>> latest(@RequestParam(value = "page", defaultValue = "1") int page, @RequestParam(value = "pageSize", defaultValue = "15") int pageSize) {
        return topicService.select(page, pageSize);
    }

    @PostMapping("")
    @ResponseBody
    public Response<Long> create(@CurrentUser User user, @RequestBody TopicExecution topicExecution) {
        topicExecution.setUser(user);
        return topicService.create(topicExecution.toTopic());
    }

    @GetMapping("/{topicId}")
    @ResponseBody
    @IgnoreAuth
    public Response<TopicExecution> retriveById(@PathVariable long topicId) {
        return topicService.retriveById(topicId);
    }

    @GetMapping("")
    @ResponseBody
    public Response<List<Topic>> retrive(@CurrentUser User user) {
        return topicService.retriveByUser(user.getId());
    }
}
