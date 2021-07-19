package com.wyx.service;

import com.wyx.dao.AdminDao;
import com.wyx.entity.Admin;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service("AdminServiceImpl")
public class AdminServiceImpl implements AdminService{
    @Resource
    private AdminDao adminDao;

    private static Logger logger = Logger.getLogger(AdminServiceImpl.class);
    @Override
    public void insertAdmin(Admin admin) {
        logger.info("@进入到插入用户数据");
        adminDao.insertAdmin(admin);
    }

    @Override
    public List<Admin> queryAllAdmin() {
        return adminDao.queryAllAdmin();
    }

    @Override
    public Boolean queryNameAndPwd(Admin admin) {
        logger.info("@验证用户名或密码");
        Admin nameAndPwd = adminDao.queryNameAndPwd(admin);
        if(nameAndPwd!=null){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public Boolean queryAdminByName(String name) {
        logger.info("@验证是否有相同用户名");
        Admin admin = adminDao.queryAdminByName(name);
        if(admin!=null){
            return true;
        }else{
            return false;
        }
    }
}
