package com.example.bai_thi_module_4.service;

import com.example.bai_thi_module_4.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IProductService {
    Page<Product> searchProductByNameContaining(String name, Pageable pageable);

    Product getProductById(int id);

    void saveProduct(Product product);

    void deleteProduct(int id);
}
