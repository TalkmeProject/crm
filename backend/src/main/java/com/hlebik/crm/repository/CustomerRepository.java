package com.hlebik.crm.repository;

import com.hlebik.crm.dbo.CustomerDbo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<CustomerDbo, Long> {

    Optional<CustomerDbo> findByUserDboUserName(String userName);
}
