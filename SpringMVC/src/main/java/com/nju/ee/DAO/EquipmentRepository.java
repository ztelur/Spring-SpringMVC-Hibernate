package com.nju.ee.DAO;

import com.nju.ee.entity.Equipment;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.RepositoryDefinition;

/**
 * Created by 张韶阳 on 16/12/14.
 */
@RepositoryDefinition(domainClass=Equipment.class, idClass=Integer.class)
public interface EquipmentRepository extends PagingAndSortingRepository<Equipment, Integer> {
}
