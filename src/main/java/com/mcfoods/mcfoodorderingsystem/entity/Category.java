package com.mcfoods.mcfoodorderingsystem.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

/*
  Category entity class that represents the categories able in the database
 */

@Setter
@Entity
@Getter
@Table(name= "category")
public class Category {

    /*
      generate the unique id for the category
     */

     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Long categoryId;
     private String categoryName;
     private String categoryDescription;
     private String categoryImage;

     //default constructor
    public Category() { }

    //All args constructor
    public Category(Long categoryId ,String categoryName, String categoryDescription, String categoryImage) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.categoryDescription = categoryDescription;
        this.categoryImage = categoryImage;
    }

}
