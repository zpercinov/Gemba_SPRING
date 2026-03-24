/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.hemofarm.Gemba_SPRING.Repository;

import com.hemofarm.Gemba_SPRING.Entity.ListaProveraAkt;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author zpercinov
 */
public interface ListaProveraAktRepository {
    List<ListaProveraAkt> findByListaProveraId(Integer listaProveraId);
    Optional<ListaProveraAkt> findById(Integer id);
    ListaProveraAkt save(ListaProveraAkt aktivnost);
    void deleteById(Integer id);
    boolean existsByListaProveraAndAktivnost(Integer listaProveraId, Integer aktivnostId);
    void updateIshod(Integer id, Integer ishodId, String userIzmena);
    List<ListaProveraAkt> findAllWithZamerke(Integer listaProveraId);
}
