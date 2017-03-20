package com.nju.ee.service;

import com.nju.ee.vo.EquipmentForm;
import com.nju.ee.vo.EquipmentVo;
import com.nju.ee.vo.RestResult;
import org.springframework.data.domain.Pageable;

/**
 * Created by 张韶阳 on 16/12/14.
 */
public interface EquipmentService {
    EquipmentVo addEquipment(EquipmentForm form);
    boolean deleteEquipment(int id);
    EquipmentVo modifyEquipment(EquipmentForm form,int id);
    EquipmentVo findById(int id);
    RestResult query(Pageable pageable);
}
