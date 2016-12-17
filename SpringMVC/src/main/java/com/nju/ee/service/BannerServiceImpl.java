package com.nju.ee.service;

import com.nju.ee.DAO.BannerDao;
import com.nju.ee.entity.Banner;
import com.nju.ee.vo.BannerVo;
import com.nju.ee.vo.Error;
import com.nju.ee.vo.RestResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 克崽兽 on 2016/12/16.
 */
@Service
public class BannerServiceImpl  implements  BannerService{
    @Autowired
    private BannerDao bannerDao;
    @Autowired
    private FileService fileService;
    @Override
    public RestResult getBanners() {
        List<Banner> banners = bannerDao.getBanners();
        List<BannerVo> bannersVo = new ArrayList<>();
        for (Banner banner:banners) {
            bannersVo.add(new BannerVo(banner));
        }
        return RestResult.CreateResult(1,bannersVo);
    }

    @Override
    public RestResult getBannerDetail(Integer position) {
        if (position == null) {
            return RestResult.CreateResult(0, new Error(Error.BAD_PARAM, "缺少banner位置"));
        }
        Banner banner = bannerDao.getBannerByPosition(position);
        if (banner == null) {
            return RestResult.CreateResult(0, new Error(Error.BAD_PARAM, "不存在该位置的banner"));
        }
        BannerVo vo = new BannerVo(banner);
        return RestResult.CreateResult(1, vo);
    }

    @Override
    public RestResult addBanner(BannerVo bannerVo) {
        Banner banner = new Banner(bannerVo);
        Banner savedBanner = bannerDao.save(banner);
        if (savedBanner == null) {
            return RestResult.CreateResult(0, new Error(Error.SYS_ERROR, "存储过程出错"));
        }
        BannerVo vo = new BannerVo(savedBanner);
        return RestResult.CreateResult(1, vo);
    }

    @Override
    public RestResult modifyBanner( BannerVo bannerVo) {
        Integer position = bannerVo.getPosition();
        if (position == null) {
            return RestResult.CreateResult(0, new Error(Error.BAD_PARAM, "缺少banner位置"));
        }
        Banner modifiedBanner = bannerDao.getBannerByPosition(position);
        if (modifiedBanner == null) {
            return RestResult.CreateResult(0, new Error(Error.BAD_PARAM, "不存在该位置的banner"));
        }
        //判断是否有图片上传，若有，调用FileService接口上传文件并将url存入bannerVo
        if(bannerVo.getPicture()!=null){
            RestResult result = fileService.saveFile(bannerVo.getPicture());
            if(result.getResult()==1){
                bannerVo.setImageUrl((String) result.getData());
            }else{
                bannerVo.setImageUrl(null);
            }
        }else{
            bannerVo.setImageUrl(null);
        }

        modifiedBanner.setImageUrl(bannerVo.getImageUrl());
        modifiedBanner.setInfoUrl(bannerVo.getInfoUrl());
        modifiedBanner.setBrief(bannerVo.getBrief());
        modifiedBanner.setEnabled(bannerVo.isEnabled());

        Banner updatedBanner = bannerDao.update(modifiedBanner);
        if (updatedBanner == null) {
            return RestResult.CreateResult(0, new Error(Error.SYS_ERROR, "修改过程出错"));
        }
        BannerVo vo = new BannerVo(updatedBanner);
        return RestResult.CreateResult(1, vo);
    }

    @Override
    public RestResult deleteBanner(Integer position) {
        if (position == null) {
            return RestResult.CreateResult(0, new Error(Error.BAD_PARAM, "缺少Banner位置"));
        }
        Banner uselessBanner = bannerDao.getBannerByPosition(position);
        if (uselessBanner == null) {
            return RestResult.CreateResult(0, new Error(Error.BAD_PARAM, "不存在该位置的Banner"));
        }
        Banner deletedBanner = bannerDao.delete(uselessBanner);
        if (deletedBanner == null) {
            return RestResult.CreateResult(0, new Error(Error.SYS_ERROR, "删除过程出错"));
        }
        BannerVo vo = new BannerVo(deletedBanner);
        return RestResult.CreateResult(1, vo);
    }
}
