package com.nju.ee.service;

import com.nju.ee.entity.Equipment;
import com.nju.ee.vo.EquipmentForm;
import com.nju.ee.vo.EquipmentVo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Created by 张韶阳 on 16/12/14.
 */
public interface EquipmentService {
    EquipmentVo addEquipment(EquipmentForm form);
    boolean deleteEquipment(int id);
    EquipmentVo modifyEquipment(EquipmentForm form,int id);
    EquipmentVo findById(int id);
    Page<EquipmentVo> query(Pageable pageable);
}
