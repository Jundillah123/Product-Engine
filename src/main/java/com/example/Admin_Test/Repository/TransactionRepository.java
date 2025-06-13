package com.example.Admin_Test.Repository;

import com.example.Admin_Test.Entity.Transaction;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    Page<Transaction> findAll(Pageable pageable);


    List<Transaction> findByTanggalBetweenAndStatus(LocalDateTime start, LocalDateTime end, String status);
}
