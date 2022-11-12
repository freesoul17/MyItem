package com.jason.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jason.dto.SetmealDto;
import com.jason.pojo.Setmeal;

import java.util.List;

public interface SetmealService extends IService<Setmeal> {
    void saveWithDish(SetmealDto setmealDto);

    void removeWithDish(List<Long> ids);
}
