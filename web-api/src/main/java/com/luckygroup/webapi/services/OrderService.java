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
    
    public Optional<List<Order>> getOrdersByCustomerInformation(String customerInformation) {
        List<Order> orders = orderRepository.findByCustomerInformation(customerInformation);
        return Optional.ofNullable(orders);
    }

    public Optional<List<Order>> getOrdersByOrderStatus(String orderStatus) {
        List<Order> orders = orderRepository.findByOrderStatus(orderStatus);
        return Optional.ofNullable(orders);
    }

    public void placeOrder(Order order) {
        // Thực hiện các kiểm tra cần thiết trước khi đặt đơn hàng

        // Set trạng thái đơn hàng là "Đã đặt hàng"
        order.setOrderStatus("Đã đặt hàng");

        // Lưu đơn hàng vào cơ sở dữ liệu
        orderRepository.save(order);
    }

    public void completeOrder(Integer orderId) {
        Optional<Order> optionalOrder = orderRepository.findByOrderId(orderId);
        if (optionalOrder.isPresent()) {
            Order order = optionalOrder.get();

            // Kiểm tra xem đơn hàng có trạng thái "Đã đặt hàng" hay không trước khi hoàn thành
            if ("Đã đặt hàng".equals(order.getOrderStatus())) {
                // Set trạng thái đơn hàng thành "Hoàn thành"
                order.setOrderStatus("Hoàn thành");

                // Lưu đơn hàng vào cơ sở dữ liệu
                orderRepository.save(order);
            } else {
                // Xử lý khi đơn hàng không ở trạng thái đúng để hoàn thành
                // (ví dụ: ném một exception hoặc trả về một thông báo lỗi)
            }
        }
    }
}
