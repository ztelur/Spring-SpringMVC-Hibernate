package com.nju.ee.DAO;

import com.nju.ee.entity.Article;

import java.util.List;

/**
 * Created by 克崽兽 on 2016/12/3.
 */
public interface ArticleDao {
    Article getArticleById(int id);

    List<Article> getArticleWithPage(int page);

    /**
     *
     * @param integer 需要删除的新闻ID
     * @return 返回删除的结果
     */
    String delete4Result(Integer integer);

}
