package com.project.webApp.repos;

import com.project.webApp.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepo extends JpaRepository<Category, Long> {

}
