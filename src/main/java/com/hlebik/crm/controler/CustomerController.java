package com.hlebik.crm.controler;

import com.hlebik.crm.dto.CustomerDto;
import com.hlebik.crm.enumerated.Status;
import com.hlebik.crm.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
@RequestMapping("/customer")
@AllArgsConstructor
public class CustomerController {

    private final CustomerService customerService;


    @GetMapping("/list")
    public String listCustomers(Model model) {
        List<CustomerDto> customersList = customerService.getCustomers();
        model.addAttribute("customers", customersList);
        return "list-customers";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model model) {
        CustomerDto customerDto = new CustomerDto();
        model.addAttribute("customer", customerDto);
        model.addAttribute("status", Status.values());
        return "customer-form";
    }

    @PostMapping("/saveCustomer")
    public String saveCustomer(@ModelAttribute("customer") CustomerDto customerDto, @RequestParam("file") MultipartFile file) {
        customerService.saveCustomer(customerDto, file);
        return "redirect:/customer/list";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormUpdate(@RequestParam("customerId") long id, Model model) {
        CustomerDto customerDto = customerService.getCustomer(id);
        model.addAttribute("customer", customerDto);
        return "customer-form";
    }

    @GetMapping("/delete")
    public String deleteCustomer(@RequestParam("customerId") long id, Model model) {
        customerService.deleteCustomer(id);
        return "redirect:/customer/list";
    }
}