package com.chinexboroja.SpringSecurityClient.controller;

import com.chinexboroja.SpringSecurityClient.dto.PasswordDTO;
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

import java.util.Optional;
import java.util.UUID;

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

     @PostMapping("/resetPassword")
     public String resetPassword(@RequestBody PasswordDTO passwordDTO, HttpServletRequest request) {
        User user = userService.findUserByEmail(passwordDTO.getEmail());
        String url = "";
        if (user != null) {
            String token = UUID.randomUUID().toString();
            userService.createPasswordResetTokenForUser(user, token);
            url = passwordResetTokenMail(user, applicationUrl(request), token);
        }

        return url;
     }

     @PostMapping("/savePassword")
     public String savePassword(@RequestParam("token") String token, @RequestBody PasswordDTO passwordDTO) {

        String result = userService.validatePasswordResetToken(token);
        if (!result.equalsIgnoreCase("valid")) {
            return "Invalid Token";
        }

         Optional<User> user = userService.getUserByPasswordResetToken(token);
        if (user.isPresent()) {
            userService.changePassword(user.get(), passwordDTO.getNewPassword());
            return "Password Reset Successfully";
        } else {
            return "Invalid Token";
        }

     }

     @PostMapping("/changePassword")
     public String changePassword(@RequestBody PasswordDTO passwordDTO) {
        User user = userService.findUserByEmail(passwordDTO.getEmail());

        if(!userService.checkIfValidOldPassword(user, passwordDTO.getOldPassword())) {
           return "Invalid Old password";
        }

        userService.changePassword(user, passwordDTO.getNewPassword());

        return "Password Changed Successfully";
     }

    private String passwordResetTokenMail(User user, String applicationUrl, String token) {

        String url = applicationUrl + "/savePassword?token=" + token;
        log.info("Click the link to Reset your Password: {}", url);
        return url;
    }

    private void resendVerificationTokenMail(User user, String applicationUrl, VerificationToken verificationToken) {

        String url = applicationUrl + "/verifyRegistration?token=" + verificationToken.getToken();
        log.info("Click the link to verify your account: {}", url);
    }

    private String applicationUrl(HttpServletRequest request) {
        return "http://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
    }
}
