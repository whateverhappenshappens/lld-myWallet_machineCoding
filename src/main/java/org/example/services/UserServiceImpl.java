package org.example.services;

import org.example.entities.Transaction;
import org.example.entities.User;
import org.example.repositories.UserRepo;
import org.example.repositories.UserRepoImpl;

import java.util.Optional;

public class UserServiceImpl implements UserService{
    UserRepoImpl userRepo = UserRepoImpl.getInstance();


    @Override
    public void createUser(String name) {

       String userId = Integer.toString( User.generatedId++);

      User user = User.builder()
              .id(userId)
              .createdAt(String.valueOf(System.currentTimeMillis()))
              .name(name)
              .build();
      userRepo.save(user);
        System.out.println("Created User Details: ");
        System.out.println(user);
    }

    @Override
    public void getUserById(String userId) {
        User user = userRepo.getById(userId);
        System.out.println("User Details: ");
        System.out.println(user);
    }
}
