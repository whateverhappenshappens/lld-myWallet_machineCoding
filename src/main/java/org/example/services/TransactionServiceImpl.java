package org.example.services;

import org.example.entities.Account;
import org.example.entities.Transaction;
import org.example.entities.TransactionType;
import org.example.repositories.AccountRepoImpl;
import org.example.repositories.TransactionRepoImpl;

import java.math.BigDecimal;
import java.util.List;

public class TransactionServiceImpl implements TransactionService{
    TransactionRepoImpl transactionRepo = TransactionRepoImpl.getInstance();
    AccountService accountService = new AccountServiceImpl();

    private String generateTransactionId(){
        return Integer.toString(Transaction.generatedId++);
    }

    @Override
    public void transferFund(String from, String to,BigDecimal amount) {
        Account fromBasic = accountService.getBasicAccount(from);
        Account toBasic = accountService.getBasicAccount(to);
        BigDecimal fromBalance = fromBasic.getBalance();
        BigDecimal toBalance = toBasic.getBalance();
        if(fromBalance.compareTo(amount) < 0){
            System.out.println("Insufficient Balance");
            return;
        }
        accountService.removeFunds(from,amount);
        accountService.addFunds(to,amount);

        Transaction transaction = Transaction.builder()
                .transactionType(TransactionType.TRANSFER)
                .id(generateTransactionId())
                .To(to)
                .From(from)
                .TransferAmount(amount)
                .createdAt(String.valueOf(System.currentTimeMillis()))
                .build();
        transactionRepo.save(transaction);
        System.out.println("Transaction Id: "+transaction.getId()+" Account Id"+fromBasic.getUserId());
        System.out.println("Funds of amount "+amount+" transferred from"+from+" to "+to);
    }

    @Override
    public void addFunds(String userId, BigDecimal amount) {
        Account fromBasic = accountService.getBasicAccount(userId);
        accountService.addFunds(userId,amount);
        Transaction transaction = Transaction.builder()
                .transactionType(TransactionType.ADD_FUND)
                .id(generateTransactionId())
                .createdAt(String.valueOf(System.currentTimeMillis()))
                .TransferAmount(amount)
                .To(userId)
                .From(userId)
                .build();
        transactionRepo.save(transaction);
        System.out.println("Transaction Id: "+transaction.getId());
        System.out.println(amount+" added to "+" Account Id"+fromBasic.getUserId());
    }

    @Override
    public void accountStatement(String userId) {
        List<Transaction> transactions = transactionRepo.accountStatement(userId);
        System.out.println(transactions);
    }
}
