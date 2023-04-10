package com.springbootsauna.springbootsaunarestapi.customer.service;

import com.springbootsauna.springbootsaunarestapi.customer.dto.CustomerDto;
import com.springbootsauna.springbootsaunarestapi.customer.entity.Customer;
import com.springbootsauna.springbootsaunarestapi.util.PageUtil;
import com.springbootsauna.springbootsaunarestapi.util.ResponseObject;

import java.util.UUID;

public interface ICustomerService {
    ResponseObject createCustomer(CustomerDto customerDto);
    ResponseObject findAllCustomer(Integer pageNumber, Integer pageSize);
    ResponseObject updateCustomer(Customer customer);
//    ResponseObject findById(UUID id);
}
