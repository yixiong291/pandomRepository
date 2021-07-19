package com.wyx.dao;

import com.wyx.entity.User;

import java.util.List;
public interface UserDao {

    List<User> queryAllUser(int page,int size);

    void insertUser(User user);

    User queryNameAndPwd(User user);

    User queryByName(String name);
}
