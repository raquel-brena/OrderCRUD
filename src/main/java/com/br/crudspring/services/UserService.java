package com.br.crudspring.services;

import com.br.crudspring.entities.User;
import com.br.crudspring.repositories.UserRepository;
import com.br.crudspring.services.exceptions.DatabaseException;
import com.br.crudspring.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    public UserRepository repository;

    public List<User> findAll (){
        return repository.findAll();
    }

    public User findById (Long id){
        Optional <User> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public User insert (User user){
        return repository.save(user);
    }

    public void delete (Long id){
        try {
            repository.deleteById(id);
        } catch (EmptyResultDataAccessException e ){
            throw new ResourceNotFoundException(id);
        }catch (RuntimeException e ){
            throw new DatabaseException(e.getMessage());
        }

    }

    public User update (Long id, User user){
        User entity = repository.getReferenceById(id);
        updateData(entity, user);
        return repository.save(entity);
    }

    private void updateData(User entity, User user) {
        entity.setName(user.getName());
        entity.setEmail(user.getEmail());
        entity.setPhone(user.getPhone());
    }
}
