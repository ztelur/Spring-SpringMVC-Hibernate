package com.nju.ee.service;

import com.nju.ee.po.ArticlePo;
import com.nju.ee.po.RestResult;

/**
 * Created by 克崽兽 on 2016/12/2.
 */
public interface ArticleService {
    public RestResult getArticles(Integer page, Integer num);
    public RestResult getArticleDetail(Integer id);
    public RestResult addArticle(ArticlePo article);
    public RestResult modifyArticle(Integer id, ArticlePo article);
    public RestResult deleteArticle(Integer id);
}
