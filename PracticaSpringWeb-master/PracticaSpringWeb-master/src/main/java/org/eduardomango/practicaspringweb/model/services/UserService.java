package org.eduardomango.practicaspringweb.model.services;


import org.eduardomango.practicaspringweb.model.DTOs.User.UserDTO;
import org.eduardomango.practicaspringweb.model.entities.UserEntity;
import org.eduardomango.practicaspringweb.model.exceptions.ProductNotFoundException;
import org.eduardomango.practicaspringweb.model.exceptions.UserNotFoundException;
import org.eduardomango.practicaspringweb.model.repositories.IRepository;
import org.eduardomango.practicaspringweb.model.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {

        this.userRepository = userRepository;
    }

    public List<UserDTO> findAll() {
        return userRepository.findAll();
    }
    public UserDTO findById(int id) {
        return userRepository.findAll()
                .stream()
                .filter(user -> user.getId() == id)
                .findFirst()
                .orElseThrow(() -> new UserNotFoundException(id));
    }

    public UserDTO findByUsername(String username){
        return userRepository.findAll()
                .stream()
                .filter(user -> user.getUsername().equalsIgnoreCase(username))
                .findFirst()
                .orElseThrow(UserNotFoundException::new);
    }

    public UserDTO findByEmail(String email){
        return userRepository.findAll()
                .stream()
                .filter(user -> user.getEmail().equalsIgnoreCase(email))
                .findFirst()
                .orElseThrow(UserNotFoundException::new);
    }

    public void save(UserDTO user) {
        userRepository.save(user);
    }

    public void delete(UserDTO user) {
        userRepository.delete(user);
    }

    public void update(UserDTO user, int id) {
        UserDTO existingUser = findById(id);
        if(existingUser != null)
            userRepository.update(user, existingUser);
        throw new UserNotFoundException("El usuario no existe en la bdd");

    }
}
