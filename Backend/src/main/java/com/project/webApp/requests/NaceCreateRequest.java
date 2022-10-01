package com.project.webApp.requests;

import lombok.Data;

@Data
public class NaceCreateRequest {
    Long id;
    Long categoryId;
    String title;
}
