package com.example.Admin_Test.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "inventory")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Inventory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "kode_barang")
    private String kodeBarang;

    @Column(name = "nama_barang")
    private String namaBarang;

    private String kategori;
    private String satuan;

    @Column(name = "stok_awal")
    private Integer stokAwal;

    @Column(name = "barang_masuk")
    private Integer barangMasuk;

    @Column(name = "barang_keluar")
    private Integer barangKeluar;

    @Column(name = "harga_satuan")
    private Integer hargaSatuan;

    @Column(name = "stok_akhir")
    private Integer stokAkhir;

    @Column(name = "nilai_persediaan")
    private Long nilaiPersediaan;

    // Getter & Setter
}
