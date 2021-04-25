package com.limyel.shutbb.controller;

import com.limyel.shutbb.annotation.CurrentUser;
import com.limyel.shutbb.common.Response;
import com.limyel.shutbb.dto.SectionShort;
import com.limyel.shutbb.entity.Section;
import com.limyel.shutbb.entity.User;
import com.limyel.shutbb.service.SectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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

    public Response<List<SectionShort>> retriveByUser(@CurrentUser User user) {
        Response<List<SectionShort>> response = sectionService.retriveByUser(user);
        return response;
    }

    @GetMapping("/default")
    @ResponseBody
    public Response<List<SectionShort>> retriveDefault() {
        Response<List<SectionShort>> response = sectionService.retriveDefault();

        return null;
    }
}
