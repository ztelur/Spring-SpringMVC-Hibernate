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
public class BannerServiceImpl implements BannerService {
    @Autowired
    private BannerDao bannerDao;
    @Autowired
    private FileService fileService;

    @Override
    public RestResult getBanners() {
        List<Banner> banners = bannerDao.getBanners();
        List<BannerVo> bannersVo = new ArrayList<>();
        for (Banner banner : banners) {
            bannersVo.add(new BannerVo(banner));
        }
        return RestResult.CreateResult(1, bannersVo);
    }

    @Override
    public RestResult getBannerDetail(Integer id) {
        if (id == null) {
            return RestResult.CreateResult(0, new Error(Error.BAD_PARAM, "缺少banner编号"));
        }
        Banner banner = bannerDao.getBannerById(id);
        if (banner == null) {
            return RestResult.CreateResult(0, new Error(Error.BAD_PARAM, "不存在该的banner"));
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
    public RestResult modifyBanner(BannerVo bannerVo) {
        Integer id = bannerVo.getId();
        if (id == null) {
            return RestResult.CreateResult(0, new Error(Error.BAD_PARAM, "缺少banner编号"));
        }
        Banner modifiedBanner = bannerDao.getBannerById(id);
        if (modifiedBanner == null) {
            return RestResult.CreateResult(0, new Error(Error.BAD_PARAM, "不存在该编号的banner"));
        }

        String useLessImageUrl = modifiedBanner.getImageUrl();
        //修改所有（可修改的）属性
        //判断是否有图片上传，若有，调用FileService接口上传文件并将url进行替换，否则无需修改
        if (bannerVo.getPicture() != null) {
            RestResult result = fileService.saveFile(bannerVo.getPicture());
            if(result.getResult()!=1) {
                return result;
            }
            modifiedBanner.setImageUrl((String) result.getData());
        }
        modifiedBanner.setTitle(bannerVo.getTitle());
        modifiedBanner.setInfoUrl(bannerVo.getInfoUrl());
        modifiedBanner.setBrief(bannerVo.getBrief());
        modifiedBanner.setEnabled(bannerVo.isEnabled());

        Banner updatedBanner = bannerDao.update(modifiedBanner);

        if (updatedBanner == null) {
            //修改失败，删除新的banner图片
            fileService.deleteFile(modifiedBanner.getImageUrl());
            return RestResult.CreateResult(0, new Error(Error.SYS_ERROR, "修改过程出错"));
        }
        //若修改成功，删除原banner图片
        fileService.deleteFile(useLessImageUrl);
        BannerVo vo = new BannerVo(updatedBanner);
        return RestResult.CreateResult(1, vo);
    }

    @Override
    public RestResult deleteBanner(Integer id) {
        if (id == null) {
            return RestResult.CreateResult(0, new Error(Error.BAD_PARAM, "缺少Banner编号"));
        }
        Banner uselessBanner = bannerDao.getBannerById(id);
        if (uselessBanner == null) {
            return RestResult.CreateResult(0, new Error(Error.BAD_PARAM, "不存在该编号的Banner"));
        }
        Banner deletedBanner = bannerDao.delete(uselessBanner);
        if (deletedBanner == null) {
            return RestResult.CreateResult(0, new Error(Error.SYS_ERROR, "删除过程出错"));
        }
        BannerVo vo = new BannerVo(deletedBanner);
        return RestResult.CreateResult(1, vo);
    }
}
