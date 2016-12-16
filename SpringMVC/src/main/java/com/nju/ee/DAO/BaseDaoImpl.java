package com.nju.ee.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by zangxiaojie on 2016/11/3.
 */
@Repository
public class BaseDaoImpl implements BaseDao {
    @Autowired
    protected SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Session getSession() {
        // TODO Auto-generated method stub

        return sessionFactory.openSession();
    }
    public Session getCurrentSession(){
        return sessionFactory.getCurrentSession();
    }

    public void flush() {
        getSession().flush();
    }



    public void clear() {
        getSession().clear();
    }

    @SuppressWarnings("rawtypes")
    public Object load(Class c, String id) {
        Session session = getSession();
        return session.get(c, id);
    }


    public List getAllList(Class c) {
        String hql = "from " + c.getName();
        Session session = getSession();
        return session.createQuery(hql).list();

    }


    public Long getTotalCount(Class c) {
        Session session = getSession();
        String hql = "select count(*) from " + c.getName();
        Long count = (Long) session.createQuery(hql).uniqueResult();
        session.close();
        return count != null ? count.longValue() : 0;
    }

    public void save(Object bean) throws Exception{

            Session session = getSession();
            session.save(bean);
            session.flush();
            session.clear();
            session.close();
    }

    public void update(Object bean) throws Exception{
        Session session = getSession();
        session.update(bean);
        session.flush();
        session.clear();
        session.close();
    }

    public void delete(Object bean) throws Exception{

        Session session = getSession();
        session.delete(bean);
        session.flush();
        session.clear();
        session.close();
    }

    @SuppressWarnings({ "rawtypes" })
    public void delete(Class c, String id) {
        Session session = getSession();
        Object obj = session.get(c, id);
        session.delete(obj);
        flush();
        clear();
    }

    @SuppressWarnings({ "rawtypes" })
    public void delete(Class c, String[] ids) {
        for (String id : ids) {
            Object obj = getSession().get(c, id);
            if (obj != null) {
                getSession().delete(obj);
            }
        }
    }
}
