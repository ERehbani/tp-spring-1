package org.eduardomango.practicaspringweb.model.exceptions;

import java.util.NoSuchElementException;

public class UserNotFoundException extends NoSuchElementException {

    public UserNotFoundException(int id) {
        super("El usuario con ID " + id + " no fue encontrado");
    }

    public UserNotFoundException(String message) {
        super(message);
    }

    public UserNotFoundException() {
    }
}
