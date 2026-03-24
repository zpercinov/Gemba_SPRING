/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hemofarm.Gemba_SPRING.Repository.impl;

import com.hemofarm.Gemba_SPRING.DTO.StatisticDTO;
import com.hemofarm.Gemba_SPRING.Entity.ListaProvera;
import com.hemofarm.Gemba_SPRING.Repository.StatisticRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 *
 * @author zpercinov
 */
@Repository
public class StatisticRepositoryImpl implements StatisticRepository {

    @PersistenceContext
    private EntityManager em;
    
    private static final int COMPLETED_STATUS = 5;
    private static final int MIN_PENDING_STATUS = 0;
    private static final int MAX_PENDING_STATUS = 4;

    @Override
    public List<ListaProvera> findByUserUnos(String userUnos) {
        return em.createQuery(
                "SELECT l FROM ListaProvera l WHERE l.userUnos = :userUnos ORDER BY l.iDLisProvere DESC",
                ListaProvera.class)
                .setParameter("userUnos", userUnos)
                .getResultList();
    }

    @Override
    public List<ListaProvera> findByUserUnosAndStatus(String userUnos, int status) {
        return em.createQuery(
                "SELECT l FROM ListaProvera l WHERE l.userUnos = :userUnos AND l.status = :status ORDER BY l.iDLisProvere DESC",
                ListaProvera.class)
                .setParameter("userUnos", userUnos)
                .setParameter("status", status)
                .getResultList();
    }

    @Override
    public List<ListaProvera> findByUserUnosAndStatusBetween(String userUnos, int minStatus, int maxStatus) {
        return em.createQuery(
                "SELECT l FROM ListaProvera l WHERE l.userUnos = :userUnos AND l.status BETWEEN :minStatus AND :maxStatus ORDER BY l.iDLisProvere DESC",
                ListaProvera.class)
                .setParameter("userUnos", userUnos)
                .setParameter("minStatus", minStatus)
                .setParameter("maxStatus", maxStatus)
                .getResultList();
    }

    @Override
    public List<ListaProvera> findByUserUnosAndStatusLessThanOrStatusGreaterThan(
            String userUnos, int minStatus, int maxStatus) {
        return em.createQuery(
                "SELECT l FROM ListaProvera l WHERE l.userUnos = :userUnos AND (l.status < :minStatus OR l.status > :maxStatus) ORDER BY l.iDLisProvere DESC",
                ListaProvera.class)
                .setParameter("userUnos", userUnos)
                .setParameter("minStatus", minStatus)
                .setParameter("maxStatus", maxStatus)
                .getResultList();
    }
    
    @Override
    public Long countByUserUnos(String userUnos) {
        return em.createQuery(
                "SELECT COUNT(l) FROM ListaProvera l WHERE l.userUnos = :userUnos",
                Long.class)
                .setParameter("userUnos", userUnos)
                .getSingleResult();
    }
    
    @Override
    public Long countByUserUnosAndStatus(String userUnos, int status) {
        return em.createQuery(
                "SELECT COUNT(l) FROM ListaProvera l WHERE l.userUnos = :userUnos AND l.status = :status",
                Long.class)
                .setParameter("userUnos", userUnos)
                .setParameter("status", status)
                .getSingleResult();
    }
    
    @Override
    public Long countByUserUnosAndStatusBetween(String userUnos, int minStatus, int maxStatus) {
        return em.createQuery(
                "SELECT COUNT(l) FROM ListaProvera l WHERE l.userUnos = :userUnos AND l.status BETWEEN :minStatus AND :maxStatus",
                Long.class)
                .setParameter("userUnos", userUnos)
                .setParameter("minStatus", minStatus)
                .setParameter("maxStatus", maxStatus)
                .getSingleResult();
    }
    
    @Override
    public Long countByUserUnosAndStatusLessThanOrStatusGreaterThan(
            String userUnos, int minStatus, int maxStatus) {
        return em.createQuery(
                "SELECT COUNT(l) FROM ListaProvera l WHERE l.userUnos = :userUnos AND (l.status < :minStatus OR l.status > :maxStatus)",
                Long.class)
                .setParameter("userUnos", userUnos)
                .setParameter("minStatus", minStatus)
                .setParameter("maxStatus", maxStatus)
                .getSingleResult();
    }
    
    @Override
    public StatisticDTO getStatisticForUser(String userUnos) {
        // Najoptimalniji upit - sve u jednom!
        String jpql = "SELECT " +
                      "COUNT(l) as total, " +
                      "SUM(CASE WHEN l.status = :completed THEN 1 ELSE 0 END) as completed, " +
                      "SUM(CASE WHEN l.status BETWEEN :minPending AND :maxPending THEN 1 ELSE 0 END) as pending, " +
                      "SUM(CASE WHEN l.status IS NULL OR l.status < :minPending OR l.status > :completed THEN 1 ELSE 0 END) as archive " +
                      "FROM ListaProvera l " +
                      "WHERE l.userUnos = :userUnos";
        
        TypedQuery<Object[]> query = em.createQuery(jpql, Object[].class)
                .setParameter("userUnos", userUnos)
                .setParameter("completed", COMPLETED_STATUS)
                .setParameter("minPending", MIN_PENDING_STATUS)
                .setParameter("maxPending", MAX_PENDING_STATUS);
        
        Object[] result = query.getSingleResult();
        
        Long total = (Long) result[0];
        Long completed = (Long) result[1];
        Long pending = (Long) result[2];
        Long archive = (Long) result[3];
        
        return new StatisticDTO(
            total != null ? total.intValue() : 0,
            completed != null ? completed.intValue() : 0,
            pending != null ? pending.intValue() : 0,
            archive != null ? archive.intValue() : 0
        );
    }
}
