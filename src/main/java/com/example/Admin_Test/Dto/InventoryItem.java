package com.example.Admin_Test.Dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class InventoryItem {
    private String kodeBarang;
    private String namaBarang;
    private String kategori;
    private String satuan;
    private int stokAwal;
    private int barangMasuk;
    private int barangKeluar;
    private int hargaSatuan;
    private int stokAkhir;
    private int nilaiPersediaan;
}
