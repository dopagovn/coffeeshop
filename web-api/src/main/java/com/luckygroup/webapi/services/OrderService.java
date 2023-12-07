package com.luckygroup.webapi.services;

import com.luckygroup.webapi.models.Order;
import com.luckygroup.webapi.repository.OrderRepository;

import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class OrderService {

    private final OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Optional<Order> findByOrderId(Integer orderId) {
        return orderRepository.findByOrderId(orderId);
    }

    public Optional<List<Order>> getAllOrders() {
        List<Order> orders = orderRepository.findAll();
        return Optional.ofNullable(orders);
    }

    public void saveOrder(Order order) {
        orderRepository.save(order);
    }

    public void deleteOrder(Integer orderId) {
        orderRepository.deleteById(orderId);
    }

    // Bổ sung thêm các phương thức cần thiết tại đây

    // Ví dụ:
    public Optional<List<Order>> getOrdersByCustomerInformation(String customerInformation) {
        List<Order> orders = orderRepository.findByCustomerInformation(customerInformation);
        return Optional.ofNullable(orders);
    }

    public Optional<List<Order>> getOrdersByOrderStatus(String orderStatus) {
        List<Order> orders = orderRepository.findByOrderStatus(orderStatus);
        return Optional.ofNullable(orders);
    }
}
