package com.jamesconlon.financetracker.repository;

import com.jamesconlon.financetracker.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    Category findByName(String name);

    List<Category> findByNameIn(List<String> categoryNames);
}
