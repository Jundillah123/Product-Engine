package com.example.Admin_Test.Controller;

import com.example.Admin_Test.Dto.ResponseWrapper;
import com.example.Admin_Test.Entity.Inventory;
import com.example.Admin_Test.Helper.ExcelHelper;
import com.example.Admin_Test.Repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ExcelUploadController {

    @Autowired
    private InventoryRepository inventoryRepository;



    @PostMapping("/upload")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) {
        if (ExcelHelper.isExcelFile(file)) {
            try {
                List<Inventory> items = ExcelHelper.excelToInventoryList(file.getInputStream());
                inventoryRepository.saveAll(items);
                return ResponseEntity.ok("Berhasil upload dan simpan data Excel.");
            } catch (Exception e) {
                return ResponseEntity.status(500).body("Gagal memproses dan simpan file Excel.");
            }
        }
        return ResponseEntity.badRequest().body("Format file bukan Excel (.xlsx)");
    }

    @GetMapping("/inventory")
    public ResponseEntity<ResponseWrapper> getAllInventory() {

        List<Inventory> inventories = inventoryRepository.findAll();
        int size = inventories.size();
        ResponseWrapper responseWrapper = new ResponseWrapper("Data Barang",size, inventories);
        return ResponseEntity.ok(responseWrapper);
    }

    @GetMapping ("/inventory/{kodeBarang}")
    public ResponseEntity<Inventory> getInventoryByKodeBarang(@PathVariable String kodeBarang) {
        return inventoryRepository.findByKodeBarang(kodeBarang)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}