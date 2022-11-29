package com.jason.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jason.dto.DishDto;
import com.jason.entity.Dish;


public interface DishService extends IService<Dish> {
    void saveWithFlavor(DishDto dishDto);

    DishDto getByIdWithFlavor(Long id);

    void updateWithFlavor(DishDto dishDto);
}
