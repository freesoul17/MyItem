package com.jason.dao;


import com.jason.pojo.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BookDaoTest {
    @Autowired
    BookDao bookDao;
    @Test
    public void testSelectAll(){
        System.out.println(bookDao.getAll());
    }
    @Test
    public void testSelectBookById(){
        System.out.println(bookDao.getById(1));
    }
    @Test
    public void testInsertBook(){
        for (int i = 0; i < 20; i++) {
            Book book = new Book();
            book.setType("数据库");
            book.setName("数据库设计");
            book.setNote("数据库设计实战");
            System.out.println(bookDao.save(book));
        }

    }
    @Test
    public void testUpdateBook(){
        Book book = new Book();
        book.setId(1);
        book.setType("数据库1");
        book.setName("数据库设计");

        bookDao.update(book);
    }
    @Test
    public void testdeleteBook(){
        Book book = new Book();
        book.setId(1);
        book.setType("数据库1");
        book.setName("数据库设计");

        bookDao.delete(book.getId());
    }
    @Test
    public void testQueryBooksByLike(){
        System.out.println(bookDao.queryBooksByLike(null));
    }
}
