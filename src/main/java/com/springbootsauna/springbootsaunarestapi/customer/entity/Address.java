package com.springbootsauna.springbootsaunarestapi.customer.entity;

import jakarta.persistence.Embeddable;

@Embeddable
public class Address {
    private String province;
    private String district;
    private String sector;
    private String cell;

}
