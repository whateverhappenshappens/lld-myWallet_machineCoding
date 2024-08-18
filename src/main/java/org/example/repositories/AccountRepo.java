package org.example.repositories;

import org.example.entities.Account;

import java.math.BigDecimal;
import java.util.List;

public interface AccountRepo {
    List<Account> createAccount(String userId,Account account);
    List<List<Account>>overview();
    List<Account> userAccounts(String userId);


    Account getBasicAccount(String userId);
    void addFunds (String userId,BigDecimal amount);
    void removeFunds (String userId,BigDecimal amount);
}
