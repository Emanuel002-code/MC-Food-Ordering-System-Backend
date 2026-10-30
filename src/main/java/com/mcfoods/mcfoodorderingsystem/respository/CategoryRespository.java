package com.mcfoods.mcfoodorderingsystem.respository;

import com.mcfoods.mcfoodorderingsystem.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 CategoryRepository class responsible for database operations
 */

public interface CategoryRespository extends JpaRepository<Category, Long> {
}
