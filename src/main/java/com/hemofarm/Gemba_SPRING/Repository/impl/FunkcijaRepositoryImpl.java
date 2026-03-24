/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hemofarm.Gemba_SPRING.Repository.impl;

import com.hemofarm.Gemba_SPRING.Entity.Funkcija;
import com.hemofarm.Gemba_SPRING.Repository.FunkcijaRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Repository;

/**
 *
 * @author zpercinov
 */
  
@Repository
public class FunkcijaRepositoryImpl implements FunkcijaRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Funkcija> findAll() {
        return em.createQuery("SELECT f FROM Funkcija f ORDER BY f.ime", Funkcija.class)
                .getResultList();
    }

    @Override
    public Optional<Funkcija> findById(Integer id) {
        return Optional.ofNullable(em.find(Funkcija.class, id));
    }
    
}
