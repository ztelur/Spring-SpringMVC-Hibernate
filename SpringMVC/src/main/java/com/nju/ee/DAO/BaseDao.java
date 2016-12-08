package com.nju.ee.DAO;

import org.hibernate.Session;

import java.util.List;

/**
 * Created by zangxiaojie on 2016/11/3.
 */
public interface BaseDao {

    public Session getSession();

    public void flush();

    public void clear();

    public Object load(Class c, String id);


    public List getAllList(Class c);

    public Long getTotalCount(Class c);

    public void save(Object bean) throws Exception;

    public void update(Object bean) throws Exception;

    public void delete(Object bean) throws Exception;

    public void delete(Class c, String id);

    public void delete(Class c, String[] ids);
}
