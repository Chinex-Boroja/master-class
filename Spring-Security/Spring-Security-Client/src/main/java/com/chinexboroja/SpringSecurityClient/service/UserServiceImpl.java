package com.chinexboroja.SpringSecurityClient.service;

import com.chinexboroja.SpringSecurityClient.dto.UserDTO;
import com.chinexboroja.SpringSecurityClient.entity.User;
import com.chinexboroja.SpringSecurityClient.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;
    @Override
    public User registerUser(UserDTO userDTO) {

        User user = new User();
        user.setEmail(userDTO.getEmail());
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setRole("USER");
        user.setPassword(userDTO.getPassword());

        return userRepository.save(user);
    }
}
