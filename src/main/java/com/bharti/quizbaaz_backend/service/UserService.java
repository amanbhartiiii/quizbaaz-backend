package com.bharti.quizbaaz_backend.service;

import com.bharti.quizbaaz_backend.entity.User;

public interface UserService {
    User createUser(User user);
    User getUser(int id);
    User getUser(String email);
    Boolean validateUser(User user, User user2);

}
