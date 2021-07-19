package com.wyx.service;

import com.wyx.entity.Admin;

import java.util.List;

public interface AdminService {
    //插入管理员用户名和密码
    void insertAdmin(Admin admin);

    //查询
    List<Admin> queryAllAdmin();

    //验证用户名和密码是否正确
    Boolean  queryNameAndPwd(Admin admin);

    //查询管理员用户名是否有重名
    Boolean queryAdminByName( String name);
}
