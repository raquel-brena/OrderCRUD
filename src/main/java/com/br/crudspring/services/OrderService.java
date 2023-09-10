package com.br.crudspring.services;

import com.br.crudspring.entities.Order;
import com.br.crudspring.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    public OrderRepository repository;

    public List<Order> findAll (){
        return repository.findAll();
    }

    public Order findById (Long id){
        Optional <Order> obj = repository.findById(id);
        return obj.get();
    }
}
