package com.bharti.quizbaaz_backend.service;

import com.bharti.quizbaaz_backend.dto.LoginRequest;
import com.bharti.quizbaaz_backend.entity.User;

public interface UserService {
    User createUser(User user);
    User getUser(int id);
    User getUser(String email);
    Boolean validateUser(LoginRequest loginRequest, User user);

}
