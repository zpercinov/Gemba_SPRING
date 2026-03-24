package com.hemofarm.Gemba_SPRING.Repository.impl;

import com.hemofarm.Gemba_SPRING.Entity.ListaProvera;
import com.hemofarm.Gemba_SPRING.Repository.ListaProveraRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class ListaProveraRepositoryImpl implements ListaProveraRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<ListaProvera> findByUserUnos(String userUnos) {
        return em.createQuery(
                "SELECT l FROM ListaProvera l WHERE l.userUnos = :userUnos ORDER BY l.iDLisProvere DESC",
                ListaProvera.class)
                .setParameter("userUnos", userUnos)
                .getResultList();
    }

    @Override
    public List<ListaProvera> findAll() {
        return em.createQuery(
                "SELECT l FROM ListaProvera l ORDER BY l.iDLisProvere DESC",
                ListaProvera.class)
                .getResultList();
    }

    @Override
    public Optional<ListaProvera> findById(Integer id) {
        return Optional.ofNullable(em.find(ListaProvera.class, id));
    }

    @Override
    @Transactional
    public ListaProvera save(ListaProvera listaProvera) {
        if (listaProvera.getiDLisProvere() == null) {
            em.persist(listaProvera);
            return listaProvera;
        } else {
            return em.merge(listaProvera);
        }
    }

    @Override
    @Transactional
    public void deleteById(Integer id) {
        ListaProvera listaProvera = em.find(ListaProvera.class, id);
        
        if (listaProvera != null) {
            // Provera da li ima aktivnosti
            List<?> aktivnosti = em.createQuery(
                    "SELECT a FROM ListaProveraAkt a WHERE a.iDLisProvere.iDLisProvere = :id")
                    .setParameter("id", id)
                    .getResultList();
            
            if (!aktivnosti.isEmpty()) {
                throw new RuntimeException("Ne može se obrisati gemba koja ima aktivnosti. Prvo obrišite aktivnosti.");
            }
            
            em.remove(listaProvera);
        }
    }
}