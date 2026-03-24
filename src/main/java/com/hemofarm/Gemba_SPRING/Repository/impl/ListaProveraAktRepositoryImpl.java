package com.hemofarm.Gemba_SPRING.Repository.impl;

import com.hemofarm.Gemba_SPRING.Entity.ListaProveraAkt;
import com.hemofarm.Gemba_SPRING.Repository.ListaProveraAktRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class ListaProveraAktRepositoryImpl implements ListaProveraAktRepository {
    
    @PersistenceContext
    private EntityManager em;

    @Override
    public List<ListaProveraAkt> findByListaProveraId(Integer listaProveraId) {
        String jpql = "SELECT l FROM ListaProveraAkt l " +
                      "LEFT JOIN FETCH l.iDAktivnosti akt " +  
                      "LEFT JOIN FETCH l.iDIshod ish " +     
                      "WHERE l.iDLisProvere.iDLisProvere = :listaProveraId " +  
                      "ORDER BY akt.naziv";                  
        
        return em.createQuery(jpql, ListaProveraAkt.class)
                .setParameter("listaProveraId", listaProveraId)
                .getResultList();
    }

    @Override
    public Optional<ListaProveraAkt> findById(Integer id) {
        return Optional.ofNullable(em.find(ListaProveraAkt.class, id));
    }

    @Override
    @Transactional
    public ListaProveraAkt save(ListaProveraAkt aktivnost) {
        if (aktivnost.getiDLisProvereAkt() == null) {
            em.persist(aktivnost);
            return aktivnost;
        } else {
            return em.merge(aktivnost);
        }
    }

    @Override
    @Transactional
    public void deleteById(Integer id) {
        ListaProveraAkt aktivnost = em.find(ListaProveraAkt.class, id);
        if (aktivnost != null) {
            em.remove(aktivnost);
        }
    }

    @Override
    public boolean existsByListaProveraAndAktivnost(Integer listaProveraId, Integer aktivnostId) {
       
        String jpql = "SELECT COUNT(l) FROM ListaProveraAkt l " +
                      "WHERE l.iDLisProvere.iDLisProvere = :listaProveraId " +
                      "AND l.iDAktivnosti.iDAktivnosti = :aktivnostId";
        
        Long count = em.createQuery(jpql, Long.class)
                .setParameter("listaProveraId", listaProveraId)
                .setParameter("aktivnostId", aktivnostId)
                .getSingleResult();
        return count > 0;
    }

    @Override
    @Transactional
    public void updateIshod(Integer id, Integer ishodId, String userIzmena) {
       
        em.createQuery(
                "UPDATE ListaProveraAkt l SET l.iDIshod.iDIshod = :ishodId, " +
                "l.userIzmena = :userIzmena, l.datumIzmena = :datumIzmena " +
                "WHERE l.iDLisProvereAkt = :id")
                .setParameter("ishodId", ishodId)
                .setParameter("userIzmena", userIzmena)
                .setParameter("datumIzmena", new Date())
                .setParameter("id", id)
                .executeUpdate();
    }

    @Override
    public List<ListaProveraAkt> findAllWithZamerke(Integer listaProveraId) {
        
        String jpql = "SELECT DISTINCT l FROM ListaProveraAkt l " +
                      "LEFT JOIN FETCH l.zamerke " +
                      "WHERE l.iDLisProvere.iDLisProvere = :listaProveraId " +
                      "ORDER BY l.iDAktivnosti.naziv";
        
        return em.createQuery(jpql, ListaProveraAkt.class)
                .setParameter("listaProveraId", listaProveraId)
                .getResultList();
    }
}