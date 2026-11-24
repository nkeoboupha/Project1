package org.example.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AccountCredentials {
    @NotBlank(message = "username is required")
    String username;
    @NotBlank(message= "password is required")
    String password;
}
