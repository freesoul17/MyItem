package com.jason.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jason.pojo.Category;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CategoryDao extends BaseMapper<Category> {
}
