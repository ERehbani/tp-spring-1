package org.eduardomango.practicaspringweb.model.controllers;

import org.eduardomango.practicaspringweb.model.entities.ProductEntity;
import org.eduardomango.practicaspringweb.model.entities.SaleEntity;
import org.eduardomango.practicaspringweb.model.exceptions.ProductNotFoundException;
import org.eduardomango.practicaspringweb.model.exceptions.SaleNotFoundException;
import org.eduardomango.practicaspringweb.model.repositories.ProductRepository;
import org.eduardomango.practicaspringweb.model.services.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }


    @GetMapping
    public ResponseEntity<List<ProductEntity>> getProducts() {
        return ResponseEntity.ok(productService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductEntity> getByID(@PathVariable Long id) {
            if(id <= 0) return ResponseEntity.badRequest().build();
            return ResponseEntity.ok(productService.findById(id));
    }

    @PostMapping
    public ResponseEntity<ProductEntity> save(@RequestBody ProductEntity newProduct) {
        if( newProduct == null ||
                newProduct.getName() == null || newProduct.getName().isBlank() ||
                newProduct.getDescription() == null || newProduct.getDescription().isBlank() ||
                newProduct.getPrice() <= 0 ||
                newProduct.getId() != 0){
            return ResponseEntity.badRequest().build();
        }
        productService.save(newProduct);
        return ResponseEntity.status(HttpStatus.CREATED).body(newProduct);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductEntity> update(@PathVariable int id, @RequestBody ProductEntity newProduct) {
        if(id <= 0 || newProduct.getId() != 0 || newProduct.getPrice() < 0){
            ResponseEntity.badRequest();
        };
        productService.update(newProduct, id);
        return ResponseEntity.ok(newProduct);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable int id) {
        if(id <= 0) return ResponseEntity.badRequest().body("El producto a eliminar no existe");
        ProductEntity product = productService.findById(id);
        productService.delete(product);
        return ResponseEntity.ok().body("Producto " + product.getName() + " eliminado correctamente");
    }


}
