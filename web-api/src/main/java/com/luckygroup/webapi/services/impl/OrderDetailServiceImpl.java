package com.luckygroup.webapi.services.impl;

import com.luckygroup.webapi.models.OrderDetail;
import com.luckygroup.webapi.repository.OrderDetailRepository;
import com.luckygroup.webapi.services.OrderDetailService;
import java.util.List;
import java.util.Optional;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderDetailServiceImpl implements OrderDetailService {

  private final OrderDetailRepository orderDetailRepository;

  @Autowired
  public OrderDetailServiceImpl(OrderDetailRepository orderDetailRepository) {
    this.orderDetailRepository = orderDetailRepository;
  }

  @Override
  public List<OrderDetail> getAllOrderDetails() {
    try {
      List<OrderDetail> orderDetails = orderDetailRepository.findAll();
      return orderDetails;
    } catch (Exception e) {
      throw new ResourceNotFoundException("Not found order details", e);
    }
  }

  @Override
  public List<OrderDetail> findOrderDetailsByOrderId(int orderId) {
    try {
      List<OrderDetail> orderDetailsByOrderId = orderDetailRepository.findByOrderId(
        orderId
      );
      return orderDetailsByOrderId;
    } catch (Exception e) {
      throw new ResourceNotFoundException("Not found order details", e);
    }
  }

  @Override
  public OrderDetail findById(int id) {
    try {
      Optional<OrderDetail> orderDetail = orderDetailRepository.findById(id);
      return orderDetail.orElse(null);
    } catch (Exception e) {
      throw new ResourceNotFoundException("Not found order detail", e);
    }
  }

  @Override
  public OrderDetail saveOrderDetail(OrderDetail orderDetail) {
    try {
      return orderDetailRepository.save(orderDetail);
    } catch (Exception e) {
      throw new ResourceNotFoundException("Failed to save order detail", e);
    }
  }

  @Override
  public void deleteOrderDetail(Integer id) {
    try {
      orderDetailRepository.deleteById(id);
    } catch (Exception e) {
      throw new ResourceNotFoundException("Failed to delete order detail", e);
    }
  }
  // Bổ sung các phương thức khác tại đây nếu cần

}
