package org.example;

import org.example.entities.User;
import org.example.services.AccountServiceImpl;
import org.example.services.UserServiceImpl;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        WalletServiceFacade walletService = new WalletServiceFacade();
        System.out.println("Welcome to MyWallet ");
        Scanner sc = new Scanner(System.in);
        outer: while(true){
            System.out.println("\n OPTIONS:");
            System.out.println("1. REGISTER");
            System.out.println("2. USER INFO");
            System.out.println("3. CREATE ACCOUNT");
            System.out.println("4. ACCOUNTS INFO");
            System.out.println("5. ADD FUNDS");
            System.out.println("6. TRANSFER AMOUNT");
            System.out.println("7. ACCOUNT STATEMENT");
            System.out.println("8. OVERVIEW");
            System.out.println("9. EXIT");
            switch (sc.nextInt()){
                case 1:
                    System.out.println("Hey Welcome");
                    System.out.println("Enter your name: ");
                    String name = sc.next();
                    System.out.println("New user registered");
                    walletService.createUser(name);
                    break;
                case 2:
                    String username = sc.next();
                    System.out.println("User Info for:"+username);
                    walletService.getUserById(username);
                    break;
                case 3:
                    System.out.println("Create an account");
                    String userID = sc.next();
                    walletService.createAccount(userID);
                    break;
                case 4:
                    System.out.println("Account Information");
                    String userId = sc.next();
                    walletService.userAccounts(userId);
                    break;
                case 5:
                    System.out.println("Add Funds");
                    String userId1 = sc.next();
                    int amount = sc.nextInt();
                    walletService.addFunds(userId1,new BigDecimal(amount));
                    break;
                case 6:
                    System.out.println("Transfer Funds");
                    String userFRom = sc.next();
                    String userTo = sc.next();
                    int amount1 = sc.nextInt();
                    walletService.transferFund(userFRom,userTo,new BigDecimal(amount1));
                    break;
                case 7:
                    System.out.println("Account Statement");
                    String userFrom2 = sc.next();
                    walletService.accountStatement(userFrom2);
                    break;
                case 8:
                    System.out.println("OVERVIEW");
                    walletService.overview();
                    break;
                case 9:
                    System.out.println("APPLICATION STOPPED");
                    break outer;

                default:
                    System.out.println("YOU HAVE SELECTED INVALID OPTION. PLEASE REENTER");
                    break;
            }
        }
    }

}