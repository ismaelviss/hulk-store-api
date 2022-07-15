package com.ismaelviss.hulkstore.persistence.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ismaelviss.hulkstore.domain.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findAll();
    Optional<List<Product>> findByCategory(String categoryId);
    Optional<Product> findById(int productId);
    Product save(Product product);
}
