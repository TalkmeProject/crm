package com.hlebik.crm.repository;

import com.hlebik.crm.dbo.UserDbo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserDbo, Long> {
    UserDbo findByUserName(String username);
}
