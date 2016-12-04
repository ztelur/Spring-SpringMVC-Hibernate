package com.nju.ee.service;

import com.nju.ee.DAO.ArticleDao;
import com.nju.ee.po.ArticlePo;
import com.nju.ee.po.RestResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by 克崽兽 on 2016/12/2.
 */
@Service
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    private ArticleDao articleDao;

    public RestResult getArticles(Integer page, Integer num) {
        ArrayList<ArticlePo> list = new ArrayList<ArticlePo>();
        for (int i = 0; i < 3; i++) {
            ArticlePo po = new ArticlePo();
            po.setCategory("A类");
            po.setDate(new Date());
            po.setReadTimes(10);
            po.setTitle("标题"+i);
            po.setContent("内容"+i);
            list.add(po);
        }
        RestResult result = RestResult.CreateResult(1,list);

        return result;
//        page = (page < 1) ? 1 : page;
//        //TODO:需要指定默认每页数量
//        num = (num < 1) ? 10 : num;
//        Sort sort = new Sort(new Sort.Order(Sort.Direction.DESC,"date"));
//        Pageable request = new PageRequest(page - 1, num, sort);
//        Page<ArticlePo> articles = articleDao.findAll(request);
//        return RestResult.CreateResult(1,articles);
    }

    public RestResult getArticleDetail(Integer id) {
        ArticlePo po = new ArticlePo();
        po.setCategory("A类");
        po.setDate(new Date());
        po.setReadTimes(10);
        po.setTitle("标题" + id);
        po.setContent("内容" + id);
        RestResult result = RestResult.CreateResult(1, po);
        return result;
    }

    public RestResult addArticle(ArticlePo article) {
        ArticlePo po = new ArticlePo();
        po.setCategory("A类");
        po.setDate(new Date());
        po.setReadTimes(10);
        po.setTitle("标题");
        po.setContent("内容");
        RestResult result = RestResult.CreateResult(1, po);
        return result;
    }

    public RestResult modifyArticle(Integer id, ArticlePo article) {
        ArticlePo po = new ArticlePo();
        po.setCategory("A类");
        po.setDate(new Date());
        po.setReadTimes(10);
        po.setTitle("标题" + id);
        po.setContent("内容" + id);
        RestResult result = RestResult.CreateResult(1, po);
        return result;
    }

    public RestResult deleteArticle(Integer id) {
        ArticlePo po = new ArticlePo();
        po.setCategory("A类");
        po.setDate(new Date());
        po.setReadTimes(10);
        po.setTitle("标题" + id);
        po.setContent("内容" + id);
        RestResult result = RestResult.CreateResult(1, po);
        return result;
    }
}
