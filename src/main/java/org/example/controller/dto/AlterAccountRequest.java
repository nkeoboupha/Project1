package org.example.controller.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


// Input for cancel account, approve account, deny account
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AlterAccountRequest {
    @NotBlank(message = "username is required")
    String username;

    @NotBlank(message = "password is required")
    String password;

    @NotBlank(message = "account ID is required")
    Integer accountId;
}
