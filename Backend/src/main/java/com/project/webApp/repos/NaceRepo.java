package com.project.webApp.repos;

import com.project.webApp.entity.Nace;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NaceRepo extends JpaRepository<Nace, Long> {
    List<Nace> findByCategoryId(Long categoryId);
}
