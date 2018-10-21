package com.hlebik.crm.repository;

import com.hlebik.crm.dbo.CustomerStatusDbo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerStatusRepository extends JpaRepository<CustomerStatusDbo, Long> {
}
