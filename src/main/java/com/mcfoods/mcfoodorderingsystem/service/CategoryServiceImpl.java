package com.mcfoods.mcfoodorderingsystem.service;

import com.mcfoods.mcfoodorderingsystem.dto.CategoryDTO;

import java.util.List;


public class CategoryServiceImpl implements CategoryService {


    private final CategoryService categoryService;

    public CategoryServiceImpl(CategoryService categoryService) {
        this.categoryService = categoryService;
    }


    @Override
    public List<CategoryDTO> getAllCategories() {
        return List.of();
    }

    @Override
    public CategoryDTO findById(Long id) {
        return null;
    }

    @Override
    public CategoryDTO findByName(String name) {
        return null;
    }

    @Override
    public CategoryDTO addCategory(CategoryDTO category) {
        return null;
    }

    @Override
    public CategoryDTO updateCategory(Long id, CategoryDTO category) {
        return null;
    }

    @Override
    public void deleteCategoryById(Long id) {

    }
}
