package com.luckygroup.webapi.services;

import com.luckygroup.webapi.models.OrderDetail;
import java.util.List;

public interface OrderDetailService {
  List<OrderDetail> getAllOrderDetails();
  List<OrderDetail> findOrderDetailsByOrderId(int orderId);
  OrderDetail findById(int id);
  OrderDetail saveOrderDetail(OrderDetail orderDetail);
  void deleteOrderDetail(Integer id);
}
