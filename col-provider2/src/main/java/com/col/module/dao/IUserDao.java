package com.col.module.dao;

import com.col.module.bean.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * Created by liu.min on 2018/11/30.
 */
@Mapper
public interface IUserDao {

    int insert(User user);
}
