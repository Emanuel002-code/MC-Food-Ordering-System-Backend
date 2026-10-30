package com.mcfoods.mcfoodorderingsystem.service;

import com.mcfoods.mcfoodorderingsystem.dto.CategoryDTO;

import java.util.List;

public interface CategoryService  {

    /*
      Retrieve all categories from the database
     */
    List<CategoryDTO> getAllCategories();

    /*
      Find the category by id
     */
    CategoryDTO findById(Long id);

    /*
     Find Category by name
     */
    CategoryDTO findByName(String name);

    /*
      add category
     */
    CategoryDTO addCategory(CategoryDTO categoryDTO);

    /*
     update the existing category
     */
    CategoryDTO updateCategory(Long id, CategoryDTO categoryDTO);

    /*
     Delete category
     */
    void deleteCategoryById(Long id);
}
