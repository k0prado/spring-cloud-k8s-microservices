package com.ecom.app.dto;

import lombok.Data;

@Data
public class UserResponse {
    private Long id;
    private String name;
    private String lastName;
    private String email;
    private String phone;
    private AdressDto adress;
}
