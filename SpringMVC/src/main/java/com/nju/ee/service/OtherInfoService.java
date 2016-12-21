package com.nju.ee.service;

import com.nju.ee.vo.OtherInfoVo;
import com.nju.ee.vo.RestResult;

/**
 * Created by zangxiaojie on 2016/12/20.
 */
public interface OtherInfoService {
    public RestResult getOtherInfo();
    public RestResult modifyOtherInfo(OtherInfoVo otherInfoVo);

}
