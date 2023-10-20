package com.asdrubal.dscommerce_v4.services;

import com.asdrubal.dscommerce_v4.dto.ProductDTO;
import com.asdrubal.dscommerce_v4.entities.Product;
import com.asdrubal.dscommerce_v4.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository repository;
    @Transactional(readOnly = true)
    public ProductDTO findById(Long id){
        Optional<Product> result = repository.findById(id);
        Product product = result.get();
        ProductDTO dto = new ProductDTO(product);
        return dto;
    }

}