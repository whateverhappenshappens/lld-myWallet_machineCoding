package org.example.repositories;

import org.example.entities.Transaction;

import java.util.*;

public class TransactionRepoImpl implements TransactionRepo {
    private static TransactionRepoImpl instance;

    private TransactionRepoImpl(){};
    public static TransactionRepoImpl getInstance(){
        if(instance == null){
            synchronized (UserRepoImpl.class){
                if(instance == null){
                    instance  = new TransactionRepoImpl();
                }
            }
        }
        return instance;
    }
    Map<String,Transaction> transactionMap = new HashMap<>();

    @Override
    public Transaction save(Transaction transaction) {
       return transactionMap.put(transaction.getId(),transaction);
    }

    @Override
    public List<Transaction> accountStatement(String userId) {
        List<Transaction> transactions = new ArrayList<>();
        for(String s:transactionMap.keySet()){
            Transaction transaction = transactionMap.get(s);
            if(transaction.getFrom().equals(userId) || transaction.getTo().equals(userId)){
                transactions.add(transaction);
            }
        }
        transactions.sort((a,b)->{
           return a.getCreatedAt().compareTo(b.getCreatedAt());});
        return transactions;
    }
}
