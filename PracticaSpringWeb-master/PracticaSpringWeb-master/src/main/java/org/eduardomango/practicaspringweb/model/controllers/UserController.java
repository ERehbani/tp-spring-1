package org.eduardomango.practicaspringweb.model.controllers;


import org.apache.coyote.Response;
import org.eduardomango.practicaspringweb.model.DTOs.User.UserCreate;
import org.eduardomango.practicaspringweb.model.DTOs.User.UserDTO;
import org.eduardomango.practicaspringweb.model.entities.SaleEntity;
import org.eduardomango.practicaspringweb.model.entities.UserEntity;
import org.eduardomango.practicaspringweb.model.repositories.UserRepository;
import org.eduardomango.practicaspringweb.model.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")

public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<UserDTO> findAll() {
        return userService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable int id) {
        UserDTO user = userService.findById(id);
        if(user != null) return ResponseEntity.ok(user);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }


    @PostMapping
    public ResponseEntity<UserDTO> save(@Validated(UserCreate.class) @RequestBody UserDTO newUser){

        userService.save(newUser);
        return ResponseEntity.status(HttpStatus.CREATED).body(newUser);
    }

    @PutMapping("/{id}")
    public String edit(@RequestBody UserDTO newUser, @PathVariable int id) {

        userService.update(newUser, id);
        return "Usuario " + id + " actualizado";
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable int id) {
        UserDTO userToDelete = userService.findById(id);
        if(userToDelete == null)  return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        userService.delete(userToDelete);
        return ResponseEntity.ok("Usuario eliminado correctamente");

    }


}