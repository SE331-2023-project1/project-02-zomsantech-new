package com.se331.zomsantech.security.user;

import jakarta.transaction.Transactional;

public interface UserService {
    User save(User user);



    User getUser(Long id);

    @Transactional
    User findByUsername(String username);
}