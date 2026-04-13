package org.eduardomango.practicaspringweb.model.DTOs.User;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.*;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class UserDTO {

    @NotNull(groups = UserUpdate.class)
    private int id;

    @NotBlank(groups = {UserUpdate.class, UserCreate.class},
            message = "Username is required for user")
    @Length(min = 6, max = 13, message = "Username must be at least 6 characters and maximum of 13")
    private String username;

    @NotBlank(groups = {UserUpdate.class, UserCreate.class},
            message = "Email is required for user")
    @Email(message = "Email format is not valid",
    regexp = "^((?!\\.)[\\w\\-_.]*[^.])(@\\w+)(\\.\\w+(\\.\\w+)?[^.\\W])$")
    @Length(min = 10, max = 30, message = "Email must be at least 10 characters and maximum of 32")
    private String email;

    @NotBlank(groups = {UserUpdate.class, UserCreate.class},
            message = "Password is required for user")
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&._-])[A-Za-z\\d@$!%*?&._-]{8,}$",
    message = "Password must have at least 8 characters, one uppercase, one lowercase, one number and one special character")
    private String password;


}
