package com.nju.ee.DAO;

import com.nju.ee.entity.Banner;

import java.util.List;

/**
 * Created by 克崽兽 on 2016/12/16.
 */
public interface BannerDao {
    Banner getBannerByPosition(int position);

    List<Banner> getBanners();

    Banner update(Banner banner);

    Banner delete(Banner banner);

    Banner save(Banner banner);
}
