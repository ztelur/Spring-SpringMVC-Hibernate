package com.nju.ee.DAO;

import com.nju.ee.entity.Equipment;

import java.util.List;

/**
 * Created by zangxiaojie on 2016/12/7.
 */
public interface EquipmentDao {
    Equipment getEquipmentById(int id);

    List<Equipment> getEquipmentWithPage(int page);

    Equipment update(Equipment equipment);

    Equipment delete(Equipment equipment);

    Equipment save(Equipment equipment);

}
