/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hemofarm.Gemba_SPRING.Repository;

import com.hemofarm.Gemba_SPRING.Entity.Korisnik;
import java.util.List;
import java.util.Optional;


public interface KorisnikRepository {
    
    // Osnovne CRUD operacije
    Optional<Korisnik> findById(Integer id);
    
   Optional<Korisnik> findByKorisnickoImeAndLozinka(String korisnickoIme, String lozinka);
    
    Optional<Korisnik> findByKorisnickoIme(String korisnickoIme);
    
    boolean existsByKorisnickoIme(String korisnickoIme);
    
    List<Korisnik> findAll();
    
    Korisnik save(Korisnik korisnik);
    
    void deleteById(Integer id);
    
    

}