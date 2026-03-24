/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hemofarm.Gemba_SPRING.Repository.impl;

import com.hemofarm.Gemba_SPRING.Entity.Rola;
import com.hemofarm.Gemba_SPRING.Repository.RolaRepository;
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
public class RolaRepositoryImpl implements RolaRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Rola> findAll() {
        return em.createQuery("SELECT r FROM Rola r ORDER BY r.ime", Rola.class)
                .getResultList();
    }

    @Override
    public Optional<Rola> findById(Integer id) {
        return Optional.ofNullable(em.find(Rola.class, id));
    }
}