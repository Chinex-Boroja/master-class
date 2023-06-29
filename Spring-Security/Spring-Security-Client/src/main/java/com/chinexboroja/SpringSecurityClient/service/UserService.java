package com.chinexboroja.SpringSecurityClient.service;

import com.chinexboroja.SpringSecurityClient.dto.UserDTO;
import com.chinexboroja.SpringSecurityClient.entity.User;

public interface UserService {
    User registerUser(UserDTO userDTO);

    void saveVerificationTokenForUser(String token, User user);

    String validateVerificationToken(String token);
}
