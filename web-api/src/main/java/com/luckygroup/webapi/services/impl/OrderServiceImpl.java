package com.luckygroup.webapi.services.impl;

import org.apache.velocity.exception.ResourceNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.luckygroup.webapi.models.Order;
import com.luckygroup.webapi.models.OrderRequest;
import com.luckygroup.webapi.repository.OrderRepository;
import com.luckygroup.webapi.services.OrderService;

import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final ModelMapper modelMapper;
    
    public OrderServiceImpl(OrderRepository orderRepository, ModelMapper modelMapper) {
        this.orderRepository = orderRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public Order findOrderById(Long id) {
        return orderRepository.findById(id)
                .map(order -> modelMapper.map(order, Order.class))
                .orElseThrow(() -> new ResourceNotFoundException("Không tìm thấy đơn đặt hàng"));
    }

    @Override
    public Order createOrder(Order order) {
        try {
            order = orderRepository.save(order);
            return order;
        } catch (Exception e) {
            throw new ResourceNotFoundException("Không thể tạo đơn hàng", e);
        }
    }

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll().stream()
                .map(order -> modelMapper.map(order, Order.class))
                .collect(Collectors.toList());
    }

    @Override
    public void saveOrder(Order order) {
        orderRepository.save(order);
    }

    @Override
    public void updateOrder(OrderRequest orderRequest, Long id) {
        Long orderId = id;
        if (orderId == null || !orderRepository.existsById(orderId)) {
            throw new ResourceNotFoundException("Order with ID " + orderId + " does not exist. Unable to update.");
        }
        Order order = orderRepository.findById(id).get();
        order.setStatus(orderRequest.getStatus());
        order.setOrderAmount(orderRequest.getOrderAmount());
        orderRepository.save(order);
    }
    @Override
    public void deleteOrder(Long id) {
        if (!orderRepository.existsById(id)) {
            throw new ResourceNotFoundException("Order with ID " + id + " does not exist. Unable to delete.");
        }

        orderRepository.deleteById(id);
    }

    // Thêm phương thức để đặt hàng (hoặc cập nhật đặt hàng)
    @Override
    public void placeOrder(Long accountId, Long orderAmount) {
        validateOrderInput(accountId, orderAmount);

        Order existingOrder = orderRepository.findByAccountId(accountId);
        if (existingOrder != null) {
            updateExistingOrder(existingOrder, orderAmount);
        } else {
            createNewOrder(accountId, orderAmount);
        }
    }

    private void validateOrderInput(Long accountId, Long orderAmount) {
        if (accountId == null || orderAmount == null || orderAmount <= 0) {
            throw new IllegalArgumentException("Dữ liệu đầu vào không hợp lệ để đặt hàng");
        }
    }

    private void updateExistingOrder(Order existingOrder, Long orderAmount) {
        existingOrder.setOrderAmount(orderAmount);
        existingOrder.setOrderDate(new Date(System.currentTimeMillis()));
        existingOrder.setStatus(1L);
        orderRepository.save(existingOrder);
    }

    private void createNewOrder(Long accountId, Long orderAmount) {
        Order newOrder = new Order();
        newOrder.setAccountId(accountId);
        newOrder.setOrderAmount(orderAmount);
        newOrder.setOrderDate(new Date(System.currentTimeMillis()));
        newOrder.setStatus(1L);
        orderRepository.save(newOrder);
    }

}
