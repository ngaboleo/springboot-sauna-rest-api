package com.springbootsauna.springbootsaunarestapi.customer.controller;

import com.springbootsauna.springbootsaunarestapi.customer.dto.CustomerDto;
import com.springbootsauna.springbootsaunarestapi.customer.service.ICustomerService;
import com.springbootsauna.springbootsaunarestapi.util.ResponseObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/customer")
public class CustomerController {
    @Autowired
    private ICustomerService iCustomerService;
    @PostMapping("create")
    public ResponseObject createCustomer(@RequestBody CustomerDto customerDto){
        try {
            return new ResponseObject(iCustomerService.createCustomer(customerDto));
        }catch (Exception exception){
            return new ResponseObject(exception);
        }
    }
}
