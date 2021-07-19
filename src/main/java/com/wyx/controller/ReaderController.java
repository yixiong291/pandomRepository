package com.wyx.controller;

import com.wyx.entity.ReaderInfo;
import com.wyx.service.ReInfoService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/reader")
public class ReaderController {
    private static Logger logger = Logger.getLogger(ReaderController.class);
    @Autowired
    @Qualifier("ReInfoServiceImpl")
    private ReInfoService reInfoService;

    @RequestMapping("/showByName")
    public ModelAndView showByName(ModelAndView modelAndView, @RequestParam("name")String name){
        ReaderInfo info = reInfoService.queryByName(name);
        modelAndView.addObject("reader",info);
        modelAndView.setViewName("reader");
        return modelAndView;
    }

    @RequestMapping("/update")
    public ModelAndView updateInfo(ModelAndView modelAndView, ReaderInfo readerInfo){
        reInfoService.updateInfo(readerInfo);
        logger.info(readerInfo.getReName());
        ReaderInfo info = reInfoService.queryByName(readerInfo.getReName());
        modelAndView.addObject("msg","修改成功");
        modelAndView.addObject("reader",info);
        modelAndView.setViewName("reader");
        return modelAndView;
    }

}
