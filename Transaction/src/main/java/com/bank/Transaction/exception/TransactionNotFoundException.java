package com.bank.Transaction.exception;

public class TransactionNotFoundException extends RuntimeException {

    public TransactionNotFoundException(String id, boolean isAccountId) {
        super(isAccountId
            ? "No transactions found for Account ID: " + id
            : "Transaction not found with ID: " + id);
    }
}
