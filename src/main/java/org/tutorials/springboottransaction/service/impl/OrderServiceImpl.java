package org.tutorials.springboottransaction.service.impl;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import org.tutorials.springboottransaction.dto.OrderRequest;
import org.tutorials.springboottransaction.dto.OrderResponse;
import org.tutorials.springboottransaction.entity.Order;
import org.tutorials.springboottransaction.entity.Payment;
import org.tutorials.springboottransaction.exception.PaymentException;
import org.tutorials.springboottransaction.repository.OrderRepository;
import org.tutorials.springboottransaction.repository.PaymentRepository;
import org.tutorials.springboottransaction.service.OrderService;

import java.util.UUID;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

    private OrderRepository orderRepository;
    private PaymentRepository paymentRepository;

    // Generate OrderServiceImpl constructor Use IDE to generate constructor.
    public OrderServiceImpl(OrderRepository orderRepository, PaymentRepository paymentRepository) {
        this.orderRepository = orderRepository;
        this.paymentRepository = paymentRepository;
    }

    @Override
    public OrderResponse placeOrder(OrderRequest orderRequest) {
        Order order = orderRequest.getOrder();
        order.setStatus("INPROGRESS");
        order.setOrderTrackingNumber(UUID.randomUUID().toString());
        orderRepository.save(order);

        Payment payment = orderRequest.getPayment();
        if (!payment.getType().equals("DEBIT")) {
            throw new PaymentException("Payment card type not supported");
        }

        payment.setOrderId(order.getId());
        paymentRepository.save(payment);

        OrderResponse orderResponse = new OrderResponse();
        orderResponse.setOrderTrackingNumber(order.getOrderTrackingNumber());
        orderResponse.setStatus(order.getStatus());
        orderResponse.setStatus("SUCCESS");

        return orderResponse;
    }
}
