package com.hlebik.crm.controler;

import com.hlebik.crm.dto.CustomerDto;
import com.hlebik.crm.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/customer")
@AllArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping("/list")
    public ResponseEntity<List<CustomerDto>> listCustomers() {
        return customerService.getCustomers();
    }

    @GetMapping("/showFormForAdd")
    public ResponseEntity<CustomerDto> showFormForAdd() {
        return ResponseEntity.ok(new CustomerDto());
    }

    @PostMapping("/saveCustomer")
    public void saveCustomer(@RequestParam final CustomerDto customerDto, @RequestParam final MultipartFile file) {
        customerService.saveCustomer(customerDto, file);
    }

    @GetMapping("/showFormForUpdate")
    public ResponseEntity<CustomerDto> showFormUpdate(@RequestParam("customerId") final long id) {
        return ResponseEntity.ok(customerService.getCustomer(id));
    }

    @GetMapping("/delete")
    public void deleteCustomer(@RequestParam("customerId") final long id) {
        customerService.deleteCustomer(id);
    }

    @GetMapping("/showMyHomePage")
    public ResponseEntity<CustomerDto> showMyHomePage(@RequestParam final Authentication authentication) {
        return customerService.findCustomerByUserName(authentication.getName());
    }
}