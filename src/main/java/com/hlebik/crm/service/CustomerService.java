package com.hlebik.crm.service;

import com.hlebik.crm.converter.CustomerConverter;
import com.hlebik.crm.dbo.CustomerDbo;
import com.hlebik.crm.dto.CustomerDto;
import com.hlebik.crm.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final CustomerConverter customerConverter;

    public List<CustomerDto> getCustomers() {
        List<CustomerDbo> customerDbos = customerRepository.findAll(Sort.by("lastName"));
        return customerConverter.convertToDto(customerDbos);
    }

    public void saveCustomer(CustomerDto customerDto) {
        CustomerDbo customerDbo = customerConverter.convertToDbo(customerDto);
        customerRepository.save(customerDbo);
    }

    public CustomerDto getCustomer(Long id) {
        Optional<CustomerDbo> customerDbo = customerRepository.findById(id);
        if (customerDbo.isPresent()) {
            return customerConverter.convertToDto(customerDbo.get());
        }
        return new CustomerDto();
    }

    public void deleteCustomer(long id) {
        customerRepository.deleteById(id);
    }
}
