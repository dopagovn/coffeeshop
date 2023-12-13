package com.luckygroup.webapi.services.impl;

import java.util.List;

import org.apache.velocity.exception.ResourceNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luckygroup.webapi.models.OrderDetail;
import com.luckygroup.webapi.repository.AccountsRepository;
import com.luckygroup.webapi.repository.OrderDetailRepository;
import com.luckygroup.webapi.services.OrderDetailService;

@Service
public class OrderDetailServiceImpl implements OrderDetailService {

     private  final OrderDetailRepository orderDetailRepository;
     private final ModelMapper modelMapper;

     @Autowired
    public OrderDetailServiceImpl(
    OrderDetailRepository orderDetailRepository,
    ModelMapper modelMapper
  ) {
    this.orderDetailRepository = orderDetailRepository;
    this.modelMapper = modelMapper;
  }

    @Override
    public OrderDetail findById(Integer id) {
        try {
            OrderDetail orderDetail = orderDetailRepository.findById(id);
            return orderDetail;
        } catch (Exception e) {
            throw new ResourceNotFoundException("Not found order detail", e);
        }
    }

    @Override
    public List<OrderDetail> findAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @Override
    public OrderDetail deleteOrderDetail(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteOrderDetail'");
    }

    @Override
    public OrderDetail getOrderDetailsByOrderId(int orderId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getOrderDetailsByOrderId'");
    }
    
}
