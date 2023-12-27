package com.luckygroup.webapi.services;
import com.luckygroup.webapi.models.Order;
import com.luckygroup.webapi.models.OrderRequest;
import com.luckygroup.webapi.repository.OrderRepository;

import java.util.List;
public interface OrderService {
    Order findOrderById(Long id);
    Order createOrder(Order order);
    List<Order> getAllOrders();

    void saveOrder(Order order);

    void updateOrder(OrderRequest orderRequest, Long id);

    void deleteOrder(Long id);

    void placeOrder(Long accountId, Long orderAmount) throws IllegalArgumentException;
}
