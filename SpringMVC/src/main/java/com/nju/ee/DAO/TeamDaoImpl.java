package com.nju.ee.DAO;

import com.nju.ee.entity.Team;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by zangxiaojie on 2016/12/2.
 */
@Repository
public class TeamDaoImpl implements TeamDao {
    @Autowired
    private BaseDao baseDao;

    @Override
    public Team getTeamId(int id) {
        Session session = baseDao.getSession();
        Criteria cri = session.createCriteria(Team.class);
        cri.add(Restrictions.eq("id", id));
        List<Team> list = cri.list();
        if (list.size() > 0) {
            return list.get(0);
        }
        return null;

    }

    @Override
    public void save(Team t) {
        try {
            baseDao.save(t);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Team t) {
        try {
            baseDao.update(t);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    @Override
    public void delete(Team t) {
        try {
            baseDao.delete(t);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
