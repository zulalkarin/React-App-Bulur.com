package com.project.webApp.requests;

import lombok.Data;

@Data
public class UserUpdateRequest {

    String password;
    String userName;
    String userRole;
}
