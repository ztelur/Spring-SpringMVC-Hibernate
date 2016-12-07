package com.nju.ee.service;

import com.nju.ee.vo.ArticleVo;
import com.nju.ee.vo.RestResult;

/**
 * Created by 克崽兽 on 2016/12/2.
 */
public interface ArticleService {
    public RestResult getArticles(Integer page, Integer num);
    public RestResult getArticleDetail(Integer id);
    public RestResult addArticle(ArticleVo article);
    public RestResult modifyArticle(Integer id, ArticleVo article);
    public RestResult deleteArticle(Integer id);
}
