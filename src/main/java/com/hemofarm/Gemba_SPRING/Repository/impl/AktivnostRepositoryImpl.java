/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hemofarm.Gemba_SPRING.Repository.impl;

import com.hemofarm.Gemba_SPRING.Entity.Aktivnost;
import com.hemofarm.Gemba_SPRING.Repository.AktivnostRepository;
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
public class AktivnostRepositoryImpl implements AktivnostRepository {
  @PersistenceContext
    private EntityManager em;

    @Override
    public List<Aktivnost> findAll() {
        return em.createQuery("SELECT a FROM Aktivnost a ORDER BY a.naziv", Aktivnost.class)
                .getResultList();
    }

    @Override
    public Optional<Aktivnost> findById(Integer id) {
        return Optional.ofNullable(em.find(Aktivnost.class, id));
    }

@Override
public List<Aktivnost> findByVrstaGembeId(Integer vrstaGembeId) {
    String jpql = "SELECT a FROM Aktivnost a " +
                  "WHERE a.iDVrstaGem.iDVrstaGem = :vrstaGembeId " +  
                  "ORDER BY a.naziv";
    
    return em.createQuery(jpql, Aktivnost.class)
            .setParameter("vrstaGembeId", vrstaGembeId)
            .getResultList();
}
}
