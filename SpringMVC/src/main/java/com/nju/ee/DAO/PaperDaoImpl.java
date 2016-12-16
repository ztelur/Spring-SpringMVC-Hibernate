package com.nju.ee.DAO;

import com.nju.ee.Constant.Constant;
import com.nju.ee.entity.Paper;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by homer on 16-12-16.
 */
@Repository
public class PaperDaoImpl implements PaperDao {
    @Autowired
    private BaseDao baseDao;

    @Override
    public Paper getPaperById(int id) {
        Session session = baseDao.getSession();
        Criteria cri = session.createCriteria(Paper.class);
        cri.add(Restrictions.eq("id", id));
        List<Paper> list = cri.list();
        if (list.size() <= 0) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<Paper> getPapersWithpaper(int page) {
        if (page < 1) {
            page = 1;
        }
        int first = (page - 1) * Constant.PAGE_COUNT;
        Session session = baseDao.getSession();
        Criteria criteria = session.createCriteria(Paper.class);
        criteria.setFirstResult(first);
        criteria.setMaxResults(Constant.PAGE_COUNT);
        List<Paper> result = criteria.list();
        session.flush();
        session.close();
        return result;
    }

    @Override
    public Paper update(Paper paper) {
        Paper updatedPaper;
        try {
            baseDao.update(paper);
            updatedPaper = paper;
        } catch (Exception e) {
            updatedPaper = null;
        }
        return updatedPaper;
    }

    @Override
    public Paper delete(Paper paper) {
        Paper deletedPaper;
        try {
            baseDao.delete(paper);
            deletedPaper = paper;
        } catch (Exception e) {
            deletedPaper = null;
        }
        return deletedPaper;
    }

    @Override
    public Paper save(Paper paper) {
        Paper savedPaper;
        try {
            baseDao.save(paper);
            savedPaper = paper;
        } catch (Exception e) {
            savedPaper = null;
        }
        return savedPaper;
    }
}
