package org.example.repositories;

import org.example.entities.User;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class UserRepoImpl implements UserRepo {
    private static UserRepoImpl instance;

    private UserRepoImpl(){};
    public static UserRepoImpl getInstance(){
        if(instance == null){
            synchronized (UserRepoImpl.class){
                if(instance == null){
                    instance  = new UserRepoImpl();
                }
            }
        }
        return instance;
    }
    Map<String,User> userMap = new HashMap<>();

    @Override
    public User save(User user) {
        return userMap.put(user.getId(),user);
    }

    @Override
    public User getById(String userId) {
        return userMap.get(userId);
    }
}
