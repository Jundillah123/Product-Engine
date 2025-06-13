package com.example.Admin_Test.Repository;

import com.example.Admin_Test.Entity.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory, String> {
    Optional<Inventory> findByKodeBarang(String kodeBarang);
}
