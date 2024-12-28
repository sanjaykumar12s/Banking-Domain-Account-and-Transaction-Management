package com.bank.Transaction.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bank.Transaction.model.Transaction;

import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, String> {
    List<Transaction> findByAccountId(String accountId);
}
