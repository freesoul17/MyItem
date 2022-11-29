package com.jason.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jason.entity.ShoppingCart;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ShoppingCartMapper extends BaseMapper<ShoppingCart> {
}
