package com.ecom.app.service;

import com.ecom.app.dto.UserResponse;
import com.ecom.app.model.User;
import com.ecom.app.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;
import com.ecom.app.dto.AdressDto;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import com.ecom.app.dto.UserRequest;
import java.util.stream.Stream;
import com.ecom.app.model.Adress;

@Service
@Transactional
public class UserService {

    private final UserRepository userRepository;
    
   
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserResponse> fetchAllUsers() {
        return userRepository.findAll().stream().map(this::mapToUserResponse).
            collect(Collectors.toList());
    }

    public Optional<UserResponse> fetchUser(Long id) {
        return userRepository.findById(id).map(this::mapToUserResponse);
    }

    public void addUser(UserRequest userRequest) {
        User user = new User();
        updateUserFromRequest(user, userRequest);
        userRepository.save(user);
    }

    public Boolean editUser(Long id, UserRequest userRequest){
        return userRepository.findById(id)
            .map(existigUser ->{
                updateUserFromRequest(existigUser, userRequest);
                userRepository.save(existigUser);
                return true;
            }).orElse(false);
    }

    private UserResponse mapToUserResponse(User user) {
        UserResponse userResponse = new UserResponse();
        userResponse.setId(user.getId());
        userResponse.setName(user.getName());
        userResponse.setLastName(user.getLastName());
        userResponse.setEmail(user.getEmail());
        userResponse.setPhone(user.getPhone());
        userResponse.setRole(user.getRole());
        
        if(user.getAdress() != null) {
            AdressDto adressDto = new AdressDto();
            adressDto.setStreet(user.getAdress().getStreet());
            adressDto.setCity(user.getAdress().getCity());
            adressDto.setState(user.getAdress().getState());
            adressDto.setZipCode(user.getAdress().getZipCode());
            adressDto.setCountry(user.getAdress().getCountry());
            userResponse.setAdress(adressDto);
        }

        return userResponse;
    }

    private void updateUserFromRequest(User user, UserRequest userRequest) {
        user.setName(userRequest.getName());
        user.setLastName(userRequest.getLastName());
        user.setEmail(userRequest.getEmail());
        user.setPhone(userRequest.getPhone());
        user.setRole(userRequest.getRole());
        
        if(userRequest.getAdress() != null) {
            AdressDto adressDto = userRequest.getAdress();
            Adress adress = new Adress();
            adress.setStreet(adressDto.getStreet());
            adress.setCity(adressDto.getCity());
            adress.setState(adressDto.getState());
            adress.setZipCode(adressDto.getZipCode());
            adress.setCountry(adressDto.getCountry());
            user.setAdress(adress);
        }
    }
    
}
