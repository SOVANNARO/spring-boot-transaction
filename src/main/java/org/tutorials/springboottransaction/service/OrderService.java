package org.tutorials.springboottransaction.service;

import org.tutorials.springboottransaction.dto.OrderRequest;
import org.tutorials.springboottransaction.dto.OrderResponse;

public interface OrderService {
    OrderResponse placeOrder(OrderRequest orderRequest);
}
