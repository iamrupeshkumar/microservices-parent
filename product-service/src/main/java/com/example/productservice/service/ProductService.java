package com.example.productservice.service;

import java.util.List;
import java.util.concurrent.ExecutionException;

import org.springframework.stereotype.Service;

import com.example.error.ErrorCode;
import com.example.exception.BusinessException;
import com.example.exception.ResourceNotFoundException;
import com.example.productservice.entity.Product;
import com.example.productservice.repository.ProductRepository;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductService {
	
	private final ProductRepository productRepository;

	//@CircuitBreaker(name = "productService", fallbackMethod = "createProductFallback")
	public Product createProduct(Product product) {
		return productRepository.save(product);
	}
	
	public Product createProductFallback(Product product, Throwable ex) {

        Throwable cause = (ex instanceof ExecutionException && ex.getCause() != null)
                ? ex.getCause()
                : ex;

        if (cause instanceof BusinessException) {
            throw (BusinessException) cause;
        }

        throw new BusinessException(
                ErrorCode.SERVICE_UNAVAILABLE,
                "User service is currently unavailable!!"
        );
    }

	public List<Product> getProducts() {
		// TODO Auto-generated method stub
		return productRepository.findAll();
	}

	public Product getOrderById(Long id) {
		// TODO Auto-generated method stub
		return productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(
                "Order not found with id: "+id
        ));
	}

}
