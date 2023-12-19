package com.luckygroup.webapi.services.impl;

import com.luckygroup.webapi.models.Order;
import com.luckygroup.webapi.models.Payment;
import com.luckygroup.webapi.repository.OrderRepository;
import com.luckygroup.webapi.repository.PaymentRepository;
import com.luckygroup.webapi.services.PaymentService;

import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository paymentRepository;
    private final OrderRepository orderRepository;

    @Autowired
    public PaymentServiceImpl(PaymentRepository paymentRepository, OrderRepository orderRepository) {
        this.paymentRepository = paymentRepository;
        this.orderRepository = orderRepository;
    }

    @Override
    public Optional<Payment> findById(Integer id) {
        return paymentRepository.findById(id);
    }

    @Override
    public Optional<List<Payment>> getAllPayments() {
        List<Payment> payments = paymentRepository.findAll();
        return Optional.ofNullable(payments);
    }

    @Override
    public void savePayment(Payment payment) {
        paymentRepository.save(payment);
    }

    @Override
    public void deletePayment(Integer id) {
        paymentRepository.deleteById(id);
    }

    @Override
    public Optional<Payment> getPaymentByOrderId(Integer orderId) {
        return paymentRepository.findByOrderId(orderId);
    }

    @Override
    public void makePayment(Integer orderId) {
        Optional<Order> optionalOrder = orderRepository.findByOrderId(orderId);
        if (optionalOrder.isPresent()) {
            Order order = optionalOrder.get();

            // Kiểm tra xem lớp Order có phương thức getTotalAmount() không
            if ("Hoàn thành".equals(order.getOrderStatus())) {
                Payment payment = new Payment();
                payment.setOrderId(orderId);
                payment.setTotalPaymentAmount(order.getTotalAmount());
                payment.setPaymentStatus("Chưa thanh toán");
                paymentRepository.save(payment);
            } else {
                System.out.println("Không thể thanh toán đơn hàng với trạng thái hiện tại.");
            }
        } else {
            System.out.println("Không tìm thấy đơn hàng với ID: " + orderId);
        }
    }
}
