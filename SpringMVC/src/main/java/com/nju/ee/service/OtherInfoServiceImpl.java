package com.nju.ee.service;

import com.nju.ee.DAO.OtherInfoDao;
import com.nju.ee.entity.OtherInfo;
import com.nju.ee.vo.Error;
import com.nju.ee.vo.OtherInfoVo;
import com.nju.ee.vo.RestResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by zangxiaojie on 2016/12/20.
 */
@Service
public class OtherInfoServiceImpl implements OtherInfoService {

    @Autowired
    private OtherInfoDao otherInfoDao;

    @Override
    public RestResult getOtherInfo() {
        OtherInfo otherInfo=otherInfoDao.getOtherInfo();
        if (otherInfo ==null){
            return RestResult.CreateResult(0,new Error(Error.BAD_PARAM,"不存在其他信息"));
        }
        OtherInfoVo otherInfoVo=new OtherInfoVo(otherInfo);
        return RestResult.CreateResult(1,otherInfoVo);
    }

    @Override
    public RestResult modifyOtherInfo(OtherInfoVo otherInfoVo) {
        if (otherInfoVo ==null){
            return RestResult.CreateResult(0,new Error(Error.BAD_PARAM,"不存在其他信息"));
        }
        OtherInfo otherInfo=otherInfoDao.getOtherInfo();
        if (otherInfo ==null){
            return RestResult.CreateResult(0,new Error(Error.BAD_PARAM,"不存在其他信息"));
        }
        otherInfo.setEmail(otherInfoVo.getEmail());
        otherInfo.setLongitude(otherInfoVo.getLongitude());
        otherInfo.setFax(otherInfoVo.getFax());
        otherInfo.setTelephone(otherInfoVo.getTelephone());
        otherInfo.setLatitude(otherInfoVo.getLatitude());

        OtherInfo updateInfo=otherInfoDao.update(otherInfo);
        if (updateInfo ==null){
            return RestResult.CreateResult(0,new Error(Error.BAD_PARAM,"更新其他信息失败"));
        }
        OtherInfoVo vo=new OtherInfoVo(otherInfo);
        return RestResult.CreateResult(1,vo);
    }
}
