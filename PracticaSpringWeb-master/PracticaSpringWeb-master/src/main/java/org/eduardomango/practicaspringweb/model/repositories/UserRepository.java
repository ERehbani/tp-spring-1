package org.eduardomango.practicaspringweb.model.repositories;

import org.eduardomango.practicaspringweb.model.DTOs.User.UserDTO;
import org.eduardomango.practicaspringweb.model.entities.UserEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserRepository implements IRepository<UserDTO> {

    private List<UserDTO> users;

    public UserRepository() {
        this.users = new ArrayList<>();

        users.add(new UserDTO(1, "alice", "alice@example.com", "password1"));
        users.add(new UserDTO(2, "bob", "bob@example.com", "password2"));
        users.add(new UserDTO(3, "charlie", "charlie@example.com", "password3"));
        users.add(new UserDTO(4, "diana", "diana@example.com", "password4"));
        users.add(new UserDTO(5, "edgar", "edgar@example.com", "password5"));
        users.add(new UserDTO(6, "frank", "frank@example.com", "password6"));
        users.add(new UserDTO(7, "grace", "grace@example.com", "password7"));
        users.add(new UserDTO(8, "hannah", "hannah@example.com", "password8"));
        users.add(new UserDTO(9, "ian", "ian@example.com", "password9"));
        users.add(new UserDTO(10, "julia", "julia@example.com", "password10"));
        users.add(new UserDTO(11, "kyle", "kyle@example.com", "password11"));
        users.add(new UserDTO(12, "laura", "laura@example.com", "password12"));
        users.add(new UserDTO(13, "michael", "michael@example.com", "password13"));
        users.add(new UserDTO(14, "nina", "nina@example.com", "password14"));
        users.add(new UserDTO(15, "oscar", "oscar@example.com", "password15"));
        users.add(new UserDTO(16, "paula", "paula@example.com", "password16"));
        users.add(new UserDTO(17, "quentin", "quentin@example.com", "password17"));
        users.add(new UserDTO(18, "rachel", "rachel@example.com", "password18"));
        users.add(new UserDTO(19, "sam", "sam@example.com", "password19"));
        users.add(new UserDTO(20, "tina", "tina@example.com", "password20"));
    }

    public List<UserDTO> findAll() {
        return List.copyOf(users);
    }

    public void save(UserDTO user) {
        users.add(user);
    }

    @Override
    public void delete(UserDTO entity) {

    }

    @Override
    public void update(UserDTO entity, UserDTO id) {

    }

    public void delete(UserEntity user) {
        users.remove(user);
    }

    public void update(UserEntity user, UserEntity existingUser) {

//        user.setId(existingUser.getId());
        existingUser.setPassword(user.getPassword());
        existingUser.setEmail(user.getEmail());
        existingUser.setUsername(user.getUsername());

//        users.set(user);
    }
}
