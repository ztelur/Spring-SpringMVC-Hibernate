package com.nju.ee.vo;

import java.util.ArrayList;

/**
 * Created by 克崽兽 on 2016/12/7.
 */
public class Page {
    private String pageSize;
    private String pageNum;
    private ArrayList<ArticleVo> articles;

    public String getPageSize() {
        return pageSize;
    }

    public void setPageSize(String pageSize) {
        this.pageSize = pageSize;
    }

    public String getPageNum() {
        return pageNum;
    }

    public void setPageNum(String pageNum) {
        this.pageNum = pageNum;
    }

    public ArrayList<ArticleVo> getArticles() {
        return articles;
    }

    public void setArticles(ArrayList<ArticleVo> articles) {
        this.articles = articles;
    }
}
