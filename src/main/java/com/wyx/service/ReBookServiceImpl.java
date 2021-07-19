package com.wyx.service;

import com.wyx.dao.ReaderBookDao;
import com.wyx.entity.ReaderBook;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("ReBookServiceImpl")
public class ReBookServiceImpl implements ReBookService{
    @Resource
    private ReaderBookDao readerBookDao;

    @Override
    public void insertBook(ReaderBook readerBook) {
        readerBookDao.insertBook(readerBook);
    }

    @Override
    public List<ReaderBook> queryAll() {

        return readerBookDao.queryAll();
    }

    @Override
    public Boolean queryByISBN(String ISBN) {
        ReaderBook readerBook = readerBookDao.queryByISBN(ISBN);
        if (readerBook!=null){
            return true;
        }else{
            return false;
        }
    }

    /**
     * 查询当前用户的借阅书籍
     * @param name
     * @return
     */
    @Override
    public List<ReaderBook> queryByName(String name) {
        return readerBookDao.queryByName(name);
    }

    /**
     * 还书
     * @param bookName
     */
    @Override
    public void deleteByName(String bookName) {
        readerBookDao.deleteByName(bookName);
    }

    /**
     * 查询当前用户的是否以还过书籍
     * @param bookName
     * @return
     */
    @Override
    public List<ReaderBook> queryByBookNa(String bookName) {
        return readerBookDao.queryByBookNa(bookName);
    }


}
