package com.nju.ee.DAO;

import com.nju.ee.entity.User;

import java.util.List;

/**
 * Created by mark on 4/24/15.
 */
public interface UserDAO {
    public int save(User u);
    public List<User> findAll();
}
