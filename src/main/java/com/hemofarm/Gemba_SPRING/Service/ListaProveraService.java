/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hemofarm.Gemba_SPRING.Service;
import java.util.List;
import com.hemofarm.Gemba_SPRING.DTO.ListaProveraDTO;

/**
 *
 * @author zpercinov
 */
public interface ListaProveraService {
    List<ListaProveraDTO> findAll();
    List<ListaProveraDTO> findByKorisnik(String korisnickoIme);
    List<ListaProveraDTO> search(List<ListaProveraDTO> listaZaPretragu, String query);
  
}
