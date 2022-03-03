package com.lwx.service.impl;

import com.lwx.mapper.OrderMapper;
import com.lwx.pojo.Order;
import com.lwx.service.OrderService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderMapper orderMapper;

    @Override
    public Order getOrderById(int id) {
        return orderMapper.getOrderById(id);
    }


}
