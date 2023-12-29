package com.luckygroup.webapi.repository;

import com.luckygroup.webapi.models.OrderDetail;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface OrderDetailRepository extends JpaRepository<OrderDetail, Integer> {
    Optional<OrderDetail> findById(int id);
    List<OrderDetail> findByOrderId(Integer orderId);
    Optional<OrderDetail> deleteById(int id);

}
