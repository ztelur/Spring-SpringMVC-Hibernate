package com.nju.ee.vo;

import com.nju.ee.entity.Article;

/**
 * Created by homer on 16-10-31.
 */
public class ArticleVo {
    private String title;
    private String category;
    private String content;
    public ArticleVo(Article article) {
        this.title = article.getTitle();
        this.category = article.getCategory();
        this.content = article.getContent();
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



}
