package com.wyx.controller;

import com.wyx.entity.BookList;
import com.wyx.service.BookService;
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
@RequestMapping("/book")
public class BookController {
    @Autowired
    @Qualifier("BookServiceImpl")
    public BookService bookService;

    private static Logger logger = Logger.getLogger(BookController.class);

    @RequestMapping("/showBook")
    public ModelAndView showBook(ModelAndView modelAndView, @RequestParam("ISBN") String ISBN){
        BookList bookList = bookService.queryBookById(ISBN);
        List<BookList> list = new ArrayList<>();
        list.add(bookList);
        logger.info("查询到相应书籍");
        if(bookList==null){
            list = bookService.queryAllBook();
            modelAndView.addObject("err","未查询到书籍");
        }
        modelAndView.addObject("book",list);
        modelAndView.setViewName("readerLibrary");
        return modelAndView;
    }

    @RequestMapping("/allBook")
    public ModelAndView allBook(ModelAndView modelAndView){
        List<BookList> bookLists = bookService.queryAllBook();
        modelAndView.addObject("book",bookLists);
        modelAndView.setViewName("readerLibrary");
        return modelAndView;
    }

    @RequestMapping("/showByName")
    public ModelAndView showBookByName(ModelAndView modelAndView,@RequestParam("bookName")String bookName){
        List<BookList> list = bookService.queryByName(bookName);
        if(list.size () ==0){
            list = bookService.queryAllBook();
            modelAndView.addObject("err","未查询到书籍");
        }
        modelAndView.addObject("book",list);
        modelAndView.setViewName("searchByNa");
        return modelAndView;
    }
    @RequestMapping("/showByAuthor")
    public ModelAndView showBookByAuthor(ModelAndView modelAndView,@RequestParam("author")String author){
        List<BookList> list = bookService.queryByAuthor(author);
        if(list.size () ==0){
            list = bookService.queryAllBook();
            modelAndView.addObject("err","未查询到书籍");
        }
        modelAndView.addObject("book",list);
        modelAndView.setViewName("serByAuthor");
        return modelAndView;
    }
    @RequestMapping("/addBook")
    public ModelAndView addBook(ModelAndView modelAndView,@RequestParam("bookName")String bookName,@RequestParam("author")String author,
                                @RequestParam("ISBN")String ISBN,@RequestParam("summary")String summary,@RequestParam("language")String language,
                                @RequestParam("a")String status,@RequestParam("bookNum")int bookNum){
//        bookService.insertBook(book);
        BookList book = new BookList(bookName, author, ISBN, summary, language, status, bookNum);
        logger.info(book);
        bookService.insertBook(book);
        modelAndView.addObject("msg","添加成功");
        modelAndView.setViewName("adminLibrary");
        return modelAndView;
    }
}
