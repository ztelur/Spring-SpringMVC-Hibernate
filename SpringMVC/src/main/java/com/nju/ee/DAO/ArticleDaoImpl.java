package com.nju.ee.DAO;

import com.nju.ee.entity.Article;
import com.nju.ee.po.ArticlePo;
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

    public Iterable<ArticlePo> findAll(Sort sort) {
        return null;
    }

    public Page<ArticlePo> findAll(Pageable pageable) {
        return null;
    }

    public <S extends ArticlePo> Iterable<S> save(Iterable<S> iterable) {
        return null;
    }

    public <S extends ArticlePo> S save(S s) {
        return null;
    }

    public ArticlePo findOne(Integer integer) {
        return null;
    }

    public boolean exists(Integer integer) {
        return false;
    }

    public Iterable<ArticlePo> findAll() {
        return null;
    }

    public Iterable<ArticlePo> findAll(Iterable<Integer> iterable) {
        return null;
    }

    public long count() {
        return 0;
    }

    public void delete(Integer integer) {

    }

    public void delete(ArticlePo articlePo) {

    }

    public void delete(Iterable<? extends ArticlePo> iterable) {

    }

    public void deleteAll() {

    }
}
