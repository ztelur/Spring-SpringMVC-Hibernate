package com.nju.ee.DAO;

import com.nju.ee.entity.Article;

import java.util.List;

/**
 * Created by 克崽兽 on 2016/12/3.
 */
public interface ArticleDao {
    Article getArticleById(int id);

    List<Article> getArticleWithPage(int page);

    Article update(Article article);

    Article delete(Article article);

    Article save(Article article);
}
