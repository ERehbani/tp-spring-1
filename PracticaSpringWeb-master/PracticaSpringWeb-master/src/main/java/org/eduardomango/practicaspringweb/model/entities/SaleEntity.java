package org.eduardomango.practicaspringweb.model.entities;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.eduardomango.practicaspringweb.model.DTOs.User.UserDTO;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class SaleEntity {
    private Long id;
    private ProductEntity products;
    private Long quantity;
    private UserDTO client;
    private LocalDate saleDate;
}
