/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.hemofarm.Gemba_SPRING.Repository;

import com.hemofarm.Gemba_SPRING.Entity.Ishod;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author zpercinov
 */
public interface IshodRepository {
    
    List<Ishod> findAll();
    Optional<Ishod> findById(Integer id);
    Optional<Ishod> findByNaziv(String naziv);
    
}
