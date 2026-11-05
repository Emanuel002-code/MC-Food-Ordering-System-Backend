package com.mcfoods.mcfoodorderingsystem.controller;

import com.mcfoods.mcfoodorderingsystem.dto.CategoryDTO;
import com.mcfoods.mcfoodorderingsystem.response.Response;
import com.mcfoods.mcfoodorderingsystem.service.CategoryService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {

        this.categoryService = categoryService;

    }

    @GetMapping("/api/categories")
    public ResponseEntity<Response<List<CategoryDTO>>>  getAllCategories() {

        List<CategoryDTO> response = categoryService.getAllCategories();

        return ResponseEntity.ok(Response.success(response, "Categories successfully retrieved", 200));
    }

    @GetMapping("/api/categories/{id}")
    public ResponseEntity<Response<CategoryDTO>>  getCategoryById(@PathVariable Long id)
    {
       CategoryDTO categoryDTO =  categoryService.findById(id);

       return ResponseEntity.ok(Response.success(categoryDTO, "Category successfully retrieved", 200));
    }

    @GetMapping("/api/categories/name")
    public ResponseEntity<Response<CategoryDTO>>  getCategoryByName(@RequestParam String categoryName) {

        CategoryDTO categoryDTO =  categoryService.findByName(categoryName);

        return ResponseEntity.ok(Response.success(categoryDTO, "Category successfully retrieved", 200));
    }

    @PostMapping("/api/categories")
    public ResponseEntity<Response<CategoryDTO>>   addCategory(@Valid @RequestBody CategoryDTO categoryDTO)
    {
        CategoryDTO saveCategory = categoryService.addCategory(categoryDTO);

        return ResponseEntity.ok(Response.success(saveCategory, "Category successfully created", 201));

    }

    @PutMapping("/api/categories/{id}")
    public ResponseEntity<Response<CategoryDTO>> updateCategory(@PathVariable Long id, @Valid @RequestBody CategoryDTO categoryDTO)
    {
         CategoryDTO saveCategory = categoryService.updateCategory(id, categoryDTO);

         return ResponseEntity.ok(Response.success(saveCategory, "Category successfully updated", 200));
    }

    @DeleteMapping("/api/categories/{id}")
    public ResponseEntity<Response<Boolean>> deleteCategory(@PathVariable Long id)
    {
        categoryService.deleteCategoryById(id);
        return ResponseEntity.ok(Response.success(null, "Category successfully deleted", 200));
    }

}
