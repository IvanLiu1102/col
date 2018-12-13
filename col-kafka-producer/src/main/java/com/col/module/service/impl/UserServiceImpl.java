package com.col.module.service.impl;

import com.col.module.bean.User;
import com.col.module.dao.IUserDao;
import com.col.module.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by liu.min on 2018/11/30.
 */
@Service
@Transactional
public class UserServiceImpl implements IUserService{

    @Autowired
    private IUserDao userDao;

    @Override
    public int insert(User user) {
        return this.userDao.insert(user);
    }
}
