package com.ismaelviss.hulkstore.persistence.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ismaelviss.hulkstore.domain.model.Order;

public interface StoreRepository extends JpaRepository<Order, Long> {
    List<Order> findAll();
    Order save(Order store);
    Optional<Order> findById(int orderId);
}
