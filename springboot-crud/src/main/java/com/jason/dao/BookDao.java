package com.jason.dao;

import com.jason.pojo.Book;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface BookDao {

    //查询所有书籍
    @Select("select * from t_book")
    List<Book> getAll();


    //通过id查询书籍
    @Select("select * from t_book where id = #{id}")
    Book getById(Integer id);

    //插入一条数据
    @Insert("insert into t_book values(#{id},#{type},#{name},#{note})")
    int save(Book book);

    //更新
    @Update("<script>" +
                "update t_book" +
                "<set>"+
                    "<if test='type != null'>type = #{type},</if>"+
                    "<if test='name != null'>name = #{name},</if>"+
                    "<if test='note != null'>note = #{note}</if>"+
                "</set>"+
                "where id = #{id}"+
            "</script>")
    int update(Book Book);

    //删除
    @Delete("delete from t_Book where id = #{id}")
    int delete(Integer id);

    //模糊查询
    @Select("<script>" +
            "select * from t_book where 1=1"+
            "<if test='type!=null'>and type like CONCAT('%',#{type},'%')</if>"+
            "<if test='name!=null'>and name like CONCAT('%',#{name},'%')</if>"+
            "<if test='note!=null'>and note like CONCAT('%',#{note},'%')</if>"+
            "</script>")
    List<Book> queryBooksByLike( Book book);

}
