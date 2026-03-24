/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hemofarm.Gemba_SPRING.Repository.impl;

import com.hemofarm.Gemba_SPRING.Entity.Korisnik;
import com.hemofarm.Gemba_SPRING.Repository.KorisnikRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
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
public class KorisnikRepositoryImpl implements KorisnikRepository {
    
     @PersistenceContext
    private EntityManager em;

    @Override
    public Optional<Korisnik> findById(Integer id) {
        return Optional.ofNullable(em.find(Korisnik.class, id));
    }

    @Override
    public Optional<Korisnik> findByKorisnickoIme(String korisnickoIme) {
        try {
            Korisnik k = em.createQuery(
                "SELECT k FROM Korisnik k WHERE k.korisnickoIme = :username", Korisnik.class)
                .setParameter("username", korisnickoIme)
                .getSingleResult();
            return Optional.of(k);
        } catch (NoResultException ex) {
            return Optional.empty();
        }
    }

    @Override
    public boolean existsByKorisnickoIme(String korisnickoIme) {
        Long cnt = em.createQuery(
            "SELECT COUNT(k) FROM Korisnik k WHERE k.korisnickoIme = :username", Long.class)
            .setParameter("username", korisnickoIme)
            .getSingleResult();
        return cnt != null && cnt > 0;
    }

    @Override
    public List<Korisnik> findAll() {
        return em.createQuery("SELECT k FROM Korisnik k", Korisnik.class)
                .getResultList();
    }

    @Override
    @Transactional
    public Korisnik save(Korisnik korisnik) {
        if (korisnik.getiDKorisnik()== null) {  // Proveri tačan naziv gettera!
            em.persist(korisnik);
            return korisnik;
        } else {
            return em.merge(korisnik);
        }
    }

    @Override
    @Transactional
    public void deleteById(Integer id) {
        Korisnik korisnik = em.find(Korisnik.class, id);
        if (korisnik != null) {
            em.remove(korisnik);
        }
    }

    @Override
    public Optional<Korisnik> findByKorisnickoImeAndLozinka(String korisnickoIme, String lozinka) {
    try {
        
        
        
        System.out.println("Sledeci korak");
        System.out.println("com.hemofarm.Gemba_SPRING.Repository.impl.KorisnikRepositoryImpl.findByKorisnickoImeAndLozinka()");
        
        
        Korisnik k = em.createQuery(
            "SELECT k FROM Korisnik k WHERE k.korisnickoIme = :username AND k.lozinka = :password", 
            Korisnik.class)
            .setParameter("username", korisnickoIme)
            .setParameter("password", lozinka) 
            .getSingleResult();
        return Optional.of(k);
    } catch (NoResultException ex) {
        return Optional.empty();
    }
    }
    
}
