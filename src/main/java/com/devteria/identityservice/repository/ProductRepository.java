package com.devteria.identityservice.repository;

import com.devteria.identityservice.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository <Product,Long> {

}
