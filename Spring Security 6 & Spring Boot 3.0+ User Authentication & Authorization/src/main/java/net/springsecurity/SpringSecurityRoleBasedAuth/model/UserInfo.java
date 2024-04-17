package net.springsecurity.SpringSecurityRoleBasedAuth.model;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class UserInfo {
    private String username;
    private String password;
}
