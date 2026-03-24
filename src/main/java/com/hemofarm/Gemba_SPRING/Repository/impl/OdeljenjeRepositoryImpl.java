/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hemofarm.Gemba_SPRING.Repository.impl;

import com.hemofarm.Gemba_SPRING.Entity.Odeljenje;
import com.hemofarm.Gemba_SPRING.Repository.OdeljenjeRepository;
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
public class OdeljenjeRepositoryImpl implements OdeljenjeRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Odeljenje> findAll() {
        return em.createQuery("SELECT o FROM Odeljenje o ORDER BY o.ime", Odeljenje.class)
                .getResultList();
    }

    @Override
    public Optional<Odeljenje> findById(Integer id) {
        return Optional.ofNullable(em.find(Odeljenje.class, id));
    }

    @Override
    public List<Odeljenje> findByFunkcijaId(Integer funkcijaId) {
        return em.createQuery(
                "SELECT o FROM Odeljenje o WHERE o.funkcija.id = :funkcijaId ORDER BY o.ime", 
                Odeljenje.class)
                .setParameter("funkcijaId", funkcijaId)
                .getResultList();
    }
    
}
