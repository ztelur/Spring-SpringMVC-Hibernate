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
    @Autowired
    private FileService fileService;

    public RestResult getPeople() {
        List<Person> people = personDao.getPeople();
        Map<String, List<PersonDescVo>> classifiedPeople = new HashMap<>();
        for (Person person : people) {
            String level = person.getLevel();
            if (!classifiedPeople.containsKey(level)) {
                classifiedPeople.put(level, new ArrayList<PersonDescVo>());
            }
            classifiedPeople.get(level).add(new PersonDescVo(person));
        }
        return RestResult.CreateResult(1, classifiedPeople);
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
        if (personDescVo.getImage() != null) {
            RestResult result = fileService.saveFile(personDescVo.getImage());
            personDescVo.setImageUrl((String) result.getData());
        } else {
            personDescVo.setImageUrl(null);
        }

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
        //如果存在外键，需要使用getDetachedPersonById(id)获取处于detached状态的对象以进行更新
        Person modifiedPerson = personDao.getPersonById(id);
        if (modifiedPerson == null) {
            return RestResult.CreateResult(0, new Error(Error.BAD_PARAM, "不存在该编号的人员"));
        }
        String useLessImageUrl = modifiedPerson.getImage();
        if (person.getImage() != null) {
            RestResult result = fileService.saveFile(person.getImage());
            if(result.getResult()!=1) {
                return result;
            }
            modifiedPerson.setImage((String) result.getData());
        }
        modifiedPerson.setName(person.getName());
        modifiedPerson.setLevel(person.getLevel());
        modifiedPerson.setIntroduction(person.getIntroduction());

        Person updatedPerson = personDao.update(modifiedPerson);
        if (updatedPerson == null) {
            //修改失败，删除新的头像图片
            fileService.deleteFile(modifiedPerson.getImage());
            return RestResult.CreateResult(0, new Error(Error.SYS_ERROR, "修改过程出错"));
        }
        //若修改成功，删除原头像图片
        fileService.deleteFile(useLessImageUrl);
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
//        for (Team team:uselessPerson.getTeams()) {
//            team.getPeople().remove(uselessPerson);
//        }
//        uselessPerson.setTeams(null);
        Person deletedPerson = personDao.delete(uselessPerson);
        if (deletedPerson == null) {
            return RestResult.CreateResult(0, new Error(Error.SYS_ERROR, "删除过程出错"));
        }
        PersonDescVo vo = new PersonDescVo(deletedPerson);
        return RestResult.CreateResult(1, vo);
    }
}
