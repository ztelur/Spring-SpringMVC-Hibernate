package com.nju.ee.service;

import com.nju.ee.Constant.RichTextUtil;
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

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 张韶阳 on 16/12/14.
 */
@Service
public class EquipmentServiceImpl implements EquipmentService {
    @Autowired
    EquipmentRepository repository;
    @Autowired
    EquipmentDao dao;
    @Autowired
    FileService fileService;

    @Override
    public EquipmentVo addEquipment(EquipmentForm form) {
        Equipment equipment = new Equipment();
        equipment.setName(form.getName());
        equipment.setDescription(form.getDescription());
        String url = null;
        if (form.getImage() != null) {
            RestResult result = fileService.saveFile(form.getImage());
            if (result.getResult() == 1)
                url = result.getData().toString();
        }
        equipment.setUrl(url);
        equipment = dao.save(equipment);
        EquipmentVo vo = new EquipmentVo();
        vo.setDescription(equipment.getDescription());
        vo.setName(equipment.getName());
        vo.setId(equipment.getId());
        vo.setUrl(url);
        return vo;
    }

    @Override
    public boolean deleteEquipment(int id) {
        Equipment uselessEquipment = dao.getEquipmentById(id);
        if (uselessEquipment == null)
            return false;
        Equipment deletedEquipment = dao.delete(uselessEquipment);
        if (deletedEquipment == null) {
            return false;
        }
        fileService.deleteFile(deletedEquipment.getUrl());
        List<String> images = RichTextUtil.getImageUrlsFromContent(deletedEquipment.getDescription());
        for (String url : images) {
            fileService.deleteFile(url);
        }
        return true;
    }

    @Override
    public EquipmentVo modifyEquipment(EquipmentForm vo, int id) {
        Equipment modifiedEquipment = dao.getEquipmentById(id);
        if (modifiedEquipment == null)
            return null;

        String uselessDescription = modifiedEquipment.getDescription();
        String uselessImageUrl = "";
        if (vo.getImage() != null) {
            uselessImageUrl = modifiedEquipment.getUrl();
            RestResult result = fileService.saveFile(vo.getImage());
            if (result.getResult() == 1)
                modifiedEquipment.setUrl(result.getData().toString());
        }
        modifiedEquipment.setName(vo.getName());
        modifiedEquipment.setDescription(vo.getDescription());

        Equipment updatedEquipment = dao.update(modifiedEquipment);
        String usefulDescription = updatedEquipment.getDescription();

        List<String> imagesBefore = RichTextUtil.getImageUrlsFromContent(uselessDescription);
        List<String> imagesAfter = RichTextUtil.getImageUrlsFromContent(usefulDescription);

        if (updatedEquipment == null) {
            //修改失败，删除新的图片
            fileService.deleteFile(modifiedEquipment.getUrl());
            //在旧的介绍内容中不存在的图片信息
            List<String> usefulImages = new ArrayList<>(imagesAfter);
            usefulImages.removeAll(imagesBefore);
            for (String url: usefulImages) {
                fileService.deleteFile(url);
            }
            return null;
        }
        //修改成功，删除旧的图片
        fileService.deleteFile(uselessImageUrl);
        //在新的介绍内容中不存在的图片信息
        List<String> uselessImages = new ArrayList<>(imagesBefore);
        uselessImages.removeAll(imagesAfter);
        for (String url: uselessImages) {
            fileService.deleteFile(url);
        }

        EquipmentVo equipmentVo = new EquipmentVo(id, vo.getName(), vo.getDescription(), modifiedEquipment.getUrl());
        return equipmentVo;
    }

    @Override
    public EquipmentVo findById(int id) {
        Equipment equipment = dao.getEquipmentById(id);
        if (equipment == null)
            return null;
        EquipmentVo equipmentVo = new EquipmentVo(id, equipment.getName(), equipment.getDescription(), equipment.getUrl());
        return equipmentVo;
    }

    @Override
    public RestResult query(Pageable pageable) {
        Page<Equipment> page = repository.findAll(pageable);
        List<Equipment> list = page.getContent();
//        List<EquipmentVo> voList=new ArrayList<>();
//        long total=page.getTotalElements();
        GenericVoPage<EquipmentVo> voPage = new GenericVoPage<>(page.getSize(), page.getNumber(), page.getTotalPages());

        for (Equipment equipment : list) {
            //voList.add(new EquipmentVo(equipment.getId(),equipment.getName(), equipment.getDescription(),equipment.getUrl()));
            EquipmentVo vo = new EquipmentVo(equipment.getId(), equipment.getName(), equipment.getDescription(), equipment.getUrl());
            voPage.getData().add(vo);
        }
        //PageImpl<EquipmentVo> pvo=new PageImpl<EquipmentVo>(voList,pageable,total);
        return RestResult.CreateResult(1, voPage);
    }

    private String getImageUrl(EquipmentForm form) {
        String content = form.getDescription();
        if (content == null)
            return null;
        String url = null;
        try {
            Parser parser = new Parser(content);
            NodeFilter filter = new NodeClassFilter(ImageTag.class);
            NodeList list = parser.extractAllNodesThatMatch(filter);
            for (Node node : list.toNodeArray()) {
                ImageTag tag = (ImageTag) node;
                url = tag.getImageURL();
                if (url != null) {
                    return url;
                }
            }
        } catch (ParserException e) {
            e.printStackTrace();
        } finally {
            return url;
        }
    }
}
