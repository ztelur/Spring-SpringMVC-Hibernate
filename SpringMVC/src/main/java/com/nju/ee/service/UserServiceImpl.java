package com.nju.ee.service;

import com.nju.ee.DAO.UserDAO;
import com.nju.ee.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;
import java.util.List;

/**
 * Created by mark on 4/24/15.
 */
@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDao;

    public void saveUsers(List<User> us) {
        for (User u : us) {
            userDao.save(u);
        }
    }

    public List<User> getAllUsernames() {
        return userDao.findAll();
    }
}
