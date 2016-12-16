package com.nju.ee.service;

import com.nju.ee.DAO.EquipmentDao;
import com.nju.ee.DAO.EquipmentRepository;
import com.nju.ee.entity.Equipment;
import com.nju.ee.vo.EquipmentForm;
import com.nju.ee.vo.EquipmentVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 张韶阳 on 16/12/14.
 */
@Service
public class EquipmentServiceImpl implements EquipmentService{
    @Autowired
    EquipmentRepository repository;
    @Autowired
    EquipmentDao dao;
    @Override
    public EquipmentVo addEquipment(EquipmentForm form) {
        Equipment equipment=new Equipment();
        equipment.setName(form.getName());
        equipment.setDescription(form.getDescription());
        equipment=dao.save(equipment);
        EquipmentVo vo=new EquipmentVo();
        vo.setDescription(equipment.getDescription());
        vo.setName(equipment.getName());
        vo.setId(equipment.getId());
        return vo;
    }

    @Override
    public boolean deleteEquipment(int id) {
        Equipment equipment=dao.getEquipmentById(id);
        if(equipment==null)
            return false;
        dao.delete(equipment);
        return true;
    }

    @Override
    public EquipmentVo modifyEquipment(EquipmentForm vo,int id) {
        Equipment equipment=dao.getEquipmentById(id);
        if(equipment==null)
            return null;
        equipment.setName(vo.getName());
        equipment.setDescription(vo.getDescription());
        dao.update(equipment);
        EquipmentVo equipmentVo=new EquipmentVo(id,vo.getName(),vo.getDescription());
        return equipmentVo;
    }

    @Override
    public EquipmentVo findById(int id) {
        Equipment equipment=dao.getEquipmentById(id);
        if(equipment==null)
            return null;
        EquipmentVo equipmentVo=new EquipmentVo(id,equipment.getName(),equipment.getDescription());
        return equipmentVo;
    }

    @Override
    public Page<EquipmentVo> query(Pageable pageable) {
        Page<Equipment> page=repository.findAll(pageable);
        List<Equipment> list=page.getContent();
        List<EquipmentVo> voList=new ArrayList<>();
        long total=page.getTotalElements();
        for(Equipment equipment:list){
            voList.add(new EquipmentVo(equipment.getId(),equipment.getName(), equipment.getDescription()));
        }
        PageImpl<EquipmentVo> pvo=new PageImpl<EquipmentVo>(voList,pageable,total);
        return pvo;
    }
}
