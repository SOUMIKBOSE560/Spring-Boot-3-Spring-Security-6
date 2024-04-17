package net.springsecurity.SpringSecurityRoleBasedAuth.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
@EnableMethodSecurity
public class SpringSecurityConfig {

    //AUTHENTICATED USER WITH DETAILS
//    @Bean
//    public UserDetailsService userDetailsService(){
//        User user =(User) User.builder().username("user").password(passwordEncoder().encode("user")).roles("USER").build();
//        User admin =(User) User.builder().username("admin").password(passwordEncoder().encode("admin")).roles("ADMIN").build();
//        return new InMemoryUserDetailsManager(user,admin);
//    }

    //SECURE URL
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity security) throws Exception {
        return  security.csrf().disable()
                .authorizeHttpRequests()
                .requestMatchers("/user/**","/admin/**")
                .permitAll()
                .and().build();

    }

    //PASSWORD ENCODER
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    //AUTHENTICATION MANAGER
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration builder) throws Exception {
        return builder.getAuthenticationManager();
    }
}
