package com.example.springsecuritych6.repository;

import com.example.springsecuritych6.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer > {
}
