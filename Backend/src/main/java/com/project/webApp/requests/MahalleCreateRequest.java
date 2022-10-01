package com.project.webApp.requests;

import lombok.Data;

@Data
public class MahalleCreateRequest {
    Long id;
    Long ilId;
    Long ilceId;
    String name;
}
