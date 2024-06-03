package org.tutorials.springboottransaction.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.tutorials.springboottransaction.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
