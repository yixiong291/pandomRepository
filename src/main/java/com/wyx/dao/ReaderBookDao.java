package com.wyx.dao;

import com.wyx.entity.ReaderBook;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ReaderBookDao {

    void insertBook(ReaderBook readerBook);

    List<ReaderBook> queryAll();

    ReaderBook queryByISBN(String ISBN);

    /**
     * 查询当前用户的借阅书籍
     * @param name
     * @return
     */
    List<ReaderBook> queryByName(@Param("name")String name);

    /**
     * 还书
     * @param bookName
     */
    void deleteByName(@Param("bookName")String bookName);

    /**
     * 查询当前用户的是否以还过书籍
     * @param bookName
     * @return
     */
    List<ReaderBook> queryByBookNa(@Param("bookName")String bookName);
}
