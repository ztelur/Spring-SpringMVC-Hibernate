package com.nju.ee.DAO;

import com.nju.ee.entity.Person;
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
public class PersonDao {
    @Autowired
    private BaseDao baseDao;

    public Person getPersonId(int id){
        Session session=baseDao.getSession();
        Criteria cri=session.createCriteria(Person.class);
        cri.add(Restrictions.eq("id",id));
        List<Person> list=cri.list();
        if (list.size()>0){
            return list.get(0);
        }
        return null;

    }

    public void save(Person p){
        try {
            baseDao.save(p);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void update(Person p){
        try {
            baseDao.update(p);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void delete(Person p){
        try {
            baseDao.delete(p);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
