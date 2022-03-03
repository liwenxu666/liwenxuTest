package com.lwx.mapper;

import com.lwx.pojo.Order;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderMapper {
    Order getOrderById(int id);
}
