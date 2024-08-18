package org.example.repositories;

import org.example.entities.Account;
import org.example.entities.AccountTypeEnum;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AccountRepoImpl implements AccountRepo{
    private static AccountRepoImpl instance;

    private AccountRepoImpl (){};
    public static AccountRepoImpl getInstance(){
        if(instance == null){
            synchronized (UserRepoImpl.class){
                if(instance == null){
                    instance  = new AccountRepoImpl();
                }
            }
        }
        return instance;
    }
    Map<String,List<Account>>accountMap = new HashMap<>();
    @Override
    public List<Account> createAccount(String userId,Account account) {
        if(accountMap.containsKey(userId)){
            accountMap.get(userId).add(account);
        }
        else {
            List<Account> accounts = new ArrayList<>();
            accounts.add(account);
            accountMap.put(userId,accounts);
        }
        return accountMap.get(userId);
    }

    @Override
    public List<List<Account>> overview() {
        List<List<Account>> accounts =new ArrayList<>();
        for(String s:accountMap.keySet()){
            accounts.add(accountMap.get(s));
        }
        return accounts;
    }

    @Override
    public List<Account> userAccounts(String userId) {
        List<Account> accounts;
        accounts = accountMap.get(userId);
        return accounts;
    }

    @Override
    public Account getBasicAccount(String userId) {
        List<Account> accounts = accountMap.get(userId);
        Account account1 = new Account();
        for(Account account :accounts){
        if(account.getType()== AccountTypeEnum.BASIC){
               account1 =  account;
            }
        }
        return account1;
    }

    @Override
    public void addFunds(String userId, BigDecimal amount) {
        Account account = getBasicAccount(userId);
        account.setBalance(account.getBalance().add(amount));
    }

    @Override
    public void  removeFunds(String userId, BigDecimal amount) {
        Account account = getBasicAccount(userId);
        account.setBalance(account.getBalance().subtract(amount));
    }


}
