package com.springbootsauna.springbootsaunarestapi.product_category.entity;

import com.springbootsauna.springbootsaunarestapi.product.entity.Product;
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
@Table(name = "product_category")
public class ProductCategory {
    @Id
    @GeneratedValue
    private UUID id;
    private String productCategory;
    @OneToMany(mappedBy = "productCategory")
    private List<Product> products;
}
