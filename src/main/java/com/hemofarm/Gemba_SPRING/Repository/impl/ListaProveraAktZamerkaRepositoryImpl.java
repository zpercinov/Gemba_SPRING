/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hemofarm.Gemba_SPRING.Repository.impl;

import com.hemofarm.Gemba_SPRING.Entity.ListaProveraAktZamerka;
import com.hemofarm.Gemba_SPRING.Repository.ListaProveraAktZamerkaRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author zpercinov
 */
@Repository
public class ListaProveraAktZamerkaRepositoryImpl implements ListaProveraAktZamerkaRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<ListaProveraAktZamerka> findByListaProveraAktId(Integer listaProveraAktId) {
        String jpql = "SELECT z FROM ListaProveraAktZamerka z " +
                      "LEFT JOIN FETCH z.iDZamerka zam " +  
                      "WHERE z.iDLisProvereAkt.iDLisProvereAkt = :listaProveraAktId " +  
                      "ORDER BY z.datumUnos DESC";
        
        return em.createQuery(jpql, ListaProveraAktZamerka.class)
                .setParameter("listaProveraAktId", listaProveraAktId)
                .getResultList();
    }

    @Override
    public Optional<ListaProveraAktZamerka> findById(Integer id) {
        return Optional.ofNullable(em.find(ListaProveraAktZamerka.class, id));
    }

    @Override
    @Transactional
    public ListaProveraAktZamerka save(ListaProveraAktZamerka zamerka) {
        if (zamerka.getiDLisProvereAktZamerka() == null) {
            em.persist(zamerka);
            return zamerka;
        } else {
            return em.merge(zamerka);
        }
    }

    @Override
    @Transactional
    public void deleteById(Integer id) {
        ListaProveraAktZamerka zamerka = em.find(ListaProveraAktZamerka.class, id);
        if (zamerka != null) {
            em.remove(zamerka);
        }
    }
}