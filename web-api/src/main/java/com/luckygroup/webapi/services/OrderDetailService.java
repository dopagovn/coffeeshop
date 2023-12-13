package com.luckygroup.webapi.services;

import com.luckygroup.webapi.models.OrderDetail;
import java.util.List;

public interface OrderDetailService {
  OrderDetail getOrderDetailById(Long id);
  List<OrderDetail> getAllOrder();
  OrderDetail deleteOrderDetail(int id);
  OrderDetail getOrderDetailsByOrderId(int orderId);
}
