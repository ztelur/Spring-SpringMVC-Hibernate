package com.nju.ee.service;

import com.nju.ee.po.PersonPo;
import com.nju.ee.po.RestResult;

/**
 * Created by 克崽兽 on 2016/12/5.
 */
public interface PersonService {
    public RestResult getPersons();

    public RestResult getPersonDetail(Integer id);
    
    public RestResult addPerson(PersonPo person);

    public RestResult modifyPerson(Integer id, PersonPo person);

    public RestResult deletePerson(Integer id);
}
