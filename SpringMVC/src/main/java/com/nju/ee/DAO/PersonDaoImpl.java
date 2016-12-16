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
public class PersonDaoImpl implements PersonDao{
    @Autowired
    private BaseDao baseDao;
    @Override
    public Person getPersonById(int id){
        Session session=baseDao.getSession();
        Criteria cri=session.createCriteria(Person.class);
        cri.add(Restrictions.eq("id",id));
        List<Person> list=cri.list();
        if (list.size()<=0){
            return null;
        }
        return list.get(0);
    }

    @Override
    public Person getDetachedPersonById(int id){
        Session session=baseDao.getSession();
        Criteria cri=session.createCriteria(Person.class);
        cri.add(Restrictions.eq("id",id));
        List<Person> list=cri.list();
        if (list.size()<=0){
            return null;
        }
        session.flush();
        session.clear();
        session.close();
        return list.get(0);
    }

    @Override
    public List<Person> getPeople() {
        List<Person> people= baseDao.getAllList(Person.class);
        return people;
    }

    public Person save(Person p){
        Person savedPerson;
        try {
            baseDao.save(p);
            savedPerson = p ;
        } catch (Exception e) {
//            e.printStackTrace();
            savedPerson = null;
        }
        return savedPerson;
    }

    public Person update(Person p){
        Person updatedPerson;
        try {
            baseDao.update(p);
            updatedPerson = p;
        } catch (Exception e) {
//            e.printStackTrace();
            updatedPerson = null;
        }

        return updatedPerson;
    }
    @Override
    public Person delete(Person person){
        Person deletedPerson;
        try {
            baseDao.delete(person);
            deletedPerson = person;
        } catch (Exception e) {
//            e.printStackTrace();
            deletedPerson = null;
        }
        return deletedPerson;
    }
}
