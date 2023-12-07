package com.luckygroup.webapi.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.luckygroup.webapi.models.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {
    Optional<Order> findByOrderId(Integer orderId);

    List<Order> findByCustomerInformation(String customerInformation);

    List<Order> findByOrderStatus(String orderStatus);

    // Các phương thức tìm kiếm hoặc xóa khác có thể được thêm tùy thuộc vào yêu cầu cụ thể của bạn.
}
