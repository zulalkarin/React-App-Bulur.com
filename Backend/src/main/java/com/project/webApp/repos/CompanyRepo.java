package com.project.webApp.repos;

import com.project.webApp.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CompanyRepo extends JpaRepository<Company, Long> {
    List<Company> findByCategoryIdAndNaceIdAndIlIdAndIlceIdAndMahalleId(Long categoryId, Long naceId, Long ilId,
                                                                        Long ilceId, Long mahalleId);


    List<Company> findByCategoryIdAndNaceIdAndIlIdAndIlceId(Long categoryId, Long naceId, Long ilId, Long ilceId);

    List<Company> findByCategoryIdAndNaceIdAndIlId(Long categoryId, Long naceId, Long ilId);

    List<Company> findByCategoryIdAndNaceId(Long categoryId, Long naceId);

    List<Company> findByCategoryId(Long categoryId);

    List<Company> findByCategoryIdAndIlIdAndIlceId(Long aLong, Long aLong1, Long aLong2);

    List<Company> findByCategoryIdAndIlId(Long categoryId, Long ilId);

    //  List<Company> findByCategoryIdAndIlIdAndIlceIdAndMahalleId(Long categoryId, Long ilId, Long ilceId, Long mahalleId);

   // List<Company> findByCategotyId(Long categoryId);
}
