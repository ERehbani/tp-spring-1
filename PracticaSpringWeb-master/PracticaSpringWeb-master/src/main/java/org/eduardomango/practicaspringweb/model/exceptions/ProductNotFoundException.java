package org.eduardomango.practicaspringweb.model.exceptions;

import java.util.NoSuchElementException;

public class ProductNotFoundException extends NoSuchElementException {

    public ProductNotFoundException(Long id) {
        super("Producto con ID " + id + " no fue encontrado");
    }

    public ProductNotFoundException(String message) {
        super(message);
    }

    public ProductNotFoundException() {
    }
}
