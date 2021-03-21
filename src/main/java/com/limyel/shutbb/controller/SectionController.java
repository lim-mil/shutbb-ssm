package com.limyel.shutbb.controller;

import com.limyel.shutbb.common.Response;
import com.limyel.shutbb.entity.Section;
import com.limyel.shutbb.service.SectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/sections")
public class SectionController {
    @Autowired
    SectionService sectionService;

    @PostMapping("")
    @ResponseBody
    public Response<Integer> create(@RequestBody Section section, HttpServletRequest request, HttpServletResponse response) {
        Response serviceResponse = sectionService.create(section);

        response.setStatus(serviceResponse.getCode());
        return serviceResponse;
    }
}
