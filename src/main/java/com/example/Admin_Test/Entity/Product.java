package com.example.Admin_Test.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String kode;
    private String nama;
    private String kategori;
    private String satuan;
    private int stok;
    private int harga;
}
