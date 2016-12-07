package com.nju.ee.DAO;

import com.nju.ee.entity.Equipment;

/**
 * Created by zangxiaojie on 2016/12/7.
 */
public interface EquipmentDao {
    public Equipment getEquipmentById(int id);
    public void save(Equipment e);
    public void update(Equipment e);
    public void delete(Equipment e);

}
