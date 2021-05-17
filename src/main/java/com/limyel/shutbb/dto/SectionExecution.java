package com.limyel.shutbb.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.limyel.shutbb.entity.Section;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class SectionExecution extends Section {
    private Integer topicNum;
    private List<TopicExecution> topics;


}
