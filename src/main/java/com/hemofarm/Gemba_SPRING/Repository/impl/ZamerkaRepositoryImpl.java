/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hemofarm.Gemba_SPRING.Repository.impl;

import com.hemofarm.Gemba_SPRING.Entity.Zamerka;
import com.hemofarm.Gemba_SPRING.Repository.ZamerkaRepository;
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
public class ZamerkaRepositoryImpl implements ZamerkaRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Zamerka> findAll() {
        return em.createQuery("SELECT z FROM Zamerka z ORDER BY z.naziv", Zamerka.class)
                .getResultList();
    }

    @Override
    public Optional<Zamerka> findById(Integer id) {
        return Optional.ofNullable(em.find(Zamerka.class, id));
    }
    
     @Override
    public List<Zamerka> findByAktivnostId(Integer aktivnostId) {
        String jpql = "SELECT z FROM Zamerka z WHERE z.iDAktivnosti.iDAktivnosti = :aktivnostId ORDER BY z.naziv";
        return em.createQuery(jpql, Zamerka.class)
                .setParameter("aktivnostId", aktivnostId)
                .getResultList();
    }
}