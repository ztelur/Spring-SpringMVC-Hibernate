package com.nju.ee.DAO;

import com.nju.ee.entity.Article;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by zangxiaojie on 2016/12/2.
 */
@Repository
public class ArticleDao {
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
}
