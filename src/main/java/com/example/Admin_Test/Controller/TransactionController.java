package com.example.Admin_Test.Controller;

import com.example.Admin_Test.Entity.Transaction;
import com.example.Admin_Test.Service.TransactionService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transactions")
@Data
public class TransactionController {
    @Autowired
    private TransactionService transactionService;

    @PostMapping
    public ResponseEntity<Transaction> createTransaction(@RequestBody Transaction transaction) {
        Transaction saved = transactionService.createTransaction(transaction);
        return ResponseEntity.ok(saved);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Transaction> getTransactionById(@PathVariable Long id) {
        Transaction transaction = transactionService.getById(id);
        if (transaction == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(transaction);
    }


    @PatchMapping("/{id}/status")
    public ResponseEntity<Transaction> updateStatus(@PathVariable Long id, @RequestParam String status) {
        try {
            Transaction updated = transactionService.updateStatus(id, status);
            return ResponseEntity.ok(updated);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<Page<Transaction>> getTransactions(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {

        Page<Transaction> result = transactionService.getAllTransactions(page, size);
        return ResponseEntity.ok(result);
    }

//    @GetMapping("/total-penjualan-hari-ini")
//    public ResponseEntity<Integer> getTotalPenjualanHariIni() {
//        int total = transactionService.getTotalPenjualanHariIni();
//        return ResponseEntity.ok(total);
//    }


}
