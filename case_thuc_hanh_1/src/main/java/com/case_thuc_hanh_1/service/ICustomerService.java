package com.case_thuc_hanh_1.service;

import com.case_thuc_hanh_1.model.Customer;

import java.util.Optional;

public interface ICustomerService {
    Iterable<Customer> getAllCustomer();
    Optional<Customer> getCustomerById(Long id);
    void saveCustomer(Customer customer);
    void deleteCustomer(Long id);
}
