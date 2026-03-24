/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.hemofarm.Gemba_SPRING.Repository;


import com.hemofarm.Gemba_SPRING.Entity.ListaProvera;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author zpercinov
 */
public interface ListaProveraRepository {
    
    List<ListaProvera> findByUserUnos(String userUnos);
    List<ListaProvera> findAll();
    Optional<ListaProvera> findById(Integer id);
  
    ListaProvera save(ListaProvera listaProvera);
    
    void  deleteById(Integer id);
    
    
     
 
    
}
