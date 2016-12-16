package com.nju.ee.service;

import com.nju.ee.DAO.PersonDao;
import com.nju.ee.entity.Person;
import com.nju.ee.vo.Error;
import com.nju.ee.vo.PersonDescVo;
import com.nju.ee.vo.RestResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 克崽兽 on 2016/12/5.
 */
@Service
public class PersonServiceImpl implements PersonService {
    @Autowired
    private PersonDao personDao;

    public RestResult getPeople() {
        List<Person> people = personDao.getPeople();
        Map<String, List<PersonDescVo>> classifiedPeople = new HashMap<>();
        for (Person person : people) {
            String level = person.getLevel();
            if(!classifiedPeople.containsKey(level)){
                classifiedPeople.put(level, new ArrayList<PersonDescVo>());
            }
            classifiedPeople.get(level).add(new PersonDescVo(person));
        }
        return RestResult.CreateResult(1,classifiedPeople);
    }

    public RestResult getPersonDetail(Integer id) {
        if (id == null) {
            return RestResult.CreateResult(0, new Error(Error.BAD_PARAM, "缺少人员编号"));
        }
        Person person = personDao.getPersonById(id);
        if (person == null) {
            return RestResult.CreateResult(0, new Error(Error.BAD_PARAM, "不存在该编号的人员"));
        }
        PersonDescVo vo = new PersonDescVo(person);
        return RestResult.CreateResult(1, vo);
    }

    public RestResult addPerson(PersonDescVo personDescVo) {
        Person person = new Person(personDescVo);
        Person savedPerson = personDao.save(person);
        if (savedPerson == null) {
            return RestResult.CreateResult(0, new Error(Error.SYS_ERROR, "存储过程出错"));
        }
        PersonDescVo vo = new PersonDescVo(savedPerson);
        return RestResult.CreateResult(1, vo);
    }

    public RestResult modifyPerson(Integer id, PersonDescVo person) {
        if (id == null) {
            return RestResult.CreateResult(0, new Error(Error.BAD_PARAM, "缺少人员编号"));
        }
        Person modifiedPerson = personDao.getPersonById(id);
        if (modifiedPerson == null) {
            return RestResult.CreateResult(0, new Error(Error.BAD_PARAM, "不存在该编号的人员"));
        }
        modifiedPerson.setName(person.getName());
        modifiedPerson.setLevel(person.getTitle());
        modifiedPerson.setAvatar(person.getAvatar());
        modifiedPerson.setDepartment(person.getDepartment());
        modifiedPerson.setPosition(person.getPosition());
        modifiedPerson.setIntroduction(person.getIntroduction());

        Person updatedPerson = personDao.update(modifiedPerson);
        if (updatedPerson == null) {
            return RestResult.CreateResult(0, new Error(Error.SYS_ERROR, "修改过程出错"));
        }
        PersonDescVo vo = new PersonDescVo(updatedPerson);
        return RestResult.CreateResult(1, vo);
    }

    public RestResult deletePerson(Integer id) {
        if (id == null) {
            return RestResult.CreateResult(0, new Error(Error.BAD_PARAM, "缺少人员编号"));
        }
        Person uselessPerson = personDao.getPersonById(id);
        if (uselessPerson == null) {
            return RestResult.CreateResult(0, new Error(Error.BAD_PARAM, "不存在该编号的人员"));
        }
        Person deletedPerson = personDao.delete(uselessPerson);
        if (uselessPerson == null) {
            return RestResult.CreateResult(0, new Error(Error.SYS_ERROR, "删除过程出错"));
        }
        PersonDescVo vo = new PersonDescVo(deletedPerson);
        return RestResult.CreateResult(1, vo);
    }
}
