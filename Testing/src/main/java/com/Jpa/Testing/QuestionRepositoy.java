package com.Jpa.Testing;

import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepositoy extends JpaRepository<Question, Long> {
}
