/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.hemofarm.Gemba_SPRING.Service;

import com.hemofarm.Gemba_SPRING.DTO.ListaProveraDTO;
import com.hemofarm.Gemba_SPRING.DTO.StatisticDTO;
import java.util.List;

/**
 *
 * @author zpercinov
 */
public interface StatisticService {
     
    StatisticDTO izracunajStatistiku(String username);
    List<ListaProveraDTO> filtrirajPoStatusu(String username, String statusFilter);
    
    
    StatisticDTO izracunajStatistiku(List<ListaProveraDTO> lista);
    List<ListaProveraDTO> filtrirajPoStatusu(List<ListaProveraDTO> lista, String statusFilter);
}
