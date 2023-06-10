package com.chinexboroja.SpringSecurityClient.controller;

import com.chinexboroja.SpringSecurityClient.dto.UserDTO;
import com.chinexboroja.SpringSecurityClient.entity.User;
import com.chinexboroja.SpringSecurityClient.event.RegistrationCompleteEvent;
import com.chinexboroja.SpringSecurityClient.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegistrationController {

    @Autowired
    private UserService userService;

    @Autowired
    private ApplicationEventPublisher publisher;

    @PostMapping("/register")
    public String registerUser(@RequestBody UserDTO userDTO, final HttpServletRequest request) {
         User user = userService.registerUser(userDTO);
         publisher.publishEvent(new RegistrationCompleteEvent(user, applicationUrl(request)));
         return "Success";
     }

    private String applicationUrl(HttpServletRequest request) {
        return "http://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
    }
}
