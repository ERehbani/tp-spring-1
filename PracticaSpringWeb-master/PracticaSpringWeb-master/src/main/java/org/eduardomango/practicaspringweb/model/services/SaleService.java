package org.eduardomango.practicaspringweb.model.services;
import org.eduardomango.practicaspringweb.model.DTOs.User.UserDTO;
import org.eduardomango.practicaspringweb.model.entities.ProductEntity;
import org.eduardomango.practicaspringweb.model.entities.SaleEntity;
import org.eduardomango.practicaspringweb.model.entities.UserEntity;
import org.eduardomango.practicaspringweb.model.exceptions.SaleNotFoundException;
import org.eduardomango.practicaspringweb.model.repositories.IRepository;
import org.eduardomango.practicaspringweb.model.repositories.SaleRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;
import java.util.UUID;


@Service
public class SaleService {
    private final SaleRepository saleRepository;
    private final ProductService productService;
    private final UserService userService;

    public SaleService(SaleRepository saleRepository1, ProductService productService, UserService userService) {
        this.saleRepository = saleRepository1;
        this.productService = productService;
        this.userService = userService;
    }

    public List<SaleEntity> findAll() {
        return saleRepository.findAll();
    }

    public SaleEntity findById(int idSale) {
        return saleRepository.findAll()
                .stream()
                .filter(s -> s.getId() == idSale)
                .findFirst()
                .orElseThrow(SaleNotFoundException::new);
    }


    public SaleEntity registerSale (int idCliente, int idProducto, int quantity){
        ProductEntity product = productService.findById(idProducto);
        UserDTO user = userService.findById(idCliente);

        SaleEntity sale = SaleEntity.builder()
                .id(System.currentTimeMillis())
                .products(product)
                .client(user)
                .quantity((long) quantity)
                .saleDate(LocalDate.now())
                .build();

        saleRepository.save(sale);
        return sale;
    }

    public void deleteSale(int idSale) {
        SaleEntity sale = findById(idSale);
        saleRepository.delete(sale);
    }

    public void setSale(SaleEntity newSale, SaleEntity id) {
//        SaleEntity sale = findById(id);
  //      saleRepository.update(newSale, id);
    }


}
