package com.limyel.shutbb.entity;

public class UsersSections extends BaseModel {
    private User user;
    private Section section;

    public UsersSections() {

    }

    public UsersSections(User user, Section section) {
        this.user = user;
        this.section = section;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Section getSection() {
        return section;
    }

    public void setSection(Section section) {
        this.section = section;
    }
}
