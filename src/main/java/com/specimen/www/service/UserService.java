package com.specimen.www.service;

import com.specimen.www.bean.User;


public interface UserService {
    User getUserByUsername(String username);

    boolean checkHasResign(String email);

    void insertUser(User user);
}
