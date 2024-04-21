package com.exercise.springboot.services;

import com.exercise.springboot.models.ProductModel;
import com.exercise.springboot.repositories.ProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProductService {

    final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Transactional
    public ProductModel save(ProductModel productModel){
        return productRepository.save(productModel);
    }

    public Page<ProductModel> findAll(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

    public Optional<ProductModel> findById(UUID id) {
        return productRepository.findById(id);
    }

    @Transactional
    public void delete(ProductModel productModel) {
        productRepository.delete(productModel);
    }
}
