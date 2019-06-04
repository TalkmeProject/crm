package com.hlebik.crm.repository;

import com.hlebik.crm.dbo.UserDbo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserDbo, Long> {
    Optional<UserDbo> findByUserName(String username);
}
