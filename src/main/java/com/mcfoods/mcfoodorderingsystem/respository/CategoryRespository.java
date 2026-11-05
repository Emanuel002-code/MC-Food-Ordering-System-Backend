package com.mcfoods.mcfoodorderingsystem.respository;

import com.mcfoods.mcfoodorderingsystem.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


/**
 CategoryRepository class responsible for database operations
 */

public interface CategoryRespository extends JpaRepository<Category, Long> {

    Optional<Category> findByCategoryName(String name);
}
