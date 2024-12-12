package com.example.bai_thi_module_4.service.impl;

import com.example.bai_thi_module_4.model.Product;
import com.example.bai_thi_module_4.repository.IProductRepository;
import com.example.bai_thi_module_4.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService {
    @Autowired
    private IProductRepository productRepository;

    @Override
    public Page<Product> searchProductByNameContaining(String name, Pageable pageable) {
        return productRepository.searchProductByNameContaining(name, pageable);
    }

    @Override
    public Product getProductById(int id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public void saveProduct(Product product) {
        productRepository.save(product);
    }

    @Override
    public void deleteProduct(int id) {
        productRepository.deleteById(id);
    }


}
