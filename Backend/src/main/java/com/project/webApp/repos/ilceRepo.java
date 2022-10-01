package com.project.webApp.repos;

import com.project.webApp.entity.ilce;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ilceRepo extends JpaRepository<ilce, Long> {
    List<ilce> findByIlId(Optional<Long> ilId);

}
