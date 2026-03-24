/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hemofarm.Gemba_SPRING.Repository.impl;

import com.hemofarm.Gemba_SPRING.Entity.VrstaGembe;
import com.hemofarm.Gemba_SPRING.Repository.VrstaGembeRepository;
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
public class VrstaGembeRepositoryImpl implements VrstaGembeRepository {
    
    @PersistenceContext
    private EntityManager em;

    @Override
    public List<VrstaGembe> findAll() {
        return em.createQuery("SELECT v FROM VrstaGembe v ORDER BY v.naziv", VrstaGembe.class)
                .getResultList();
    }

    @Override
    public Optional<VrstaGembe> findById(Integer id) {
        return Optional.ofNullable(em.find(VrstaGembe.class, id));
    }
    
}
