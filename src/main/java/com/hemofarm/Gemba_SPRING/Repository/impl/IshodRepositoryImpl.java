/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hemofarm.Gemba_SPRING.Repository.impl;

import com.hemofarm.Gemba_SPRING.Entity.Ishod;
import com.hemofarm.Gemba_SPRING.Repository.IshodRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Repository;

/**
 *
 * @author zpercinov
 */
@Repository
public class IshodRepositoryImpl implements IshodRepository {
    
    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Ishod> findAll() {
        return em.createQuery("SELECT i FROM Ishod i ORDER BY i.naziv", Ishod.class)
                .getResultList();
    }

    @Override
    public Optional<Ishod> findById(Integer id) {
        return Optional.ofNullable(em.find(Ishod.class, id));
    }

    @Override
    public Optional<Ishod> findByNaziv(String naziv) {
        try {
            Ishod ishod = em.createQuery(
                    "SELECT i FROM Ishod i WHERE i.naziv = :naziv", Ishod.class)
                    .setParameter("naziv", naziv)
                    .getSingleResult();
            return Optional.ofNullable(ishod);
        } catch (NoResultException e) {
            return Optional.empty();
        }
    }
    
}
