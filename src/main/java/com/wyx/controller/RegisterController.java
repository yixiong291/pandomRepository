package com.wyx.controller;

import com.wyx.entity.Admin;
import com.wyx.entity.ReaderInfo;
import com.wyx.entity.User;
import com.wyx.service.AdminService;
import com.wyx.service.ReInfoService;
import com.wyx.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/register")
public class RegisterController {
    private static Logger logger = Logger.getLogger(UserController.class);

    @Autowired
    @Qualifier("UserServiceImpl")
    private UserService userService;

    @Autowired
    @Qualifier("ReInfoServiceImpl")
    private ReInfoService reInfoService;

    @RequestMapping("/registerUsers")
    public ModelAndView register(@RequestParam("name")String name, @RequestParam("sex")String sex,
                                 @RequestParam("pwd")String pwd, @RequestParam("email")String email,ModelAndView modelAndView,
                                 HttpSession session){

        Boolean byName = userService.queryByName(name);
        if(byName){
            logger.info("有相同的用户名");
            modelAndView.addObject("msg","该用户已经被注册！");
        }else{
            User user = new User(name, pwd);
            ReaderInfo readerInfo = new ReaderInfo(name, sex, email);
            reInfoService.insertInfo(readerInfo);
            logger.info("@插入用户数据");
            userService.insertUser(user);
            logger.info("您已注册成功");
            modelAndView.addObject("msg","您已经注册成功！");
        }
        modelAndView.setViewName("login");
        return modelAndView;
    }


}
