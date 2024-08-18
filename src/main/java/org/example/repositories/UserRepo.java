package org.example.repositories;

import org.example.entities.Account;
import org.example.entities.User;

import java.util.List;
import java.util.Optional;

public interface UserRepo {
    User save(User user);
    User getById(String userId);

}
