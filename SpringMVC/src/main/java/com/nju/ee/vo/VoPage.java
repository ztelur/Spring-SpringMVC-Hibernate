package com.nju.ee.vo;

import java.util.ArrayList;

/**
 * Created by 克崽兽 on 2016/12/7.
 */
public class VoPage {
    private Integer pageSize;
    private Integer pageNum;
    private Integer totalPage;
    private ArrayList<ArticleVo> articles;

    public VoPage(Integer pageSize, Integer pageNum, Integer totalPage) {
        this.pageSize = pageSize;
        this.pageNum = pageNum;
        this.totalPage = totalPage;
        this.articles = new ArrayList<ArticleVo>();
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

    public ArrayList<ArticleVo> getArticles() {
        return articles;
    }

    public void setArticles(ArrayList<ArticleVo> articles) {
        this.articles = articles;
    }
}
