package com.luckygroup.webapi.services;

import com.luckygroup.webapi.models.OrderDetail;
import com.luckygroup.webapi.repository.OrderDetailRepository;

import jakarta.transaction.Transactional;



import java.util.List;



public interface OrderDetailService {

    OrderDetail findById(Integer id);
    List<OrderDetail> findAll();

    OrderDetail deleteOrderDetail(int id);


    OrderDetail getOrderDetailsByOrderId(int orderId);

}
