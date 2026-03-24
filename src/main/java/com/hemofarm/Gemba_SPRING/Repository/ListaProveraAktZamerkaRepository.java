/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hemofarm.Gemba_SPRING.Repository;

import com.hemofarm.Gemba_SPRING.Entity.ListaProveraAktZamerka;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author zpercinov
 */
public interface ListaProveraAktZamerkaRepository {
    List<ListaProveraAktZamerka> findByListaProveraAktId(Integer listaProveraAktId);
    Optional<ListaProveraAktZamerka> findById(Integer id);
    ListaProveraAktZamerka save(ListaProveraAktZamerka zamerka);
    void deleteById(Integer id);
}