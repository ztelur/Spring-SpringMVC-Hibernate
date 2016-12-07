package com.nju.ee.DAO;

import com.nju.ee.entity.Team;

/**
 * Created by zangxiaojie on 2016/12/7.
 */
public interface TeamDao {
    public Team getTeamId(int id);
    public void save(Team t);
    public void update(Team t);
    public void delete(Team t);
}
