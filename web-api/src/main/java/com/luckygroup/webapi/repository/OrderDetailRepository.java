package com.luckygroup.webapi.repository;

import com.luckygroup.webapi.models.OrderDetail;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDetailRepository
  extends JpaRepository<OrderDetail, Long> {
  Optional<OrderDetail> findById(Long id);
  List<OrderDetail> findAll();
  Optional<OrderDetail> deleteById(int id);
}
