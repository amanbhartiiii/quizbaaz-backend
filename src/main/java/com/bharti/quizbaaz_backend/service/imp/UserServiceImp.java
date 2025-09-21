package com.bharti.quizbaaz_backend.service.imp;

import com.bharti.quizbaaz_backend.entity.User;
import com.bharti.quizbaaz_backend.repository.UserRepo;
import com.bharti.quizbaaz_backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImp implements UserService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public User createUser(User user) {
        return userRepo.save(user);
    }

    @Override
    public User getUser(int id) {
        return null;
    }

    @Override
    public User getUser(String email) {
        return userRepo.findByEmail(email);
    }

    @Override
    public Boolean validateUser(User user, User dbUser) {
        return user.getPassword().equals(dbUser.getPassword());
    }
}
