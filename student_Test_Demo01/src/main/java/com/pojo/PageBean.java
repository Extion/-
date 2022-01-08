package com.pojo;

import java.util.List;

//用来返回前端分页所需数据的对象
public class PageBean<T>{
    //总共的条数
    private int totalCount;
    //返回要显示的集合
    private List<T> rows;

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }
}
