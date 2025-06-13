package com.example.Admin_Test.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "transaction_item_product")
@Data
public class TransactionItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "transaction_id")
    private Transaction transaction;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    private Integer qty;
    private Integer hargaSatuan;
    private Integer subtotal;

    // Getters & Setters
}
