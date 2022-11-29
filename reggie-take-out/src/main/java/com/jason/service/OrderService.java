package com.jason.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jason.entity.Orders;

public interface OrderService extends IService<Orders> {

    void submit(Orders orders);
}
