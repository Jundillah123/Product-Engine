package com.example.Admin_Test.Service;

import com.example.Admin_Test.Entity.ProductKripik;
import com.example.Admin_Test.Repository.ProductKripikRepository;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class ProductKripikService {
    private final ProductKripikRepository repository;

    public ProductKripikService(ProductKripikRepository repository) {
        this.repository = repository;
    }

    public List<ProductKripik> getAllProducts() {
        return repository.findAll();
    }
}
