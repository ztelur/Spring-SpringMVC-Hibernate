package com.nju.ee.service;

import com.nju.ee.vo.PaperVo;
import com.nju.ee.vo.RestResult;

/**
 * Created by homer on 16-12-16.
 */
public interface PaperService {
     RestResult getPapers(Integer pageNum, Integer pageSize);
     RestResult getPaperDetail(Integer id);
     RestResult addPaper(PaperVo paper);
     RestResult modifyPaper(Integer id, PaperVo paper);
     RestResult deletePaper(Integer id);
}
