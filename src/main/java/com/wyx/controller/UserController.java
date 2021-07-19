package com.wyx.controller;

import com.github.pagehelper.PageInfo;
import com.wyx.entity.Admin;
import com.wyx.entity.User;
import com.wyx.service.AdminService;
import com.wyx.service.UserService;
import com.wyx.service.UserServiceImpl;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {
    @Autowired
    @Qualifier("UserServiceImpl")
    private UserService userService;

    @Autowired
    @Qualifier("AdminServiceImpl")
    private AdminService adminService;

    private static Logger logger = Logger.getLogger(UserController.class);

    @RequestMapping("/allUser")
    public ModelAndView list(ModelAndView modelAndView,@RequestParam(defaultValue = "1")int page,@RequestParam(defaultValue = "5")int size){
        List<User> users = userService.queryAllUser(page,size);
        PageInfo pageInfo=new PageInfo(users);
        modelAndView.addObject("pageInfo",pageInfo);
        modelAndView.addObject("list",users);
        modelAndView.setViewName("users");
        return modelAndView;
    }

    @RequestMapping("/loginUsers")
    public ModelAndView checkUser(ModelAndView modelAndView, @RequestParam("name") String name,
                                  @RequestParam("pwd")String pwd, @RequestParam("visitor") String visitor,
                                  HttpSession session) throws IOException {
        if(visitor.equals("reader")){
            logger.debug("读者操作123");
            User user = new User(name, pwd);
            if(userService.queryNameAndPwd(user)){
                logger.info("读者登陆成功");
                session.setAttribute("username",name);
                modelAndView.setViewName("redirect:/readerLibrary.jsp");
            }else {
                logger.info("读者登录失败");
                modelAndView.addObject("msg","用户名或密码错误");
                modelAndView.setViewName("login");
            }
        }else if (visitor.equals("admin")){
            Admin admin = new Admin(name,pwd);
            if(adminService.queryNameAndPwd(admin)){
                logger.info("登陆成功admin");
                session.setAttribute("adminName",name);
                modelAndView.setViewName("redirect:/adminLibrary.jsp");
            }else{
                logger.info("登陆失败admin");
                modelAndView.addObject("msg","用户名或密码错误");
                modelAndView.setViewName("login");
            }
        }

        return modelAndView;
    }

}
