package com.nju.ee.DAO;

import com.nju.ee.entity.Equipment;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by zangxiaojie on 2016/12/2.
 */
@Repository
public class EquipmentDaoImpl implements EquipmentDao {
    @Autowired
    private BaseDao baseDao;

    @Override
    public Equipment getEquipmentById(int id) {
        Session session = baseDao.getSession();
        Criteria cri = session.createCriteria(Equipment.class);
        cri.add(Restrictions.eq("id", id));
        List<Equipment> list = cri.list();
        if (list.size() > 0) {
            return list.get(0);
        }
        return null;

    }

    @Override
    public void save(Equipment e) {
        try {
            baseDao.save(e);
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }

    @Override
    public void update(Equipment e) {
        try {
            baseDao.update(e);
        } catch (Exception e1) {
            e1.printStackTrace();
        }

    }

    @Override
    public void delete(Equipment e) {
        try {
            baseDao.delete(e);
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }
}
