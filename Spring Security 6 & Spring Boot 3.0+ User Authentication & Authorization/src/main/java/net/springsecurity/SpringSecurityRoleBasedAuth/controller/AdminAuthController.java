package net.springsecurity.SpringSecurityRoleBasedAuth.controller;

import net.springsecurity.SpringSecurityRoleBasedAuth.model.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class AdminAuthController {
    @Autowired
    private AuthenticationManager authManager;
    @GetMapping("/message")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String message(){
        return "THIS METHOD IS SECURED";
    }

    @PostMapping("/authentication")
    public String authentication(@RequestBody UserInfo userInfo){
        Authentication authentication = authManager.authenticate(new UsernamePasswordAuthenticationToken(
                userInfo.getUsername(),
                userInfo.getPassword()
        ));
        if(authentication.isAuthenticated()){
            System.out.println(authentication.getAuthorities());
            return userInfo.getUsername() + " IS AUTHENTICATED ";
        }
        return userInfo.getUsername() +" NOT AUTHENTICATED";
    }
}
