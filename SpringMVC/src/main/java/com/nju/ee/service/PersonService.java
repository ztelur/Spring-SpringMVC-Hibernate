package com.nju.ee.service;

import com.nju.ee.vo.PersonDescVo;
import com.nju.ee.vo.RestResult;

/**
 * Created by 克崽兽 on 2016/12/5.
 */
public interface PersonService {
    public RestResult getPeople();

    public RestResult getPersonDetail(Integer id);
    
    public RestResult addPerson(PersonDescVo person);

    public RestResult modifyPerson(Integer id, PersonDescVo person);

    public RestResult deletePerson(Integer id);
}
