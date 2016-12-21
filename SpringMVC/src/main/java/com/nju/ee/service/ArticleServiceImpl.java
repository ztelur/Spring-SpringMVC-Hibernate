package com.nju.ee.service;

import com.nju.ee.Constant.Constant;
import com.nju.ee.Constant.RichTextUtil;
import com.nju.ee.DAO.ArticleDao;
import com.nju.ee.DAO.ArticleRepository;
import com.nju.ee.entity.Article;
import com.nju.ee.vo.ArticleVo;
import com.nju.ee.vo.Error;
import com.nju.ee.vo.GenericVoPage;
import com.nju.ee.vo.RestResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
//TODO 将dao层异常抛出至service，获取其根源原因以构造出错时的RestResult
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
    @Autowired
    private FileService fileService;

    public RestResult getArticles(Integer page, Integer num) {
        //使用dao
//        List<Article> list=articleDao.getArticleWithPage(1);
//        System.out.println("list size()"+list.size());
//        RestResult result = RestResult.CreateResult(1,list);
        //使用repository
        page = (page == null || page < 1) ? 1 : page;
        num = (num == null || num < 1) ? Constant.PAGE_COUNT : num;
        Sort sort = new Sort(new Sort.Order(Sort.Direction.DESC, "date"));
        Pageable request = new PageRequest(page - 1, num, sort);
        Page<Article> articles = articleRepo.findAll(request);
        GenericVoPage<ArticleVo> voPage = new GenericVoPage(articles.getSize(), articles.getNumber(), articles.getTotalPages());
        for (Article article : articles.getContent()) {
            ArticleVo vo = new ArticleVo(article);
            voPage.getData().add(vo);
        }
        return RestResult.CreateResult(1, voPage);
    }

    public RestResult getArticleDetail(Integer id) {
        if (id == null) {
            return RestResult.CreateResult(0, new Error(Error.BAD_PARAM, "缺少新闻编号"));
        }
        Article article = articleDao.getArticleById(id);
        if (article == null) {
            return RestResult.CreateResult(0, new Error(Error.BAD_PARAM, "不存在该编号的新闻"));
        }
        ArticleVo vo = new ArticleVo(article);
        return RestResult.CreateResult(1, vo);
    }

    public RestResult addArticle(ArticleVo articleVo) {
        Article article = new Article(articleVo);
        article.setDate(new Date());
        Article savedArticle = articleDao.save(article);
        if (savedArticle == null) {
            return RestResult.CreateResult(0, new Error(Error.SYS_ERROR, "存储过程出错"));
        }
        ArticleVo vo = new ArticleVo(savedArticle);
        return RestResult.CreateResult(1, vo);
    }

    public RestResult modifyArticle(Integer id, ArticleVo article) {
        if (id == null) {
            return RestResult.CreateResult(0, new Error(Error.BAD_PARAM, "缺少新闻编号"));
        }
        Article modifiedArticle = articleDao.getArticleById(id);
        if (modifiedArticle == null) {
            return RestResult.CreateResult(0, new Error(Error.BAD_PARAM, "不存在该编号的新闻"));
        }
        String uselessContent=modifiedArticle.getContent();

        modifiedArticle.setCategory(article.getCategory());
        modifiedArticle.setTitle(article.getTitle());
        modifiedArticle.setContent(article.getContent());

        Article updatedArticle = articleDao.update(modifiedArticle);
        if(updatedArticle==null){
            //修改失败，删除新的图片
            List<String> images = RichTextUtil.getImageUrlsFromContent(modifiedArticle.getContent());
            for (String url: images) {
                fileService.deleteFile(url);
            }
            return RestResult.CreateResult(0,new Error(Error.SYS_ERROR,"修改过程出错"));
        }
        //修改成功，删除旧的图片
        List<String> images = RichTextUtil.getImageUrlsFromContent(uselessContent);
        for (String url: images) {
            fileService.deleteFile(url);
        }
        ArticleVo vo =new ArticleVo(updatedArticle);
        return RestResult.CreateResult(1,vo);
    }

    public RestResult deleteArticle(Integer id) {
        if (id == null) {
            return RestResult.CreateResult(0, new Error(Error.BAD_PARAM, "缺少新闻编号"));
        }
        Article uselessArticle = articleDao.getArticleById(id);
        if (uselessArticle == null) {
            return RestResult.CreateResult(0, new Error(Error.BAD_PARAM, "不存在该编号的新闻"));
        }
        Article deletedArticle = articleDao.delete(uselessArticle);
        if(deletedArticle==null){
            return RestResult.CreateResult(0,new Error(Error.SYS_ERROR,"删除过程出错"));
        }
        List<String> images = RichTextUtil.getImageUrlsFromContent(deletedArticle.getContent());
        for (String url: images) {
            fileService.deleteFile(url);
        }
        ArticleVo vo =new ArticleVo(deletedArticle);
        return RestResult.CreateResult(1,vo);
    }
}
