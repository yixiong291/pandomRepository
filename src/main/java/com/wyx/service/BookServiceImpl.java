package com.wyx.service;

import com.wyx.dao.BookListDao;
import com.wyx.entity.BookList;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service("BookServiceImpl")
public class BookServiceImpl implements BookService{

    @Resource
    private BookListDao bookListDao;
    @Override
    public List<BookList> queryAllBook() {
        return bookListDao.queryAllBook();
    }

    @Override
    public void insertBook(BookList book) {
        bookListDao.insertBook(book);
    }

    @Override
    public BookList queryBookById(String ISBN) {
        return bookListDao.queryBookById(ISBN);
    }

    @Override
    public void changeByStatus(String ISBN, String status) {
        bookListDao.changeByStatus(ISBN,status);
    }

    @Override
    public List<BookList> queryByName(String bookName) {
        return bookListDao.queryByName(bookName);

    }

    @Override
    public List<BookList> queryByAuthor(String author) {
        return bookListDao.queryByAuthor(author);
    }
}
