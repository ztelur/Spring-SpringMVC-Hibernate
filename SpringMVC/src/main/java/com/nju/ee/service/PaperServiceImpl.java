package com.nju.ee.service;

import com.nju.ee.Constant.Constant;
import com.nju.ee.DAO.PaperDao;
import com.nju.ee.DAO.PaperRepository;
import com.nju.ee.entity.Paper;
import com.nju.ee.vo.*;
import com.nju.ee.vo.Error;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by homer on 16-12-16.
 */
@Service
public class PaperServiceImpl implements PaperService {
    @Autowired
    private PaperDao paperDao;
    //用于处理分页
    @Autowired
    private PaperRepository paperRepository;

    @Autowired
    private FileService fileService;

    @Override
    public RestResult getPapers(Integer page, Integer num) {

        page = (page == null || page < 1) ? 1 : page;
        num = (num == null || num < 1) ? Constant.PAGE_COUNT : num;
        //
        Sort sort = new Sort(new Sort.Order(Sort.Direction.DESC, "date"));
        Pageable request = new PageRequest(page - 1, num, sort);
        org.springframework.data.domain.Page<Paper> papers = paperRepository.findAll(request);
        GenericVoPage<PaperVo> voPage = new GenericVoPage<PaperVo>(papers.getSize(), papers.getNumber(),
                                                            papers.getTotalPages());
        for (Paper itr : papers.getContent()) {
            PaperVo vo = new PaperVo(itr);
            voPage.getData().add(vo);
        }
        return RestResult.CreateResult(1, voPage);
    }

    @Override
    public RestResult getPaperDetail(Integer id) {
        if (id == null) {
            return RestResult.CreateResult(0, new Error(Error.BAD_PARAM, "缺少文章编号"));
        }
        Paper paper = paperDao.getPaperById(id);
        if (paper == null) {
            return RestResult.CreateResult(0, new Error(Error.BAD_PARAM, "不存在该编号的论文"));
        }
        PaperVo vo = new PaperVo(paper);
        return RestResult.CreateResult(1, vo);
    }

    @Override
    public RestResult addPaper(PaperVo paperVo) {

        RestResult urlResult = fileService.saveFile(paperVo.getPdf());
        String url;
        if(urlResult.getResult()==1) {
            url = "{\"link\":\""+(String) urlResult.getData()+"\"}";
            System.out.println("add paper url is " + url);
        }else{
            url = null;
            System.out.println("add paper url is " + url + " " + paperVo.getPdf().getName());
        }
        paperVo.setUrl(url);
        Paper paper = new Paper(paperVo);
        paper.setDate(new Date());
        Paper savedPaper = paperDao.save(paper);
        if (savedPaper == null) {
            return RestResult.CreateResult(0, new Error(Error.SYS_ERROR, "存储过程出错"));
        }
        PaperVo vo = new PaperVo(savedPaper);
        return RestResult.CreateResult(1, vo);
    }

    @Override
    public RestResult modifyPaper(Integer id, PaperVo paper) {
        if (id == null) {
            return RestResult.CreateResult(0, new Error(Error.BAD_PARAM, "缺少新闻编号"));
        }
        Paper modifiedPaper = paperDao.getPaperById(id);
        if (modifiedPaper == null) {
            return RestResult.CreateResult(0, new Error(Error.BAD_PARAM, "不存在该编号的论文"));
        }
        modifiedPaper.setTitle(paper.getTitle());
        modifiedPaper.setDescription(paper.getDesc());
        modifiedPaper.setUrl(paper.getUrl());
        Paper updatedPaper = paperDao.update(modifiedPaper);
        if(updatedPaper==null){
            return RestResult.CreateResult(0,new Error(Error.SYS_ERROR,"修改过程出错"));
        }
        PaperVo vo =new PaperVo(updatedPaper);
        return RestResult.CreateResult(1,vo);
    }

    @Override
    public RestResult deletePaper(Integer id) {
        if (id == null) {
            return RestResult.CreateResult(0, new Error(Error.BAD_PARAM, "缺少论文编号"));
        }
        Paper uselessPaper = paperDao.getPaperById(id);
        if (uselessPaper == null) {
            return RestResult.CreateResult(0, new Error(Error.BAD_PARAM, "不存在该编号的论文"));
        }
        Paper deletedPaper = paperDao.delete(uselessPaper);
        if(deletedPaper==null){
            return RestResult.CreateResult(0,new Error(Error.SYS_ERROR,"删除过程出错"));
        }
        PaperVo vo =new PaperVo(deletedPaper);
        return RestResult.CreateResult(1,vo);
    }
}
