package com.jason.controller;

import com.github.pagehelper.PageInfo;
import com.jason.controller.utils.ResultMsg;
import com.jason.pojo.Book;
import com.jason.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    private BookService bookService;

    @PostMapping
    public ResultMsg sava(@RequestBody Book book) {
        boolean flag = bookService.sava(book);
        return new ResultMsg(flag, flag ? "添加成功^_^" : "添加失败-_-!");
    }

    @DeleteMapping("{id}")
    public ResultMsg delete(@PathVariable int id) {
        return new ResultMsg(bookService.delete(id));
    }

    @PutMapping
    public ResultMsg update(@RequestBody Book book) {
        return new ResultMsg(bookService.update(book));
    }

    @GetMapping
    public ResultMsg getAll() {
        return new ResultMsg(true, bookService.getAll());
    }

    @GetMapping("{id}")
    public ResultMsg getById(@PathVariable int id) {
        return new ResultMsg(true, bookService.getById(id));
    }

    @GetMapping("{pageNum}/{pageSize}")
    public ResultMsg getPage(@PathVariable int pageNum, @PathVariable int pageSize,Book book) {
        PageInfo<Book> page = bookService.getPage(pageNum, pageSize,book);
        if(pageNum>page.getPages()){
            page = bookService.getPage(pageNum, pageSize,book);
        }
        return new ResultMsg(true, page);
    }
}
