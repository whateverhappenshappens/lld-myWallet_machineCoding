package org.example.services;

import org.example.entities.Account;

import java.math.BigDecimal;
import java.util.List;

public interface AccountService {
    void createAccount(String userId);
    void overview();
    void userAccounts(String userId);
    void addFunds(String userId,BigDecimal amount);

    Account getBasicAccount(String from);

    void removeFunds(String from, BigDecimal amount);
}
