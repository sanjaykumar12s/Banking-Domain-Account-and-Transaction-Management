package com.bank.account_service.Controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.bank.account_service.Service.AccountService;
import com.bank.account_service.model.Account;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PostMapping
    public Account createAccount(@Valid @RequestBody Account account) {
        return accountService.createAccount(account);
    }

    @GetMapping("/{accountId}")
    public Account getAccount(@PathVariable String accountId) {
        return accountService.getAccount(accountId);
    }

    @PutMapping("/{accountId}")
    public Account updateAccount(@PathVariable String accountId, @Valid @RequestBody Account account) {
        Account existingAccount = accountService.getAccount(accountId);
        existingAccount.setAccountHolderName(account.getAccountHolderName());
        existingAccount.setBalance(account.getBalance());
        return accountService.updateAccount(existingAccount);
    }

    @DeleteMapping("/{accountId}")
    public void deleteAccount(@PathVariable String accountId) {
        accountService.deleteAccount(accountId);
    }
}
