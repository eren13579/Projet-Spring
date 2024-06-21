package com.iwomi.identification.repository;

import com.iwomi.identification.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    public User findByUsername(String username);

    public List<User> findUserByUsername(String username);
}
