package com.luckygroup.webapi.services;
import com.luckygroup.webapi.models.Order;
import java.util.List;
public interface OrderService {
    Order findOrderById(Long id);
    Order createOrder(Order order);
    List<Order> getAllOrders();

    void saveOrder(Order order);

    void updateOrder(Order order);

    void deleteOrder(Long id);

    // Thêm phương thức để đặt hàng
    void placeOrder(Long accountId, Long orderAmount) throws IllegalArgumentException;
}
