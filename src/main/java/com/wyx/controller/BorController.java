package com.wyx.controller;

import com.wyx.entity.BookList;
import com.wyx.entity.ReaderBook;
import com.wyx.service.BookService;
import com.wyx.service.ReBookService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/borrow")
public class BorController {
    @Autowired
    @Qualifier("ReBookServiceImpl")
    private ReBookService reBookService;

    @Autowired
    @Qualifier("BookServiceImpl")
    public BookService bookService;

    private static Logger logger = Logger.getLogger(BorController.class);
    @RequestMapping("/borrowBook")
    public ModelAndView borrowBook(ModelAndView modelAndView, @RequestParam("bookName") String bookName,@RequestParam("ISBN") String ISBN,
                                    @RequestParam("name") String name){
        if(name==null){
            modelAndView.addObject("succeed","借阅失败，时间过长请重新登录");
        }else{
            ReaderBook readerBook = new ReaderBook(name, bookName, ISBN);
            Boolean aBoolean = reBookService.queryByISBN(ISBN);
            if(aBoolean){
                modelAndView.addObject("succeed","您已借阅过该书籍");
            }else{
                reBookService.insertBook(readerBook);
                modelAndView.addObject("succeed","借阅成功");
            }
        }


        BookList bookList = bookService.queryBookById(ISBN);
        List<BookList> list = new ArrayList<>();
        list.add(bookList);
        modelAndView.addObject("book",list);

        modelAndView.setViewName("readerLibrary");
        logger.info("借阅成功");
        return modelAndView;
    }

    @RequestMapping("/show")
    public ModelAndView show(ModelAndView modelAndView,@RequestParam("name")String name){
        List<ReaderBook> readerBooks = reBookService.queryByName(name);
        if(readerBooks.size() ==0){
            modelAndView.addObject("mes","您还未借读任何书籍");
        }else{
            modelAndView.addObject("book",readerBooks);
        }
        modelAndView.setViewName("readerBook");
        return modelAndView;
    }
    @RequestMapping("/returnBook")
    public ModelAndView returnBook(ModelAndView modelAndView,@RequestParam("bookName") String bookName,@RequestParam("name")String name){
        List<ReaderBook> list = reBookService.queryByBookNa(bookName);
        if(list.size()==0){
            logger.info("您已还过该书籍");
            modelAndView.addObject("msg","您已还过该书籍");
        }else {
            reBookService.deleteByName(bookName);
            logger.info("还书成功");
            modelAndView.addObject("msg","还书成功");
        }
        List<ReaderBook> book1 = reBookService.queryByName(name);
        modelAndView.addObject("book",book1);
        modelAndView.setViewName("readerBook");
        return modelAndView;
    }
}
