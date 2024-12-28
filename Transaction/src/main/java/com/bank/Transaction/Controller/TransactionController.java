package com.bank.Transaction.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.bank.Transaction.Service.TransactionService;
import com.bank.Transaction.model.Transaction;

import java.util.List;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @PostMapping
    public Transaction createTransaction(@RequestBody Transaction transaction) {
        return transactionService.createTransaction(transaction);
    }

    @GetMapping("/history/{accountId}")
    public List<Transaction> getTransactionHistory(@PathVariable String accountId) {
        return transactionService.getTransactionsByAccountId(accountId);
    }

    @GetMapping("/{transactionId}")
    public Transaction getTransactionById(@PathVariable String transactionId) {
        return transactionService.getTransactionById(transactionId);
    }
}
