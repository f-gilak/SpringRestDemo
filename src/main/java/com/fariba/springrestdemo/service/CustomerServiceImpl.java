package com.fariba.springrestdemo.service;

import com.fariba.springrestdemo.dao.CustomerDAO;
import com.fariba.springrestdemo.entity.Customer;
import com.fariba.springrestdemo.rest.CustomerNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerDAO customerDAO;

    @Override
    public List<Customer> getCustomers() {
        return customerDAO.getCustomers();
    }

    @Override
    public void saveCustomer(Customer customer) {
        customerDAO.saveCustomer(customer);
    }

    @Override
    public Customer getCustomer(long id) {
        Customer customer = customerDAO.getCustomer(id);
        if (customer == null) {
            throw new CustomerNotFoundException("Customer id not Found : " + id);
        }
        return customer;
    }

    @Override
    public void deleteCustomer(long id) {
        Customer customer = getCustomer(id);
        customerDAO.deleteCustomer(customer.getId());

    }

    @Override
    public List<Customer> searchCustomers(String searchName) {
        return customerDAO.searchCustomers(searchName);
    }
}
