package net.springsecurity.SpringSecurityRoleBasedAuth.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class UserInfoDetailsService implements UserDetailsService {
    @Autowired
    private PasswordEncoder encoder;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("USERNAME : " + username);
        if(username.equals("user")) {
            return User.builder().username("user").password(encoder.encode("user")).roles("USER").build();
        }
        else if (username.equals("admin")) {
            return User.builder().username("admin").password(encoder.encode("admin")).roles("ADMIN","MANAGER").build();
        }
        throw new UsernameNotFoundException("USERNAME NOT FOUND");
    }
}
