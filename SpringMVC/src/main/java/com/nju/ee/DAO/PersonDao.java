package com.nju.ee.DAO;

import com.nju.ee.entity.Person;

import java.util.List;

/**
 * Created by 克崽兽 on 2016/12/14.
 */
public interface PersonDao {
    Person getPersonById(int id);

    Person getDetachedPersonById(int id);

    List<Person> getPeople();

    Person update(Person person);

    Person delete(Person person);

    Person save(Person person);
}
