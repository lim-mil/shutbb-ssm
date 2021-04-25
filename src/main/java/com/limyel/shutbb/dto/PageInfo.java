package com.limyel.shutbb.dto;

public class PageInfo {
    private int currentPage;
    private int allPageNum;
    private int pageItemNum;

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getAllPageNum() {
        return allPageNum;
    }

    public void setAllPageNum(int allPageNum) {
        this.allPageNum = allPageNum;
    }

    public int getPageItemNum() {
        return pageItemNum;
    }

    public void setPageItemNum(int pageItemNum) {
        this.pageItemNum = pageItemNum;
    }
}
