/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hemofarm.Gemba_SPRING.Repository.impl;

import com.hemofarm.Gemba_SPRING.Entity.Nosilac;
import com.hemofarm.Gemba_SPRING.Repository.NosilacRepository;
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
public class NosilacRepositoryImpl implements NosilacRepository {
    
    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Nosilac> findAll() {
        return em.createQuery("SELECT n FROM Nosilac n ORDER BY n.naziv", Nosilac.class)
                .getResultList();
    }

    @Override
    public Optional<Nosilac> findById(Integer id) {
        return Optional.ofNullable(em.find(Nosilac.class, id));
    }
    
}
