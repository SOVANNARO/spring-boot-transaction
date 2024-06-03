package org.tutorials.springboottransaction.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.tutorials.springboottransaction.entity.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Long> {

}
