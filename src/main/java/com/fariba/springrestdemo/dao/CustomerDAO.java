package com.fariba.springrestdemo.dao;

import com.fariba.springrestdemo.entity.Customer;

import java.util.List;

public interface CustomerDAO {

    public List<Customer> getCustomers();

    void saveCustomer(Customer customer);

    Customer getCustomer(long id);

    void deleteCustomer(long id);

    List<Customer> searchCustomers(String searchName);
}
