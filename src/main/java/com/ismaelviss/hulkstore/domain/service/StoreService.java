package com.ismaelviss.hulkstore.domain.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ismaelviss.hulkstore.domain.model.Order;
import com.ismaelviss.hulkstore.domain.model.Orders;
import com.ismaelviss.hulkstore.domain.model.Product;
import com.ismaelviss.hulkstore.persistence.repository.ProductRepository;
import com.ismaelviss.hulkstore.persistence.repository.StoreRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class StoreService {

	StoreRepository storeRepository;
	
	ProductRepository productRepository;
	
    public Orders save(Orders orders) {
    	int id = 0;
    	for(Order order: orders) {
    		System.out.println("order->ProductID->"+order.getProductId());
    		Optional<Product> optProduct = productRepository.findById(order.getProductId());
    		Product product = optProduct.get();
    		if(product.getQuantity()>=order.getQuantity()) {
    			storeRepository.save(order);
    			product.setQuantity(product.getQuantity()-order.getQuantity());
    			productRepository.save(product);
    		}
    	}
    	return orders;
    }
	public Optional<Order> findById(int orderId) {
		return storeRepository.findById(orderId);
	}

}

