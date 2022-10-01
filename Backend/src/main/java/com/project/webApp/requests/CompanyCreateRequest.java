package com.project.webApp.requests;

import lombok.Data;

@Data
public class CompanyCreateRequest {

    Long id;
    Long categoryId;
    Long ilId;
    Long ilceId;
    Long mahalleId;
    String title;

}
