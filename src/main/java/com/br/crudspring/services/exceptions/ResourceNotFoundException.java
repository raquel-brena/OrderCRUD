package com.br.crudspring.services.exceptions;

public class ResourceNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public ResourceNotFoundException(Object id) {
        super ("Resource NOT FOUND. id: " + id);
    }
}
