package com.nju.ee.DAO;

import com.nju.ee.entity.Banner;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by 克崽兽 on 2016/12/16.
 */
@Repository
public class BannerDaoImpl implements BannerDao{
    @Autowired
    private BaseDao baseDao;

    @Override
    public Banner getBannerByPosition(int position) {
        Session session=baseDao.getSession();
        Criteria cri=session.createCriteria(Banner.class);
        cri.add(Restrictions.eq("position",position));
        List<Banner> list=cri.list();
        if (list.size()<=0){
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<Banner> getBanners() {
        List<Banner> banners= baseDao.getAllList(Banner.class);
        return banners;
    }

    @Override
    public Banner update(Banner banner) {
        Banner updatedBanner;
        try {
            baseDao.update(banner);
            updatedBanner = banner;
        } catch (Exception e) {
//            e.printStackTrace();
            updatedBanner = null;
        }

        return updatedBanner;
    }

    @Override
    public Banner delete(Banner banner) {
        Banner deletedBanner;
        try {
            baseDao.delete(banner);
            deletedBanner = banner;
        } catch (Exception e) {
//            e.printStackTrace();
            deletedBanner = null;
        }
        return deletedBanner;
    }

    @Override
    public Banner save(Banner banner) {
        Banner savedBanner;
        try {
            baseDao.save(banner);
            savedBanner = banner ;
        } catch (Exception e) {
//            e.printStackTrace();
            savedBanner = null;
        }
        return savedBanner;
    }
}
