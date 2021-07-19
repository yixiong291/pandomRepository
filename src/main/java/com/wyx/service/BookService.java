package com.wyx.service;

import com.wyx.entity.BookList;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BookService {
    List<BookList> queryAllBook();

    void insertBook(BookList book);

    BookList queryBookById(String ISBN);

    void changeByStatus(String ISBN,String status);

    List<BookList> queryByName(@Param("bookName")String bookName);

    List<BookList> queryByAuthor(@Param("bookName")String author);
}
