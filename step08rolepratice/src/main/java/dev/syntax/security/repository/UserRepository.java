package dev.syntax.security.repository;

import dev.syntax.security.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users, Integer> {
    Users findUserByUserName(String userName);
}
