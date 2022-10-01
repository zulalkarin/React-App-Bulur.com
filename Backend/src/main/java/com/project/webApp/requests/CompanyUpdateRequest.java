package com.project.webApp.requests;

import com.project.webApp.entity.Company;
import lombok.Data;

@Data
public class CompanyUpdateRequest {
    String title;
    Long categoryId;
    Long naceId;
    Long ilId;
    Long ilceId;
    Long mahalleId;
    Long geocode;


}
