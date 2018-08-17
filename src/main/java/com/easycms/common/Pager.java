package com.easycms.common;

import java.util.List;

public class Pager<T> {

    //总记录数
    private int total;



    //总页数
    private int totalPage;

    //每页显示的记录数
    private int pegeSize;
    //当前页
    private int page;

    //每页显示的具体内容
    private List<T> pageList;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getPegeSize() {
        return pegeSize;
    }
    public void setPegeSize(int pegeSize) {
        this.pegeSize = pegeSize;
    }

    public List<T> getPageList() {
        return pageList;
    }

    public void setPageList(List<T> pageList) {
        this.pageList = pageList;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }
}
