package org.example.controller.dto;

import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.AllArgsConstructor;
import lombok.Setter;
import jakarta.validation.constraints.NotBlank;


//For use with Withdrawal and Deposit
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DebitOrCreditRequest {
    @NotBlank(message = "username is required")
    private String username;

    @NotBlank(message = "password is required")
    private String password;

    @NotBlank(message = "account Id is required")
    private Integer accountId;
}
