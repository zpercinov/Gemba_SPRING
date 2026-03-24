/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hemofarm.Gemba_SPRING.Repository.impl;

import com.hemofarm.Gemba_SPRING.Entity.Klaster;
import com.hemofarm.Gemba_SPRING.Repository.KlasterRepository;
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
public class KlasterRepositoryImpl implements KlasterRepository {
    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Klaster> findAll() {
        return em.createQuery("SELECT k FROM Klaster k ORDER BY k.naziv", Klaster.class)
                .getResultList();
    }

    @Override
    public Optional<Klaster> findById(Integer id) {
        return Optional.ofNullable(em.find(Klaster.class, id));
    }
    
}
