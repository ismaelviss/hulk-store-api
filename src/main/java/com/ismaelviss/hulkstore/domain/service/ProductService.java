package com.ismaelviss.hulkstore.domain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ismaelviss.hulkstore.domain.model.Product;
import com.ismaelviss.hulkstore.persistence.repository.AuthRepository;
import com.ismaelviss.hulkstore.persistence.repository.ProductRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProductService {

	ProductRepository productRepository;

	public List<Product> findAll() {
		return productRepository.findAll();
	}

	public Optional<List<Product>> findByCategory(String categoryId) {
		return productRepository.findByCategory(categoryId);
	}


	public Optional<Product> findById(int productId) {
		return productRepository.findById(productId);
	}

	public Product save(Product product) {
		return productRepository.save(product);
	}

}
