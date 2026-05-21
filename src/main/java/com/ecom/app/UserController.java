package com.ecom.app;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private final List<User> userlist = new ArrayList<>();

    @GetMapping("/api/users")
    public List<User> getAllUsers() {
        return userlist;
    }
}