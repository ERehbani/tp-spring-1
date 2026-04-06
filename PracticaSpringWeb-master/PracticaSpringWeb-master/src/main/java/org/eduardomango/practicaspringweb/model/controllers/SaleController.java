package org.eduardomango.practicaspringweb.model.controllers;

import org.eduardomango.practicaspringweb.model.entities.SaleBody;
import org.eduardomango.practicaspringweb.model.entities.SaleEntity;
import org.eduardomango.practicaspringweb.model.exceptions.SaleNotFoundException;
import org.eduardomango.practicaspringweb.model.repositories.ProductRepository;
import org.eduardomango.practicaspringweb.model.repositories.SaleRepository;
import org.eduardomango.practicaspringweb.model.repositories.UserRepository;
import org.eduardomango.practicaspringweb.model.services.ProductService;
import org.eduardomango.practicaspringweb.model.services.SaleService;
import org.eduardomango.practicaspringweb.model.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sales")
public class SaleController {
    private final SaleService saleService;

    public SaleController(SaleService saleService) {
        this.saleService = saleService;
    }

    @GetMapping
    public ResponseEntity<List<SaleEntity>> getSales(){
        return ResponseEntity.ok(saleService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<SaleEntity> getByID(@PathVariable int id){
       try {
           if(id <= 0) return ResponseEntity.badRequest().build();
           return ResponseEntity.ok(saleService.findById(id));
       } catch (SaleNotFoundException e) {
           return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

       }
    }

    @PostMapping
    public ResponseEntity<SaleEntity> save(@RequestBody SaleBody newSale) {
        if(newSale.getIdClient() <= 0 || newSale.getQuantity() <= 0 || newSale.getIdProduct() <= 0) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(saleService.registerSale(newSale.getIdClient(), newSale.getIdProduct(), newSale.getQuantity()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable int id) {
        if(id <= 0) return ResponseEntity.badRequest().build();
        saleService.deleteSale(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Eliminado correctamente");
    }
}
