package com.se331.zomsantech.security.user;

public interface UserDao {
    User findByUsername(String username);

    User save(User user);
}