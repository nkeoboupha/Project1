package org.example.controller;

import org.example.repository.entity.User;
import org.example.repository.entity.Account;
import org.example.service.UserService;
import org.example.service.AccountService;
import org.example.controller.dto.AccountCredentials;
import org.example.controller.dto.DebitOrCreditRequest;
import org.example.controller.dto.TransferRequest;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/account")
public class AccountController {
    private final AccountService accountService;
    private final UserService userService;

    public AccountController(AccountService accountService, UserService userService){
        this.accountService = accountService;
        this.userService = userService;
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAccount(@Valid @RequestBody AccountCredentials ac, @PathVariable Integer id){
        String outcome = userService.deleteAccount(ac, id);
        switch(outcome){
            case "deleted":
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            case "unauthorized":
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
            default:
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    @PostMapping("/{id}/withdrawal")
    public ResponseEntity<Void> withdrawFromAccount(@Valid @RequestBody DebitOrCreditRequest debitRequest, @PathVariable Integer id){
        AccountCredentials ac = new AccountCredentials(debitRequest.getUsername(), debitRequest.getPassword());
        String outcome = accountService.processWithdrawal(ac, id);
        switch(outcome){
            case "accepted":
                return ResponseEntity.status(HttpStatus.ACCEPTED).build();
            case "unauthorized":
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
            case "negative value":
            case "amount exceeds balance":
                return ResponseEntity.status(HttpStatus.UNPROCESSABLE_CONTENT).build();
            default:
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    @PostMapping("/{id}/deposit")
    public ResponseEntity<Void> withdrawFromAccount(@Valid @RequestBody DebitOrCreditRequest creditRequest, @PathVariable Integer id){
        String outcome = accountService.processDeposit(creditRequest, id);
        switch(outcome){
            case "accepted":
                return ResponseEntity.status(HttpStatus.ACCEPTED).build();
            case "unauthorized":
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
            case "negative value":
                return ResponseEntity.status(HttpStatus.UNPROCESSABLE_CONTENT).build();
            default:
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    @PostMapping("/{id}/tranfser")
    public ResponseEntity<Void> transferFromAccount(@Valid @RequestBody TransferRequest transferRequest, @PathVariable Integer id){
        String outcome = accountService.processTransfer(transferRequest, id);
        switch(outcome){
            case "accepted":
                return ResponseEntity.status(HttpStatus.ACCEPTED).build();
            case "unauthorized":
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
            case "negative value":
            case "amount exceeds balance":
                return ResponseEntity.status(HttpStatus.UNPROCESSABLE_CONTENT).build();
            default:
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}
