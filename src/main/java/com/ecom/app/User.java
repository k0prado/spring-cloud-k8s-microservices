package com.ecom.app;

public class User {
    private Long id;
    private String name;
    private String lastName;

    public User() {
    }

    public User(Long id, String name, String lastName) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
    }
}