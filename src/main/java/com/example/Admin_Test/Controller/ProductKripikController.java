package com.example.Admin_Test.Controller;

import com.example.Admin_Test.Entity.ProductKripik;
import com.example.Admin_Test.Service.ProductKripikService;
import lombok.Data;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/products-kripik")
@Data
public class ProductKripikController {


    private final ProductKripikService service;

    public ProductKripikController(ProductKripikService service) {
        this.service = service;
    }

    @GetMapping("/all")
    public List<ProductKripik> getAllProducts() {
        return service.getAllProducts();
    }
}
