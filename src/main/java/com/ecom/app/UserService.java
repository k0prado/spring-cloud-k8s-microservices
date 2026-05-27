package com.ecom.app;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserService {

    private final UserRepository userRepository;
    
   
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> fetchAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> fetchUser(Long id) {
        return userRepository.findById(id);
    }

    public void addUser(User user) {
        userRepository.save(user);
    }

    public Boolean editUser(Long id, User user){
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isPresent()) {
            User userE = userOptional.get();
            userE.setName(user.getName());
            userE.setLastName(user.getLastName());
            userRepository.save(userE);
            return true;
        }
        return false;
    }
    
}
