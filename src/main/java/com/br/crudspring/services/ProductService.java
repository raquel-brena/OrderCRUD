package com.br.crudspring.services;

import com.br.crudspring.entities.Product;
import com.br.crudspring.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    public ProductRepository repository;

    public List<Product> findAll (){
        return repository.findAll();
    }

    public Product findById (Long id){
        Optional <Product> obj = repository.findById(id);
        return obj.get();
    }
}
