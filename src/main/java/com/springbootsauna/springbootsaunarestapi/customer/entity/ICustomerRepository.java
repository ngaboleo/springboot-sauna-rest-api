package com.springbootsauna.springbootsaunarestapi.customer.entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface ICustomerRepository extends JpaRepository<Customer, UUID> {
}
