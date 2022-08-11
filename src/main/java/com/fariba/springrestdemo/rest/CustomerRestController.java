package com.fariba.springrestdemo.rest;

import com.fariba.springrestdemo.entity.Customer;
import com.fariba.springrestdemo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CustomerRestController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/customers")
    public List<Customer> getCustomers() {
        return customerService.getCustomers();
    }

    @GetMapping("/customers/{customerId}")
    public Customer getCustomer(@PathVariable int customerId) {
        return customerService.getCustomer(customerId);
    }

    @PostMapping("/customers")
    public Customer addCustomer(@RequestBody Customer customer) {
        customerService.saveCustomer(customer);
        return customer;
    }

    @PutMapping("/customers")
    public Customer updateCustomer(@RequestBody Customer customer) {
        customerService.saveCustomer(customer);
        return customer;
    }

    @DeleteMapping("/customers/{id}")
    public String deleteCustomer(@PathVariable long id) {

        customerService.deleteCustomer(id);
        return "Deleted customer id: " + id;
    }
}
