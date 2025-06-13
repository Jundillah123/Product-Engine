package com.example.Admin_Test.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "products_kripik", schema = "public")
public class ProductKripik {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 100)
    private String nama;

    @Column(nullable = false)
    private Integer harga;

    @Column(columnDefinition = "TEXT")
    private String deskripsi;

    @Column(length = 255)
    private String gambar;

    @Column(name = "created_at", columnDefinition = "timestamp default CURRENT_TIMESTAMP")
    private LocalDateTime createdAt;

    @Column(name = "updated_at", columnDefinition = "timestamp default CURRENT_TIMESTAMP")
    private LocalDateTime updatedAt;

}
