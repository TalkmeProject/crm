package com.hlebik.crm.repository;

import com.hlebik.crm.dbo.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
    User findByUserName(String username);
}
