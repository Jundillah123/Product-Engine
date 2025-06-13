package com.example.Admin_Test.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "transaction_product")
@Data
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "kode_transaksi", nullable = false, unique = true)
    private String kodeTransaksi;

    @Column(nullable = false)
    private Integer total;

    @Column
    private String status;

    @Column
    private LocalDateTime tanggal = LocalDateTime.now();

    @OneToMany(mappedBy = "transaction", cascade = CascadeType.ALL)
    private List<TransactionItem> items;


}
