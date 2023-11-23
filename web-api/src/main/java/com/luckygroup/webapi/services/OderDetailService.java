package com.luckygroup.webapi.services;

import com.luckygroup.webapi.models.OderDetail;
import com.luckygroup.webapi.repository.OderDetailRepository;

import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class OderDetailService {

    private final OderDetailRepository oderDetailRepository;

    @Autowired
    public OderDetailService(OderDetailRepository orderDetailRepository) {
        this.oderDetailRepository = orderDetailRepository;
    }

    public Optional<OderDetail> findById(Integer id) {
        return oderDetailRepository.findById(id);
    }

    public Optional<List<OderDetail>> getAllOrderDetails() {
        List<OderDetail> orderDetails = oderDetailRepository.findAll();
        return Optional.ofNullable(orderDetails);
    }

    public void saveOrderDetail(OderDetail orderDetail) {
        oderDetailRepository.save(orderDetail);
    }

    public void deleteOrderDetail(Integer id) {
        oderDetailRepository.deleteById(id);
    }

    // Bổ sung thêm các phương thức cần thiết tại đây

    // Ví dụ:
    public Optional<OderDetail> getOrderDetailsByOrderId(Integer id) {
        return oderDetailRepository.findById(id);
    }
}
