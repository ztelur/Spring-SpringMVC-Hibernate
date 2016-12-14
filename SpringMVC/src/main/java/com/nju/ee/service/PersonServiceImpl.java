package com.nju.ee.service;

import com.nju.ee.DAO.PersonDao;
import com.nju.ee.entity.Person;
import com.nju.ee.vo.PersonDescVo;
import com.nju.ee.vo.RestResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 克崽兽 on 2016/12/5.
 */
@Service
public class PersonServiceImpl implements PersonService {
    @Autowired
    private PersonDao personDao;

    public RestResult getPeople() {
        List<Person> people = personDao.getPeople();
        return null;
    }

    public RestResult getPersonDetail(Integer id) {
        return null;
    }

    public RestResult addPerson(PersonDescVo person) {
        return null;
    }

    public RestResult modifyPerson(Integer id, PersonDescVo person) {
        return null;
    }

    public RestResult deletePerson(Integer id) {
        return null;
    }
}
