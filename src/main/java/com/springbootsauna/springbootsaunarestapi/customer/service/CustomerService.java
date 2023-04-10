package com.springbootsauna.springbootsaunarestapi.customer.service;

import com.springbootsauna.springbootsaunarestapi.appointment.entity.Appointment;
import com.springbootsauna.springbootsaunarestapi.customer.dto.CustomerDto;
import com.springbootsauna.springbootsaunarestapi.customer.entity.Customer;
import com.springbootsauna.springbootsaunarestapi.customer.entity.ICustomerRepository;
import com.springbootsauna.springbootsaunarestapi.user.entity.User;
import com.springbootsauna.springbootsaunarestapi.util.PageUtil;
import com.springbootsauna.springbootsaunarestapi.util.ResponseObject;
import jakarta.transaction.Transactional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
public class CustomerService implements ICustomerService{

    @Autowired
    private ICustomerRepository iCustomerRepository;

    private User user;

    @Override
    public ResponseObject createCustomer(CustomerDto customerDto) {
        try {
            Customer customer = new Customer();
            BeanUtils.copyProperties(customerDto, customer);
            customer.setUser_id(user.getId());
            return new ResponseObject(iCustomerRepository.save(customer));
        }catch (Exception exception){
            return new ResponseObject(exception);
        }
    }

    @Override
    public ResponseObject findAllCustomer(Integer pageNumber, Integer pageSize) {

        try {
            return new ResponseObject(iCustomerRepository.findAll(PageUtil.getPageable(pageNumber,pageSize)));
        }catch (Exception exception){
            return new ResponseObject(exception);
        }
    }

    @Override
    public ResponseObject updateCustomer(Customer customer) {
        try {
            return new ResponseObject(iCustomerRepository.save(customer));
        }catch (Exception exception){
            return new ResponseObject(exception);
        }
    }

//    @Override
//    public ResponseObject findById(UUID id) {
//        try {
//            Optional<Customer> optionalCustomer = iCustomerRepository.findById(id);
//            if (optionalCustomer.isPresent()){
//                return new ResponseObject(optionalCustomer.get());
//            }else {
//                return new ResponseObject("customer not found");
//            }
//        }catch (Exception exception){
//            return new ResponseObject(exception);
//        }
//    }
}
