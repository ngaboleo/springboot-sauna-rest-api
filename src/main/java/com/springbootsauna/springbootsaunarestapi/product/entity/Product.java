package com.springbootsauna.springbootsaunarestapi.product.entity;

import com.springbootsauna.springbootsaunarestapi.appointment.entity.Appointment;
import com.springbootsauna.springbootsaunarestapi.product_category.entity.ProductCategory;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue
    private UUID id;
    private String productName;
    private double priceOfProduct;
    @ManyToMany(mappedBy = "products")
    private List<Appointment> appointments;
    @ManyToOne
    @JoinColumn(name = "product_category_id")
    private ProductCategory productCategory;
}
