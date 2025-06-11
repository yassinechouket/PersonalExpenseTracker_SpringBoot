package com.chouket370.personal_expense_tracker;

import com.chouket370.personal_expense_tracker.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByname(String name);
    Optional<User> findByEmail(String email);
    boolean existsByname(String name);
    boolean existsByEmail(String email);
}
