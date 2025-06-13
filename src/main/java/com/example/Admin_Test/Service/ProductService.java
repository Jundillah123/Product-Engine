package com.example.Admin_Test.Service;

import com.example.Admin_Test.Entity.Product;
import com.example.Admin_Test.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAll(){
        return productRepository.findAll();
    }

    public Product getByKode(Long id){
        return productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product Tidak DiTemnukan"));
    }

    public Product createProduct (Product product){
        return productRepository.save(product);
    }

    public Product update(Long id, Product productDetails){
       Product product = getByKode(id);

//        product.setKode(productDetails.getKode());
//        product.setNama(productDetails.getNama());
//        product.setKategori(productDetails.getKategori());
//        product.setSatuan(productDetails.getSatuan());
//        product.setStok(productDetails.getStok());
//        product.setHarga(productDetails.getHarga());

        return productRepository.save(product);
    }

    public void delete(Long id){
        Product product = getByKode(id);
        productRepository.delete(product);
    }
}
