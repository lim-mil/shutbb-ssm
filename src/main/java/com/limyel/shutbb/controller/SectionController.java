package com.limyel.shutbb.controller;

import com.limyel.shutbb.annotation.CurrentUser;
import com.limyel.shutbb.annotation.IgnoreAuth;
import com.limyel.shutbb.common.Response;
import com.limyel.shutbb.dto.UsersSectionsExecution;
import com.limyel.shutbb.entity.Section;
import com.limyel.shutbb.entity.User;
import com.limyel.shutbb.service.SectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/sections")
public class SectionController {

    @Autowired
    private SectionService sectionService;

    @GetMapping("/focus")
    @IgnoreAuth
    @ResponseBody
    public Response<List<Section>> select(@CurrentUser User user) {
        return sectionService.selectFocus(user);
    }

    @GetMapping("/all")
    @ResponseBody
    public Response<UsersSectionsExecution> selectFocus(@CurrentUser User user) {
        return sectionService.selectAll(user);
    }
}
