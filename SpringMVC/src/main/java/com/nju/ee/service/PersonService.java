package com.nju.ee.service;

import com.nju.ee.vo.PersonDescVo;
import com.nju.ee.vo.RestResult;

/**
 * Created by 克崽兽 on 2016/12/5.
 */
public interface PersonService {
    /**
     * 获取人员列表
     * @return RestResult对象，result属性为是否成功，
     * data属性为按照level进行分类的人员列表，
     * error属性为出错信息
     */
    public RestResult getPeople();

    public RestResult getPersonDetail(Integer id);
    
    public RestResult addPerson(PersonDescVo person);

    public RestResult modifyPerson(Integer id, PersonDescVo person);

    public RestResult deletePerson(Integer id);
}
