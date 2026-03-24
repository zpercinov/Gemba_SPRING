/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.hemofarm.Gemba_SPRING.Repository;

import com.hemofarm.Gemba_SPRING.Entity.Sajt;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author zpercinov
 */
public interface SajtRepository {
    List<Sajt> findAll();
    Optional<Sajt> findById(Integer id);
}
