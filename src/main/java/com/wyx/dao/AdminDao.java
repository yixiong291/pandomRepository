package com.wyx.dao;

import com.wyx.entity.Admin;

import java.util.List;

public interface AdminDao {
    //插入管理员用户名和密码
    int insertAdmin(Admin admin);

    //查询
    List<Admin> queryAllAdmin();

    //验证用户名和密码是否正确
    Admin  queryNameAndPwd(Admin admin);

    //查询管理员用户名是否有重名
    Admin queryAdminByName( String name);
}
