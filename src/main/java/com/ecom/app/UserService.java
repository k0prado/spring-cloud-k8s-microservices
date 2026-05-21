package com.ecom.app;

import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

     private final List<User> userList = new ArrayList<>();
     private Long id = 1L;
    
    public List<User> fetchAllUsers() {
        return userList;
    }

    public Optional<User> fetchUser(Long id) {
        return userList.stream().filter(user -> user.getId().equals(id)).findFirst();
    }

    public void addUser(User user) {
        user.setId(id++);
        userList.add(user);
    }

    public Boolean editUser(Long id, User user){
        return userList.stream().filter(userE -> userE.getId().equals(id)).findFirst().map(userE-> {
            userE.setName(user.getName());
            userE.setLastName(user.getLastName());
            return true;
        }).orElse(false);
    }
    
}
