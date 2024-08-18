package org.example.repositories;

import org.example.entities.Transaction;

import java.util.List;

public interface TransactionRepo {
    Transaction save(Transaction transaction);
    List<Transaction> accountStatement(String userId);
}
