package com.nju.ee.service;

import com.nju.ee.DAO.ArticleDao;
import com.nju.ee.DAO.ArticleRepository;
import com.nju.ee.entity.Article;
import com.nju.ee.vo.ArticleVo;
import com.nju.ee.vo.Error;
import com.nju.ee.vo.RestResult;
import com.nju.ee.vo.VoPage;
import org.hibernate.Criteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by 克崽兽 on 2016/12/2.
 */
@Service
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    private ArticleDao articleDao;
    //用于处理分页
    @Autowired
    private ArticleRepository articleRepo;

    public RestResult getArticles(Integer page, Integer num) {
        //使用dao
//        List<Article> list=articleDao.getArticleWithPage(1);
//        System.out.println("list size()"+list.size());
//        RestResult result = RestResult.CreateResult(1,list);
        //使用repository
        page = (page == null || page < 1) ? 1 : page;
        //TODO:需要指定默认每页数量
        num = (num == null || num < 1) ? 10 : num;
        Sort sort = new Sort(new Sort.Order(Sort.Direction.DESC, "date"));
        Pageable request = new PageRequest(page - 1, num, sort);
        Page<Article> articles = articleRepo.findAll(request);
        VoPage voPage = new VoPage(articles.getSize(), articles.getNumber(), articles.getTotalPages());
        for (Article article : articles.getContent()) {
            ArticleVo vo = new ArticleVo(article);
            voPage.getArticles().add(vo);
        }
        return RestResult.CreateResult(1, voPage);
    }

    public RestResult getArticleDetail(Integer id) {
        if (id == null) {
            return RestResult.CreateResult(0, new Error(Error.BAD_PARAM, "缺少新闻编号"));
        }
        Article article = articleDao.findOne(id);
        if (article == null) {
            return RestResult.CreateResult(0, new Error(Error.BAD_PARAM, "不存在该编号的新闻"));
        }
        ArticleVo vo = new ArticleVo(article);
        return RestResult.CreateResult(1, vo);
    }

    public RestResult addArticle(ArticleVo articlevo) {
        Article article = new Article(articlevo);
        Article savedArticle = articleDao.save(article);
        if (savedArticle == null) {
            return RestResult.CreateResult(0, new Error(Error.SYS_ERROR, "存储过程出错"));
        }
        ArticleVo vo = new ArticleVo(savedArticle);
        return RestResult.CreateResult(1, vo);
    }

    public RestResult modifyArticle(Integer id, ArticleVo article) {
        return null;
    }

    public RestResult deleteArticle(Integer id) {
        //TODO 如果没找到，返回的会是什么？
        return null;
    }

}
