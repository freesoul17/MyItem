package com.jason.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jason.dao.BookDao;
import com.jason.pojo.Book;
import com.jason.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookDao bookDao;
    @Override
    public boolean sava(Book book) {
        return bookDao.save(book)>0;
    }

    @Override
    public boolean update(Book book) {
        return bookDao.update(book)>0;
    }

    @Override
    public boolean delete(int id) {
        return bookDao.delete(id)>0;
    }

    @Override
    public Book getById(int id) {
        return bookDao.getById(id);
    }

    @Override
    public List<Book> getAll() {
        return bookDao.getAll();
    }

    @Override
    public PageInfo<Book> getPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Book> all = bookDao.getAll();
        return new PageInfo<>(all);
    }

    @Override
    public PageInfo<Book> getPage(int pageNum, int pageSize, Book book) {
        PageHelper.startPage(pageNum,pageSize);
        List<Book> books = bookDao.queryBooksByLike(book);
        return new PageInfo<>(books);
    }
}
