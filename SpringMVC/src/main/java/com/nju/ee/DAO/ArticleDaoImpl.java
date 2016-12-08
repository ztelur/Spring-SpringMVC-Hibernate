package com.nju.ee.DAO;

import com.nju.ee.Constant.Constant;
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
    @Override
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


    @Override
    public List<Article> getArticleWithPage(int page) {
        if (page<1){
            page=1;
        }
        int first=(page-1)* Constant.PAGE_COUNT;
        Session session =baseDao.getSession();
        Criteria criteria = session.createCriteria(Article.class);
        criteria.setFirstResult(first);
        criteria.setMaxResults(Constant.PAGE_COUNT);
        List<Article> result = criteria.list();
        session.flush();
        session.close();
        return result;
    }

    public void update(Article article){
        baseDao.update(article);

    }

    public void delete(Article article){
        baseDao.delete(article);
    }



    @Override
    public String delete4Result(Integer integer) {
        return null;
    }

    public void deleteAll() {

    }
}
