package com.bank.account_service.Repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.bank.account_service.model.Account;

public interface AccountRepository extends JpaRepository<Account, String> {
}
