package com.wyx.service;

import com.wyx.entity.User;

import java.util.List;

public interface UserService {
    List<User> queryAllUser(int page,int size);

    void insertUser(User user);

    Boolean queryNameAndPwd(User user);

    Boolean queryByName(String name);
}
