package com.nju.ee.DAO;

import com.nju.ee.entity.Article;
import com.nju.ee.vo.ArticleVo;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by zangxiaojie on 2016/12/2.
 */
@Repository
public class ArticleDaoImpl implements ArticleDao{
    @Autowired
    private BaseDao baseDao;

    public Article getArticleById(int id){
        Session session=baseDao.getSession();
        Criteria cri=session.createCriteria(Article.class);
        cri.add(Restrictions.eq("id",id));
        List<Article> list=cri.list();
        if (list.size()>0){
            return list.get(0);
        }
        return null;

    }

    public void save(Article article){
        baseDao.save(article);
    }

    public void update(Article article){
        baseDao.update(article);

    }

    public void delete(Article article){
        baseDao.delete(article);
    }

    public Iterable<ArticleVo> findAll(Sort sort) {
        return null;
    }

    public Page<ArticleVo> findAll(Pageable pageable) {
        return null;
    }

    public <S extends ArticleVo> Iterable<S> save(Iterable<S> iterable) {
        return null;
    }

    public <S extends ArticleVo> S save(S s) {
        return null;
    }

    public ArticleVo findOne(Integer integer) {
        return null;
    }

    public boolean exists(Integer integer) {
        return false;
    }

    public Iterable<ArticleVo> findAll() {
        return null;
    }

    public Iterable<ArticleVo> findAll(Iterable<Integer> iterable) {
        return null;
    }

    public long count() {
        return 0;
    }

    public void delete(Integer integer) {

    }

    public void delete(ArticleVo articleVo) {

    }

    public void delete(Iterable<? extends ArticleVo> iterable) {

    }

    public void deleteAll() {

    }
}
