package org.example.services;

import org.example.entities.Account;
import org.example.entities.AccountTypeEnum;
import org.example.repositories.AccountRepoImpl;

import java.math.BigDecimal;
import java.util.List;

public class AccountServiceImpl implements AccountService{
    AccountRepoImpl accountRepo = AccountRepoImpl.getInstance();

    @Override
    public void createAccount(String userId) {
        Account account = Account.builder()
                .createdAt(String.valueOf(System.currentTimeMillis()))
                .balance(new BigDecimal(100))
                .userId(userId)

                .type(AccountTypeEnum.BASIC)
                .build();
        List<Account> account1 = accountRepo.createAccount(userId,account);
        System.out.println("Account created");
        System.out.println("Account Details: "+account1);
    }

    @Override
    public void overview() {
        List<List<Account>> overview =  accountRepo.overview();
        System.out.println("Accounts overview");
        for(List<Account> account:overview){
            System.out.println(account);
        }
    }


    @Override
    public void userAccounts(String userId) {
       List<Account>account = accountRepo.userAccounts(userId);
        System.out.println("Account info of user with id: "+userId);
        System.out.println(account);
    }

    @Override
    public void addFunds(String userId, BigDecimal amount) {
        accountRepo.addFunds(userId,amount);
    }

    @Override
    public Account getBasicAccount(String from) {
       return accountRepo.getBasicAccount(from);
    }

    @Override
    public void removeFunds(String from, BigDecimal amount) {
        accountRepo.removeFunds(from,amount);
    }
}
