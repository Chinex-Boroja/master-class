package com.chinexboroja.SpringSecurityClient.controller;

import com.chinexboroja.SpringSecurityClient.dto.UserDTO;
import com.chinexboroja.SpringSecurityClient.entity.User;
import com.chinexboroja.SpringSecurityClient.entity.VerificationToken;
import com.chinexboroja.SpringSecurityClient.event.RegistrationCompleteEvent;
import com.chinexboroja.SpringSecurityClient.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.*;

@Slf4j
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

     @GetMapping("/verifyRegistration")
     public String verifyRegistration(@RequestParam("token") String token) {
        String result = userService.validateVerificationToken(token);
        if (result.equalsIgnoreCase("valid")) {
            return "User Verified Successfully";
        }
        return "Bad User";
     }

     @GetMapping("/resendVerifyToken")
     public String resendVerificationToken(@RequestParam("token") String oldToken, HttpServletRequest request) {

         VerificationToken verificationToken = userService.generateVerificationToken(oldToken);
         User user = verificationToken.getUser();
         resendVerificationTokenMail(user, applicationUrl(request), verificationToken);
         return "Verification Link Sent";
     }

    private void resendVerificationTokenMail(User user, String applicationUrl, VerificationToken verificationToken) {

        String url = applicationUrl + "/verifyRegistration?token=" + verificationToken.getToken();
        log.info("Click the link to verify your account: {}", url);
    }

    private String applicationUrl(HttpServletRequest request) {
        return "http://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
    }
}
