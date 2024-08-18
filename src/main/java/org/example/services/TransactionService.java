package org.example.services;

import org.example.entities.Account;
import org.example.entities.Transaction;

import java.math.BigDecimal;
import java.util.List;

public interface TransactionService {
    void transferFund(String from, String to, BigDecimal amount);
    void addFunds(String userId,BigDecimal amount);
    void accountStatement(String userId);

}
