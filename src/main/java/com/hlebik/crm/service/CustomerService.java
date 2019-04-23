package com.hlebik.crm.service;

import com.hlebik.crm.converter.CustomerConverter;
import com.hlebik.crm.converter.UserConverter;
import com.hlebik.crm.dbo.CustomerDbo;
import com.hlebik.crm.dbo.CustomerStatusDbo;
import com.hlebik.crm.dbo.UserDbo;
import com.hlebik.crm.dto.CustomerDto;
import com.hlebik.crm.repository.CustomerRepository;
import com.hlebik.crm.repository.UserRepository;
import com.hlebik.crm.storage.StorageService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotNull;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final CustomerConverter customerConverter;
    private final CustomerStatusService customerStatusService;
    private final StorageService storageService;
    private final UserRepository userRepository;
    private final UserConverter userConverter;

    public ResponseEntity<List<CustomerDto>> getCustomers() {
        List<CustomerDbo> customerDboList = customerRepository.findAll(Sort.by("lastName"));
        return ResponseEntity.ok(customerConverter.convertToDto(customerDboList));
    }

    public void saveCustomer(final CustomerDto customerDto, final MultipartFile file) {
        try {
            if (file.getInputStream().available() > 0) {
                String MainImageName = storageService.store(file);
                customerDto.setMainImage(MainImageName);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        customerDto.setUserDto(userConverter.convertToDto(userRepository.findById(customerDto.getId()).orElse(new UserDbo())));
        CustomerDbo customerDbo = customerConverter.convertToDbo(customerDto);
        CustomerStatusDbo customerStatusDbo = customerStatusService.getStatus(customerDbo.getCustomerStatusDbo());
        customerDbo.setCustomerStatusDbo(customerStatusDbo);
        customerRepository.save(customerDbo);
    }

    public CustomerDto getCustomer(final long id) {
        Optional<CustomerDbo> customerDbo = customerRepository.findById(id);
        if (customerDbo.isPresent()) {
            return customerConverter.convertToDto(customerDbo.get());
        }
        return new CustomerDto();
    }

    public void deleteCustomer(final long id) {
        customerRepository.deleteById(id);
    }

    public ResponseEntity<CustomerDto> findCustomerByUserName(@NotNull final String name) {
        Optional<CustomerDbo> customerDbo = customerRepository.findByUserDboUserName(name);
        return customerDbo.map(dbo -> new ResponseEntity<>(customerConverter.convertToDto(dbo), HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(new CustomerDto(), HttpStatus.NOT_FOUND));
    }
}
