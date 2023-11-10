package com.asdrubal.dscommerce_v4.controllers;

import com.asdrubal.dscommerce_v4.dto.ProductDTO;
import com.asdrubal.dscommerce_v4.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
//      Busca apresenta todos os itens do db
//    @GetMapping
//    public List<ProductDTO> findAll(){
//        return service.findAll();
//    }

    //  Busca páginada
    @GetMapping
    public Page<ProductDTO> findAll(Pageable pageable){
        return service.findAll(pageable);
    }
//      Inserindo um novo produto
    @PostMapping
    public ProductDTO insert(@RequestBody ProductDTO dto){
        dto = service.insert(dto);
        return dto;
    }
}





















