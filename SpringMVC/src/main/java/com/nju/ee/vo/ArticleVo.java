package com.nju.ee.vo;

import com.nju.ee.Constant.RichTextUtil;
import com.nju.ee.entity.Article;

import java.util.Date;

/**
 * Created by homer on 16-10-31.
 */
public class ArticleVo {
    private Integer id;
    private String title;
    private String category;
    private String content;
    private Date date;

    private String imageUrl;//供主页显示的图片url
    private String brief;   //供主页显示的简介

    public ArticleVo(){

    }
    public ArticleVo(Article article) {
        this.id = article.getId();
        this.title = article.getTitle();
        this.category = article.getCategory();
        this.content = article.getContent();
        this.date = article.getDate();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }



    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDate() {
        return (new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(this.date);
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getImageUrl() {
        return RichTextUtil.getFirstImageFromContent(this.content);
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getBrief() {
        return RichTextUtil.getBriefFromContent(this.content , 100);
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }
}
