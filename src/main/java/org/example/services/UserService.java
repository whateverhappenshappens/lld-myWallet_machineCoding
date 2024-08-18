package org.example.services;

import org.example.entities.Account;
import org.example.entities.User;

import java.util.List;

public interface UserService {

    void createUser(String name);
    void getUserById(String userId);
}
