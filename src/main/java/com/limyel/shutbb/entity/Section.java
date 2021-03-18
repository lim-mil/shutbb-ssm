package com.limyel.shutbb.entity;

public class Section extends BaseModel {
    private String name;
    private int subForumId;
    private int userId;         // 版主

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSubForumId() {
        return subForumId;
    }

    public void setSubForumId(int subForumId) {
        this.subForumId = subForumId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
