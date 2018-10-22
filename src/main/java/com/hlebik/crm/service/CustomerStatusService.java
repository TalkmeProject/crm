package com.hlebik.crm.service;

import com.hlebik.crm.dbo.CustomerStatusDbo;
import com.hlebik.crm.repository.CustomerStatusRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomerStatusService {

    private final CustomerStatusRepository customerStatusRepository;

    public CustomerStatusDbo getStatus(CustomerStatusDbo customerStatusDbo) {

        return customerStatusRepository.findByStatus(customerStatusDbo.getStatus());
    }
}
