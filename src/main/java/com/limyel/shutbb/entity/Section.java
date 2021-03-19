package com.limyel.shutbb.entity;

public class Section extends BaseModel {
    private String name;
    private boolean isDraft;
    private int subForumId;
    private int userId;

    public boolean isDraft() {
        return isDraft;
    }

    public void setDraft(boolean draft) {
        isDraft = draft;
    }

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
