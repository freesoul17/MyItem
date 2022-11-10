package com.jason.service;

import com.jason.pojo.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BookServiceTest {
    @Autowired
    BookService bookService;
    @Test
    public void testGetById(){
        System.out.println(bookService.getById(4));
    }
    @Test
    public void testFindAllByPage(){
        System.out.println(bookService.getPage(1, 3));
    }
    @Test
    public void testGetAll(){
        System.out.println(bookService.getAll());
    }
    @Test
    public void testInsertBook(){

            Book book = new Book();
            book.setType("数据库");
            book.setName("数据库设计");
            book.setNote("数据库设计实战");
            System.out.println(bookService.sava(book));
    }
    @Test
    public void testUpdateBook(){
        Book book = new Book();
        book.setId(1);
        book.setType("java");
        book.setName("java开发");
        book.setNote("java是最美的语言");
        System.out.println(bookService.update(book));
    }
    @Test
    public void testdeleteBook(){
        Book book = new Book();
        book.setId(4);
        bookService.delete(book.getId());
    }
    @Test
    public void testQueryBooksByLike(){
//        System.out.println(bookService.queryBooksByLike("发"));
    }
}
