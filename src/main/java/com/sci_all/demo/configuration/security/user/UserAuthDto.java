package com.sci_all.demo.configuration.security.user;

import lombok.Data;

@Data
public class UserAuthDto {
    private String email;
    private String password;
}
