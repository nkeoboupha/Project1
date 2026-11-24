package org.example.controller.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


//For use with Withdrawal and Deposit
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TransferRequest {
    @NotBlank(message = "username is required")
    private String username;

    @NotBlank(message = "password is required")
    private String password;

    @NotBlank(message = "destination account Id is required")
    private Integer accountIdTo;

    @NotBlank(message = "amount is required")
    private Double amount;
}
