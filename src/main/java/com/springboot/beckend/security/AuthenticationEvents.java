package com.springboot.beckend.security;

import org.springframework.context.event.EventListener;
import org.springframework.security.authentication.event.AbstractAuthenticationFailureEvent;
import org.springframework.security.authentication.event.AuthenticationFailureBadCredentialsEvent;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.stereotype.Component;

@Component
public class AuthenticationEvents {
    
 @EventListener
        public void onSuccess(AuthenticationSuccessEvent success) {
            System.out.println(success);
            System.out.println("success event");
            // ...
        }
    
        @EventListener
        public void onFailure(AbstractAuthenticationFailureEvent failures) {
            System.out.println(failures);
            System.out.println("failed event");
            // ...
        }
    
        @EventListener
        public void onFailure(AuthenticationFailureBadCredentialsEvent failures) {
            System.out.println(failures);
            System.out.println("failed event");
            // ...
        }
}
