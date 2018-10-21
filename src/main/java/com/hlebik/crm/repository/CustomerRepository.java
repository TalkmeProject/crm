package com.hlebik.crm.repository;

import com.hlebik.crm.dbo.CustomerDbo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<CustomerDbo, Long> {

}
