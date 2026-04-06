package org.eduardomango.practicaspringweb.model.entities;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class SaleBody {

    public int idClient;
    public int idProduct;
    public int quantity;
}
