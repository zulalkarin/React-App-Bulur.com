package com.project.webApp.repos;

import com.project.webApp.entity.Mahalle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MahalleRepo extends JpaRepository<Mahalle, Long> {
    List<Mahalle> findByIlIdAndIlceIdAndId(Long ilId, Long ilceId, Long id);

    List<Mahalle> findByIlIdAndIlceId(Long ilId,Long ilceId);

    List<Mahalle> findByIlId(Long ilId);
}
