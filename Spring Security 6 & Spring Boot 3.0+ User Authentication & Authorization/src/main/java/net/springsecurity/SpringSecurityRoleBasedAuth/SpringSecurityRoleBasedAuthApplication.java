package net.springsecurity.SpringSecurityRoleBasedAuth;

import org.springframework.boot.ApplicationContextFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication
@CrossOrigin
public class SpringSecurityRoleBasedAuthApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityRoleBasedAuthApplication.class, args);
	}

}
