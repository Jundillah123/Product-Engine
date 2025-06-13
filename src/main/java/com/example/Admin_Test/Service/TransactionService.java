package com.example.Admin_Test.Service;

import com.example.Admin_Test.Entity.Transaction;
import com.example.Admin_Test.Repository.TransactionRepository;
import jakarta.transaction.Transactional;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
@Data
public class TransactionService {
    @Autowired
    private TransactionRepository transactionRepository;


    @Transactional
    public Transaction createTransaction (Transaction transaction) {
//        if (transaction.getItems() != null ){
//            transaction.getItems().forEach(item -> item.setTransaction(transaction));
//        }
        return transactionRepository.save(transaction);
    }

    public Transaction getById (Long id) {
        return transactionRepository.findById(id).orElse(null);
    }

    @Transactional
    public Transaction updateStatus(Long id, String status) {
        Transaction trx = transactionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Transaction not found id=" + id));
//        trx.setStatus(status);
        return transactionRepository.save(trx);
    }

    public Page<Transaction> getAllTransactions(int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("tanggal").descending());
        return transactionRepository.findAll(pageable);
    }

//    public int getTotalPenjualanHariIni() {
//        LocalDateTime startOfDay = LocalDate.now().atStartOfDay();
//        LocalDateTime endOfDay = startOfDay.plusDays(1);
//
//        List<Transaction> todayTransactions = transactionRepository.findByTanggalBetweenAndStatus(startOfDay, endOfDay, "PAID");
//
//        return todayTransactions.stream()
//                .mapToInt(Transaction::getTotal)
//                .sum();
//    }

}
