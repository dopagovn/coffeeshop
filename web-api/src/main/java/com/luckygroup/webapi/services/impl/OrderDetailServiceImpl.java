package com.luckygroup.webapi.services.impl;

import com.luckygroup.webapi.models.OrderDetail;
import com.luckygroup.webapi.repository.AccountsRepository;
import com.luckygroup.webapi.repository.OrderDetailRepository;
import com.luckygroup.webapi.services.OrderDetailService;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderDetailServiceImpl implements OrderDetailService {

  private final OrderDetailRepository orderDetailRepository;
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
  public OrderDetail getOrderDetailById(Long id) {
    try {
      OrderDetail orderDetail = orderDetailRepository
        .findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Not Found Order"));
      return modelMapper.map(orderDetail, OrderDetail.class);
    } catch (Exception e) {
      throw new ResourceNotFoundException("Not found order detail", e);
    }
  }

  @Override
  public List<OrderDetail> getAllOrder() {
    try {
      List<OrderDetail> orderDetail = orderDetailRepository.findAll();
      return orderDetail;
    } catch (Exception e) {
      throw new ResourceNotFoundException("Not found any order detail", e);
    }
  }

  @Override
  public OrderDetail deleteOrderDetail(int id) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException(
      "Unimplemented method 'deleteOrderDetail'"
    );
  }

  @Override
  public OrderDetail getOrderDetailsByOrderId(int orderId) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException(
      "Unimplemented method 'getOrderDetailsByOrderId'"
    );
  }
}
