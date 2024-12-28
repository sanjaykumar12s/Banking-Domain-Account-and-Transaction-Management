package com.bank.Transaction.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.Transaction.Repository.TransactionRepository;
import com.bank.Transaction.model.Transaction;
import com.bank.Transaction.exception.TransactionNotFoundException;

import java.util.List;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    public Transaction createTransaction(Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    public List<Transaction> getTransactionsByAccountId(String accountId) {
        List<Transaction> transactions = transactionRepository.findByAccountId(accountId);
        if (transactions.isEmpty()) {
            throw new TransactionNotFoundException(accountId, true);  // true indicates accountId
        }
        return transactions;
    }

    public Transaction getTransactionById(String transactionId) {
        return transactionRepository.findById(transactionId)
                .orElseThrow(() -> new TransactionNotFoundException(transactionId, false));  // false indicates transactionId
    }
}
