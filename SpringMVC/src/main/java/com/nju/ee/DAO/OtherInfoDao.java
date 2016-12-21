package com.nju.ee.DAO;

import com.nju.ee.entity.OtherInfo;

/**
 * Created by zangxiaojie on 2016/12/20.
 */
public interface OtherInfoDao {
     OtherInfo getOtherInfo();
     OtherInfo update(OtherInfo otherInfo);
     OtherInfo save(OtherInfo otherInfo);
}
