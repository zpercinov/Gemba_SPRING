/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.hemofarm.Gemba_SPRING.Service;

import com.hemofarm.Gemba_SPRING.DTO.ListaProveraDTO;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

/**
 *
 * @author zpercinov
 */
public interface ExcelExportService {
    
      void exportStatistika(List<ListaProveraDTO> lista, 
                          String korisnikImePrezime, 
                          OutputStream outputStream) throws IOException;
      
      String generateFileName(String filter);
      
    
}
