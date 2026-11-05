package com.mcfoods.mcfoodorderingsystem.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.springframework.validation.annotation.Validated;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Validated
public class CategoryDTO {


    private Long categoryId;

    @NotBlank(message = "Category name is required")
    @Size(min = 2, max=100, message =  "category name must have 2-100 characters long")
    private String categoryName;

    @NotBlank(message = "Description  for the category is required ")
    @Size(min = 2, max = 1000, message = "Description must have 2-1000 characters long")
    private String categoryDescription;


    private String categoryImage;

}
