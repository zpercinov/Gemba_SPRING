/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.hemofarm.Gemba_SPRING.Repository;

import com.hemofarm.Gemba_SPRING.DTO.StatisticDTO;
import com.hemofarm.Gemba_SPRING.Entity.ListaProvera;
import java.util.List;

/**
 *
 * @author zpercinov
 */
public interface StatisticRepository {
   
    List<ListaProvera> findByUserUnos(String userUnos);
    
    
    List<ListaProvera> findByUserUnosAndStatus(String userUnos, int status);
    List<ListaProvera> findByUserUnosAndStatusBetween(String userUnos, int minStatus, int maxStatus);
    List<ListaProvera> findByUserUnosAndStatusLessThanOrStatusGreaterThan(
        String userUnos, int minStatus, int maxStatus);
    
    
    Long countByUserUnos(String userUnos);
    Long countByUserUnosAndStatus(String userUnos, int status);
    Long countByUserUnosAndStatusBetween(String userUnos, int minStatus, int maxStatus);
    Long countByUserUnosAndStatusLessThanOrStatusGreaterThan(
        String userUnos, int minStatus, int maxStatus);
    
   
    StatisticDTO getStatisticForUser(String userUnos); 
    
    
}
