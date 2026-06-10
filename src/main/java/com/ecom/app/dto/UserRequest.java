package com.ecom.app.dto;

import lombok.Data;

@Data
public class UserResquest {
    private String name;
    private String lastName;
    private String email;
    private String phone;
    private AdressDto adress;
}
