package com.scaler.project.userservice.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignUpDto {
    private String name;
    private String password;
    private String email;
}
