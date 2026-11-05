package com.mcfoods.mcfoodorderingsystem.service;

import com.mcfoods.mcfoodorderingsystem.dto.CategoryDTO;
import com.mcfoods.mcfoodorderingsystem.entity.Category;

public class Helper {

    public static CategoryDTO fromCategoryToDTO(Category category) {
        CategoryDTO dto = new CategoryDTO();

        dto.setCategoryId(category.getCategoryId());
        dto.setCategoryName(category.getCategoryName());
        dto.setCategoryDescription(category.getCategoryDescription());
        dto.setCategoryImage(category.getCategoryImage());

        return dto;
    }

    public static Category fromDTOToCategory(CategoryDTO categoryDTO) {

        Category category = new Category();
        //category.setCategoryId(categoryDTO.getCategoryId());
        category.setCategoryName(categoryDTO.getCategoryName());
        category.setCategoryDescription(categoryDTO.getCategoryDescription());
        category.setCategoryImage(categoryDTO.getCategoryImage());
        return category;
    }

}
