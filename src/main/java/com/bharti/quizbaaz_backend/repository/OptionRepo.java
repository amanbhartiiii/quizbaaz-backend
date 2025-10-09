package com.bharti.quizbaaz_backend.repository;

import com.bharti.quizbaaz_backend.entity.Option;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OptionRepo extends JpaRepository<Option, Long> {
}
