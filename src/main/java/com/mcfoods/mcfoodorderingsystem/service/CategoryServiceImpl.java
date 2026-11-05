package com.mcfoods.mcfoodorderingsystem.service;

import com.mcfoods.mcfoodorderingsystem.dto.CategoryDTO;
import com.mcfoods.mcfoodorderingsystem.entity.Category;
import com.mcfoods.mcfoodorderingsystem.exception.CategoryNotFoundException;
import com.mcfoods.mcfoodorderingsystem.respository.CategoryRespository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {


    private final CategoryRespository categoryRespository;

    public CategoryServiceImpl(CategoryRespository categoryRespository) {
        this.categoryRespository = categoryRespository;
    }


    @Override
    public List<CategoryDTO> getAllCategories() {

        List<Category> categories =  categoryRespository.findAll();
        List<CategoryDTO> categoryDTOS = new ArrayList<>();


        for(Category category : categories){

            CategoryDTO categoryDTO = Helper.fromCategoryToDTO(category);
            categoryDTOS.add(categoryDTO);

        }
        return categoryDTOS;
    }

    @Override
    public CategoryDTO findById(Long id) {

        Optional<Category> category = categoryRespository.findById(id);
        Category foundCategory = category.orElseThrow(()-> new CategoryNotFoundException("Category with id:"+id+" is not found"));

        return Helper.fromCategoryToDTO(foundCategory);
    }

    @Override
    public CategoryDTO findByName(String name) {

        Optional <Category> category= categoryRespository.findByCategoryName(name);
        Category FoundCategory = category.orElseThrow(()-> new CategoryNotFoundException("Category with name:"+name+" is not found"));

        return Helper.fromCategoryToDTO(FoundCategory);
    }

    @Override
    public CategoryDTO addCategory(CategoryDTO categoryDTO) {

        //covert category dto to category
        Category category = Helper.fromDTOToCategory(categoryDTO);
        category = categoryRespository.save(category);

         // covert and return saved category back to dto
        return Helper.fromCategoryToDTO(category);
    }

    @Override
    public CategoryDTO updateCategory(Long id, CategoryDTO categoryDTO) {

        Optional<Category> category = categoryRespository.findById(id);
        Category foundCategory = category.orElseThrow(()-> new CategoryNotFoundException("Category with id:"+id+" is not found"));

        if(categoryDTO.getCategoryName() != null){
            foundCategory.setCategoryName(categoryDTO.getCategoryName());
        }
        if(categoryDTO.getCategoryDescription() != null){
            foundCategory.setCategoryDescription(categoryDTO.getCategoryDescription());
        }
        if(categoryDTO.getCategoryImage() != null){
            foundCategory.setCategoryImage(categoryDTO.getCategoryImage());
        }

       Category updatedCategory= categoryRespository.save(foundCategory);


        return Helper.fromCategoryToDTO(updatedCategory);
    }

    @Override
    public void deleteCategoryById(Long id) {


        Optional<Category> category = categoryRespository.findById(id);
        Category foundCategory = category.orElseThrow(()-> new CategoryNotFoundException("Category with id:"+id+" is not found"));

        categoryRespository.delete(foundCategory);

    }
}
