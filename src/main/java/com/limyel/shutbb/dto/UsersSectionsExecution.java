package com.limyel.shutbb.dto;

import com.limyel.shutbb.entity.Section;

import java.util.List;

public class UsersSectionsExecution {
    private List<Section> focusSections;
    private List<Section> unfocusSections;

    public UsersSectionsExecution() {
    }

    public UsersSectionsExecution(List<Section> focusSections, List<Section> unfocusSections) {
        this.focusSections = focusSections;
        this.unfocusSections = unfocusSections;
    }

    public List<Section> getFocusSections() {
        return focusSections;
    }

    public void setFocusSections(List<Section> focusSections) {
        this.focusSections = focusSections;
    }

    public List<Section> getUnfocusSections() {
        return unfocusSections;
    }

    public void setUnfocusSections(List<Section> unfocusSections) {
        this.unfocusSections = unfocusSections;
    }
}
