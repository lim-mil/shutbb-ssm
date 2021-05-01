package com.limyel.shutbb.dto;

import com.limyel.shutbb.entity.Section;

import java.util.List;

public class UserSection {
    private List<Section> focusSections;
    private List<Section> otherSections;

    public UserSection(List<Section> focusSections, List<Section> otherSections) {
        this.focusSections = focusSections;
        this.otherSections = otherSections;
    }

    public UserSection() {

    }

    public List<Section> getFocusSections() {
        return focusSections;
    }

    public void setFocusSections(List<Section> focusSections) {
        this.focusSections = focusSections;
    }

    public List<Section> getOtherSections() {
        return otherSections;
    }

    public void setOtherSections(List<Section> otherSections) {
        this.otherSections = otherSections;
    }
}
