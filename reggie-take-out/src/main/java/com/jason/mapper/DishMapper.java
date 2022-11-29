package com.jason.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jason.entity.Dish;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DishMapper extends BaseMapper<Dish> {
}
