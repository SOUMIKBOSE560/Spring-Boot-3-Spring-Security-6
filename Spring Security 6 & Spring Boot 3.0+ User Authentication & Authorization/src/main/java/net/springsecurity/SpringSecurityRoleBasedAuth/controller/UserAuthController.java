package net.springsecurity.SpringSecurityRoleBasedAuth.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/user")
public class UserAuthController {
    @GetMapping("/message")
    public String message(){
        return "THIS IS A USER CONTROLLER";
    }
}
