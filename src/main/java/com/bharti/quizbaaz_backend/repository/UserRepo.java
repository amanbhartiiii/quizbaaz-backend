package com.bharti.quizbaaz_backend.repository;

import com.bharti.quizbaaz_backend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Integer> {
    User findByEmail(String email);
}
