package org.tutorials.springboottransaction.dto;

import lombok.Getter;
import lombok.Setter;
import org.tutorials.springboottransaction.entity.Order;
import org.tutorials.springboottransaction.entity.Payment;

@Getter
@Setter
public class OrderRequest {
    private Order order;
    private Payment payment;
}
