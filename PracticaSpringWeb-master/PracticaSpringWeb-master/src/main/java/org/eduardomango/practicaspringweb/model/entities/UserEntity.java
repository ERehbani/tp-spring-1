package org.eduardomango.practicaspringweb.model.entities;

import lombok.*;
import org.eduardomango.practicaspringweb.model.DTOs.User.UserDTO;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class UserEntity {

    private long id;
    private String username;
    private String email;
    private String password;
}
