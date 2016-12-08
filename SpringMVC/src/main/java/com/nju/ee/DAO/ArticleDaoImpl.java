package com.nju.ee.DAO;

import com.nju.ee.entity.Article;
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
public class ArticleDaoImpl implements ArticleDao {
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


    public void update(Article article){
        baseDao.update(article);

    }

    public void delete(Article article){
        baseDao.delete(article);
    }

    public Iterable<Article> findAll(Sort sort) {
        return null;
    }

    public Page<Article> findAll(Pageable pageable) {
        return null;
    }

    public <S extends Article> Iterable<S> save(Iterable<S> iterable) {
        return null;
    }

    public <S extends Article> S save(S s) {
        return null;
    }

    @Override
    public String delete4Result(Integer integer) {
        return null;
    }

    public Article findOne(Integer integer) {
        return null;
    }

    public boolean exists(Integer integer) {
        return false;
    }

    public Iterable<Article> findAll() {
        return null;
    }

    public Iterable<Article> findAll(Iterable<Integer> iterable) {
        return null;
    }

    public long count() {
        return 0;
    }

    public void delete(Integer integer) {

    }

    public void delete(Iterable<? extends Article> iterable) {

    }

    public void deleteAll() {

    }
}
