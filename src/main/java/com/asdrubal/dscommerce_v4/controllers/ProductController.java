package com.asdrubal.dscommerce_v4.controllers;

import com.asdrubal.dscommerce_v4.dto.ProductDTO;
import com.asdrubal.dscommerce_v4.entities.Product;
import com.asdrubal.dscommerce_v4.repositories.ProductRepository;
import com.asdrubal.dscommerce_v4.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping(value = "/products")
public class ProductController {
    @Autowired
    private ProductService service;
    @GetMapping(value = "/{id}")
    public ProductDTO findById(@PathVariable Long id){
        ProductDTO dto = service.findById(id);
        return dto;
    }
}
