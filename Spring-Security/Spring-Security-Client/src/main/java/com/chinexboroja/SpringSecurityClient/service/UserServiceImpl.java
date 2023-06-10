package com.chinexboroja.SpringSecurityClient.service;

import com.chinexboroja.SpringSecurityClient.dto.UserDTO;
import com.chinexboroja.SpringSecurityClient.entity.User;
import com.chinexboroja.SpringSecurityClient.entity.VerificationToken;
import com.chinexboroja.SpringSecurityClient.repository.UserRepository;
import com.chinexboroja.SpringSecurityClient.repository.VerificationTokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private VerificationTokenRepository verificationTokenRepository;

    @Override
    public User registerUser(UserDTO userDTO) {

        User user = new User();
        user.setEmail(userDTO.getEmail());
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setRole("USER");
        user.setPassword(passwordEncoder.encode(userDTO.getPassword()));

        userRepository.save(user);
        return user;
    }

    @Override
    public void saveVerificationTokenForUser(String token, User user) {

        VerificationToken verificationToken = new VerificationToken(user, token);

        verificationTokenRepository.save(verificationToken);

    }
}
