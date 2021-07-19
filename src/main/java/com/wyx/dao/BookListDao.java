package com.wyx.dao;

import com.wyx.entity.BookList;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BookListDao {
    List<BookList> queryAllBook();

    void insertBook(BookList book);

    BookList queryBookById(String ISBN);

    void changeByStatus(@Param("ISBN")String ISBN, @Param("status")String status);

    List<BookList> queryByName(@Param("bookName")String bookName);

    List<BookList> queryByAuthor(@Param("author")String author);
}
