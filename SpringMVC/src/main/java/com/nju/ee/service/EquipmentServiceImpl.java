package com.nju.ee.service;

import com.nju.ee.DAO.EquipmentDao;
import com.nju.ee.DAO.EquipmentRepository;
import com.nju.ee.entity.Equipment;
import com.nju.ee.vo.EquipmentForm;
import com.nju.ee.vo.EquipmentVo;
import com.nju.ee.vo.GenericVoPage;
import com.nju.ee.vo.RestResult;
import org.htmlparser.Node;
import org.htmlparser.NodeFilter;
import org.htmlparser.Parser;
import org.htmlparser.filters.NodeClassFilter;
import org.htmlparser.tags.ImageTag;
import org.htmlparser.util.NodeList;
import org.htmlparser.util.ParserException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

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
    @Autowired
    FileService fileService;
    @Override
    public EquipmentVo addEquipment(EquipmentForm form) {
        Equipment equipment=new Equipment();
        equipment.setName(form.getName());
        equipment.setDescription(form.getDescription());
        String url=null;
        if(form.getImage()!=null) {
            RestResult result = fileService.saveFile(form.getImage());
            if (result.getResult() == 1)
                url = result.getData().toString();
        }
        equipment.setUrl(url);
        equipment=dao.save(equipment);
        EquipmentVo vo=new EquipmentVo();
        vo.setDescription(equipment.getDescription());
        vo.setName(equipment.getName());
        vo.setId(equipment.getId());
        vo.setUrl(url);
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
        String url=equipment.getUrl();
        if(vo.getImage()!=null) {
            RestResult result = fileService.saveFile(vo.getImage());
            if (result.getResult() == 1)
                url = result.getData().toString();
            equipment.setUrl(url);
        }
        dao.update(equipment);
        EquipmentVo equipmentVo=new EquipmentVo(id,vo.getName(),vo.getDescription(),equipment.getUrl());
        return equipmentVo;
    }

    @Override
    public EquipmentVo findById(int id) {
        Equipment equipment=dao.getEquipmentById(id);
        if(equipment==null)
            return null;
        EquipmentVo equipmentVo=new EquipmentVo(id,equipment.getName(),equipment.getDescription(),equipment.getUrl());
        return equipmentVo;
    }

    @Override
    public RestResult query(Pageable pageable) {
        Page<Equipment> page=repository.findAll(pageable);
        List<Equipment> list=page.getContent();
//        List<EquipmentVo> voList=new ArrayList<>();
//        long total=page.getTotalElements();
        GenericVoPage<EquipmentVo> voPage = new GenericVoPage<>(page.getSize(),page.getNumber(),page.getTotalPages());

        for(Equipment equipment:list){
            //voList.add(new EquipmentVo(equipment.getId(),equipment.getName(), equipment.getDescription(),equipment.getUrl()));
            EquipmentVo vo =new EquipmentVo(equipment.getId(),equipment.getName(), equipment.getDescription(),equipment.getUrl());
            voPage.getData().add(vo);
        }
        //PageImpl<EquipmentVo> pvo=new PageImpl<EquipmentVo>(voList,pageable,total);
        return RestResult.CreateResult(1,voPage);
    }

    private String getImageUrl(EquipmentForm form){
        String content=form.getDescription();
        if (content==null)
            return null;
        String url=null;
        try {
            Parser parser=new Parser(content);
            NodeFilter filter=new NodeClassFilter(ImageTag.class);
            NodeList list=parser.extractAllNodesThatMatch(filter);
            for(Node node:list.toNodeArray()){
                ImageTag tag= (ImageTag) node;
                url=tag.getImageURL();
                if(url!=null){
                    return url;
                }
            }
        } catch (ParserException e) {
            e.printStackTrace();
        }finally {
            return url;
        }
    }
}
