package com.nju.ee.vo;

import java.util.ArrayList;

/**
 * Created by homer on 16-12-16.
 */
public class GenericVoPage<T> {
    private Integer pageSize;
    private Integer pageNum;
    private Integer totalPage;
    private ArrayList<T> data;

    public GenericVoPage(Integer pageSize, Integer pageNum, Integer totalPage) {
        this.pageSize = pageSize;
        this.pageNum = pageNum;
        this.totalPage = totalPage;
        this.data = new ArrayList<T>();
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public ArrayList<T> getData() {
        return data;
    }

    public void setData(ArrayList<T> data) {
        this.data = data;
    }
}
