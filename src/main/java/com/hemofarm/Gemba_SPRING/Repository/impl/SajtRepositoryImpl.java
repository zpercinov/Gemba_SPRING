/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hemofarm.Gemba_SPRING.Repository.impl;

import com.hemofarm.Gemba_SPRING.Entity.Sajt;
import com.hemofarm.Gemba_SPRING.Repository.SajtRepository;
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
public class SajtRepositoryImpl implements SajtRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Sajt> findAll() {
        return em.createQuery("SELECT s FROM Sajt s ORDER BY s.ime", Sajt.class)
                .getResultList();
    }

    @Override
    public Optional<Sajt> findById(Integer id) {
        return Optional.ofNullable(em.find(Sajt.class, id));
    }
}