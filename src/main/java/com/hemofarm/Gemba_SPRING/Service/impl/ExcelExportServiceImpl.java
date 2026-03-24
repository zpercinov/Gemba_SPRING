/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hemofarm.Gemba_SPRING.Service.impl;

import com.hemofarm.Gemba_SPRING.DTO.ListaProveraDTO;
import com.hemofarm.Gemba_SPRING.Service.ExcelExportService;
import com.hemofarm.Gemba_SPRING.util.EnumGembaStatus;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.springframework.stereotype.Service;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author zpercinov
 */
@Service
public class ExcelExportServiceImpl implements ExcelExportService {

    @Override
    public void exportStatistika(List<ListaProveraDTO> lista, 
                                 String korisnikImePrezime, 
                                 OutputStream outputStream) throws IOException {
        
        try (Workbook workbook = new XSSFWorkbook()) {
            
            // Kreiranje sheet-a sa imenom korisnika
            Sheet sheet = workbook.createSheet(korisnikImePrezime);
            
            // Zaglavlje
            String[] columns = {"ID", "Datum", "Klaster", "Sajt", "Odeljenje", "Vrsta Gembe", "Status"};
            Row headerRow = sheet.createRow(0);
            
            for (int i = 0; i < columns.length; i++) {
                headerRow.createCell(i).setCellValue(columns[i]);
            }
            
            // Podaci
            int rowNum = 1;
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
            
            for (ListaProveraDTO lp : lista) {
                Row row = sheet.createRow(rowNum++);
                
                // ID
                row.createCell(0).setCellValue(lp.getiDLisProvere() != null ? lp.getiDLisProvere() : 0);
                
                // Datum
                String datumStr = lp.getDatum() != null ? dateFormat.format(lp.getDatum()) : "";
                row.createCell(1).setCellValue(datumStr);
                
                // Klaster
                String klasterNaziv = lp.getKlaster() != null ? lp.getKlaster().getNaziv() : "";
                row.createCell(2).setCellValue(klasterNaziv);
                
                // Sajt
                String sajtIme = lp.getSajt() != null ? lp.getSajt().getIme() : "";
                row.createCell(3).setCellValue(sajtIme);
                
                // Odeljenje
                String odeljenjeIme = lp.getOdeljenje() != null ? lp.getOdeljenje().getIme() : "";
                row.createCell(4).setCellValue(odeljenjeIme);
                
                // Vrsta gembe
                String vrstaGembeNaziv = lp.getVrstaGembe() != null ? lp.getVrstaGembe().getNaziv() : "";
                row.createCell(5).setCellValue(vrstaGembeNaziv);
                
                // Status
                String statusLabel = getStatusLabel(lp);
                row.createCell(6).setCellValue(statusLabel);
            }
            
            // Automatsko podešavanje širine kolona
            for (int i = 0; i < columns.length; i++) {
                sheet.autoSizeColumn(i);
            }
            
            workbook.write(outputStream);
        }
    }
    
    @Override
    public String generateFileName(String filter) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        String formattedDate = sdf.format(new Date());
        
        if (filter != null && !filter.equals("all")) {
            return "Statistika_" + filter + "_" + formattedDate + ".xlsx";
        } else {
            return "Statistika_sve_" + formattedDate + ".xlsx";
        }
    }
    
    /**
     * Pomoćna metoda za dobijanje labele statusa
     */
    private String getStatusLabel(ListaProveraDTO lp) {
        // Prvo probamo preko enum metode u DTO
        if (lp.getStatusEnum() != null) {
            return lp.getStatusEnum().getLabel();
        }
        
        // Fallback na direktno mapiranje
        EnumGembaStatus status = EnumGembaStatus.fromStep(lp.getStatus());
        return status != null ? status.getLabel() : "Nepoznat";
    }
}