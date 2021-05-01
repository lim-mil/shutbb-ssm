package com.limyel.shutbb.controller;

import com.limyel.shutbb.annotation.CurrentUser;
import com.limyel.shutbb.annotation.IgnoreAuth;
import com.limyel.shutbb.common.Response;
import com.limyel.shutbb.dto.SectionShort;
import com.limyel.shutbb.dto.UserSection;
import com.limyel.shutbb.entity.Section;
import com.limyel.shutbb.entity.User;
import com.limyel.shutbb.service.SectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.LinkedList;
import java.util.List;

@Controller
@RequestMapping("/sections")
public class SectionController {
    @Autowired
    SectionService sectionService;

    @PostMapping("")
    @ResponseBody
    public Response<Integer> create(@RequestBody Section section, @CurrentUser User user, HttpServletRequest request, HttpServletResponse response) {
        section.setUser(user);
        Response<Integer> serviceResponse = sectionService.create(section);

        response.setStatus(serviceResponse.getCode());
        return serviceResponse;
    }

    @GetMapping("/user")
    @ResponseBody
    public Response<UserSection> retriveByUser(@CurrentUser User user) {
        return sectionService.retriveByUser(user);
    }

    @GetMapping("/all")
    @ResponseBody
    @IgnoreAuth
    public Response<List<Section>> retriveAll() {
        // TODO: 2021/4/29 api冗余，可以合并一下
        return sectionService.retriveAll();
    }

    @GetMapping("")
    @ResponseBody
    @IgnoreAuth
    public Response<List<Section>> retrive(@CurrentUser User user) {

        return sectionService.retriveDefault(user);
    }

    @PatchMapping("/user")
    @ResponseBody
    public Response updateByUser(@CurrentUser User user, @RequestBody UserSection userSection) {
        System.out.println(user.getId());
        for (Section section: userSection.getFocusSections()) {
            System.out.println(section.getName());
        }
        return Response.success();
    }

}
