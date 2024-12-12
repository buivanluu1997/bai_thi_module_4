package com.example.bai_thi_module_4.repository;


import com.example.bai_thi_module_4.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoryRepository extends JpaRepository<Category, Integer> {
}
