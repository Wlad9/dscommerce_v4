package com.asdrubal.dscommerce_v4.repositories;

import com.asdrubal.dscommerce_v4.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
