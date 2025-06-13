package com.example.Admin_Test.Helper;

import com.example.Admin_Test.Entity.Inventory;
import com.example.Admin_Test.Repository.InventoryRepository;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Component
public class ExcelHelper {

    private final InventoryRepository inventoryRepository;

    public ExcelHelper(InventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }

    public static boolean isExcelFile(MultipartFile file) {
        return file.getContentType() != null &&
                file.getContentType().equals("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
    }


    public static List<Inventory> excelToInventoryList(InputStream is) {
        try (Workbook workbook = new XSSFWorkbook(is)) {
            Sheet sheet = workbook.getSheetAt(0);
            List<Inventory> list = new ArrayList<>();

            for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                Row row = sheet.getRow(i);
                if (row == null) continue;

                Inventory entity = new Inventory();
                entity.setKodeBarang(row.getCell(1).getStringCellValue());
                entity.setNamaBarang(row.getCell(2).getStringCellValue());
                entity.setKategori(row.getCell(3).getStringCellValue());
                entity.setSatuan(row.getCell(4).getStringCellValue());
                entity.setStokAwal((int) row.getCell(5).getNumericCellValue());
                entity.setBarangMasuk((int) row.getCell(6).getNumericCellValue());
                entity.setBarangKeluar((int) row.getCell(7).getNumericCellValue());
                entity.setHargaSatuan((int) row.getCell(8).getNumericCellValue());
                entity.setStokAkhir((int) row.getCell(9).getNumericCellValue());
                entity.setNilaiPersediaan((long) row.getCell(10).getNumericCellValue());

                list.add(entity);
            }

            return list;
        } catch (IOException e) {
            throw new RuntimeException("Gagal membaca data Excel: " + e.getMessage());
        }
    }

    public void saveInventoryFromExcel(MultipartFile file) {
        try {
            List<Inventory> inventoryList = excelToInventoryList(file.getInputStream());
            inventoryRepository.saveAll(inventoryList);
        } catch (IOException e) {
            throw new RuntimeException("Gagal menyimpan data dari Excel: " + e.getMessage());
        }
    }
}
