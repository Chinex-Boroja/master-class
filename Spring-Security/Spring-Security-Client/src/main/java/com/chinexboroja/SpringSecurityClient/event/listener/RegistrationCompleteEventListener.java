package com.chinexboroja.SpringSecurityClient.event.listener;

import com.chinexboroja.SpringSecurityClient.entity.User;
import com.chinexboroja.SpringSecurityClient.event.RegistrationCompleteEvent;
import com.chinexboroja.SpringSecurityClient.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@Slf4j
public class RegistrationCompleteEventListener implements
        ApplicationListener<RegistrationCompleteEvent> {

    @Autowired
    private UserService userService;

    @Override
    public void onApplicationEvent(RegistrationCompleteEvent event) {
        // Create the verification token for the user with Link
        User user = event.getUser();
        String token = UUID.randomUUID().toString();
        userService.saveVerificationTokenForUser(token, user);

        //Send mail to the user
        String url = event.getApplicationUrl()
                + "/verifyRegistration?token=" + token;
        //SendVerificationEmail()
        log.info("Click to verify account: {}",  url);
    }
}
