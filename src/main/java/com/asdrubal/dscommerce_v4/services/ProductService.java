package com.asdrubal.dscommerce_v4.services;

import com.asdrubal.dscommerce_v4.dto.ProductDTO;
import com.asdrubal.dscommerce_v4.entities.Product;
import com.asdrubal.dscommerce_v4.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository repository;

    @Transactional(readOnly = true)
    public ProductDTO findById(Long id) {
        Optional<Product> result = repository.findById(id);
        if (result.isPresent()) {
            Product product = result.get();
            ProductDTO dto = new ProductDTO(product);
            return dto;
        }
        return null;
    }

    //      Service para uma busca que retorna todos os elementos
//    @Transactional(readOnly = true)
//    public List<ProductDTO> findAll(){
//        List<Product> result = repository.findAll();
//        return result.stream().map(x->new ProductDTO(x)).toList();
//    }

    //      Service para uma busca paginada

    @Transactional(readOnly = true)
    public Page<ProductDTO> findAll(Pageable pageable) {
        Page<Product> result = repository.findAll(pageable);
        return result.map(x -> new ProductDTO(x));
    }

    //      Inserindo um novo produto
    @Transactional
    public ProductDTO insert(ProductDTO dto) {
        Product entity = new Product();
        entity.setName(dto.getName());
        entity.setDescription(dto.getDescription());
        entity.setPrice(dto.getPrice());
        entity.setImgUrl(dto.getImgUrl());

        entity = repository.save(entity);
        return new ProductDTO(entity);
    }
}










