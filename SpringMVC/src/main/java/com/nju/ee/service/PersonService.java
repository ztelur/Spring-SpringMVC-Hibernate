package com.nju.ee.service;

import com.nju.ee.vo.PersonVo;
import com.nju.ee.vo.RestResult;

/**
 * Created by 克崽兽 on 2016/12/5.
 */
public interface PersonService {
    public RestResult getPeople();

    public RestResult getPersonDetail(Integer id);
    
    public RestResult addPerson(PersonVo person);

    public RestResult modifyPerson(Integer id, PersonVo person);

    public RestResult deletePerson(Integer id);
}
