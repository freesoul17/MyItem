package com.jason.service;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jason.pojo.Book;

import java.util.List;


public interface BookService {
    boolean sava(Book book);

    boolean update(Book book);

    boolean delete(int id);

    Book getById(int id);

    List<Book> getAll();

    /**
     * 实现分页
     */
    public PageInfo<Book> getPage(int pageNum, int pageSize);

    PageInfo<Book> getPage(int pageNum, int pageSize, Book book);
}
