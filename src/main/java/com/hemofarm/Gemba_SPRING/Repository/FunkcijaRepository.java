/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.hemofarm.Gemba_SPRING.Repository;

import com.hemofarm.Gemba_SPRING.Entity.Funkcija;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author zpercinov
 */
public interface FunkcijaRepository {
    
    List<Funkcija> findAll();
    Optional<Funkcija> findById(Integer id);
    
}
