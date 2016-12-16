package com.nju.ee.service;

import com.nju.ee.vo.BannerVo;
import com.nju.ee.vo.RestResult;

/**
 * Created by 克崽兽 on 2016/12/16.
 */
public interface BannerService {
    public RestResult getBanners();

    public RestResult getBannerDetail(Integer position);

    public RestResult addBanner(BannerVo bannerVo);

    public RestResult modifyBanner(Integer position, BannerVo bannerVo);

    public RestResult deleteBanner(Integer position);
}
