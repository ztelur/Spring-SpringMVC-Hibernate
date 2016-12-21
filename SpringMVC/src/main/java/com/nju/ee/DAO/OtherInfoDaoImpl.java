package com.nju.ee.DAO;

import com.nju.ee.entity.OtherInfo;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by zangxiaojie on 2016/12/20.
 */
@Repository
public class OtherInfoDaoImpl implements OtherInfoDao {

    @Autowired
    private BaseDao baseDao;

    @Override
    public OtherInfo getOtherInfo() {
        Session session=baseDao.getSession();
        Criteria cri=session.createCriteria(OtherInfo.class);
        List<OtherInfo> list=cri.list();
        if(list!=null){
            return list.get(0);
        }
        else
            System.out.println("Error:Other info is null!");
        return null;
    }

    @Override
    public OtherInfo update(OtherInfo otherInfo)  {
        OtherInfo o;

        try {
            baseDao.update(otherInfo);
            o=otherInfo;
        } catch (Exception e) {
            o=null;
            e.printStackTrace();
        }
        return o;
    }

    @Override
    public OtherInfo save(OtherInfo otherInfo) {
        OtherInfo o;

        try {
            baseDao.save(otherInfo);
            o=otherInfo;
        } catch (Exception e) {
            o=null;
            e.printStackTrace();
        }
        return o;
    }
}
