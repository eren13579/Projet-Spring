package com.iwomitech.identifierUsers.entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {
    public Users findUsersByUsername(String username);
    public Users findByUsername(String username);
}
