package com.example.Admin_Test.Repository;

import com.example.Admin_Test.Entity.ProductKripik;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductKripikRepository extends JpaRepository<ProductKripik, Integer> {
}
