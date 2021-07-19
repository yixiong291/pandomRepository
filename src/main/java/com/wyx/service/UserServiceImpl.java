package com.wyx.service;

import com.wyx.dao.UserDao;
import com.wyx.entity.User;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service("UserServiceImpl")
public class UserServiceImpl implements UserService {


    private static Logger logger = Logger.getLogger(UserServiceImpl.class);

    @Resource
    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public List<User> queryAllUser(int page,int size) {
        return userDao.queryAllUser(page,size);
    }

    @Override
    public void insertUser(User user) {
        logger.debug("@进入到插入用户数据");
        userDao.insertUser(user);
        logger.info("@用户数据插入成功");
    }

    @Override
    public Boolean queryNameAndPwd(User user) {
        User nameAndPwd = userDao.queryNameAndPwd(user);
        if(nameAndPwd!=null){
            logger.debug("@查询到该用户");
            return true;
        }else
            logger.debug("@未查询到该用户");
            return false;
    }

    @Override
    public Boolean queryByName(String name) {
        User user = userDao.queryByName(name);
        if(user!=null) {
            logger.debug("@查询到该用户");
            return true;
        }else
            logger.debug("@未查询到该用户");
            return false;
    }
}
