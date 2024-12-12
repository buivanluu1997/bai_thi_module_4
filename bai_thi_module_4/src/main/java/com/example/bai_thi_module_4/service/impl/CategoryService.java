package com.example.bai_thi_module_4.service.impl;

import com.example.bai_thi_module_4.model.Category;
import com.example.bai_thi_module_4.repository.ICategoryRepository;
import com.example.bai_thi_module_4.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService implements ICategoryService {
    @Autowired
    private ICategoryRepository categoryRepository;
    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }
}
