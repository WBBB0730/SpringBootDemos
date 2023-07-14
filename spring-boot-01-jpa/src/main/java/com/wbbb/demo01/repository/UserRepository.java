package com.wbbb.demo01.repository;

import com.wbbb.demo01.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public interface UserRepository extends JpaRepository<User, BigInteger> {
    User findByUsernameAndPassword(String username, String password);
    boolean existsByUsername(String username);
}
