package org.example;

import org.example.repositories.TransactionRepoImpl;
import org.example.services.AccountServiceImpl;
import org.example.services.TransactionServiceImpl;
import org.example.services.UserServiceImpl;

import java.math.BigDecimal;

public class WalletServiceFacade {
    private final UserServiceImpl userService;
    private final AccountServiceImpl accountService;
    private final TransactionServiceImpl transactionService;

    public WalletServiceFacade() {
        userService = new UserServiceImpl();
        accountService = new AccountServiceImpl();
        transactionService = new TransactionServiceImpl();
    }
    public void createUser(String username){
        userService.createUser(username);
    }
    public void getUserById(String userId){
        userService.getUserById(userId);
    }
    public void transferFund(String from, String to, BigDecimal amount){
        transactionService.transferFund(from,to,amount);
    }
    void addFunds(String userId,BigDecimal amount ){
        transactionService.addFunds(userId,amount);
    }
    void accountStatement(String userId){
        transactionService.accountStatement(userId);
    }
    public void createAccount(String userId){
        accountService.createAccount(userId);
    }
    public void overview(){
        accountService.overview();
    }
    public void userAccounts(String userId){
        accountService.userAccounts(userId);
    }
}
