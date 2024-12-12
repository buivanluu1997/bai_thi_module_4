package com.example.bai_thi_module_4.repository;

import com.example.bai_thi_module_4.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;

public interface IProductRepository extends JpaRepository<Product, Integer> {
    Page<Product> searchProductByNameContaining(String name, Pageable pageable);

}
