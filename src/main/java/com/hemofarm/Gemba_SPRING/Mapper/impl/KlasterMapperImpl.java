/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hemofarm.Gemba_SPRING.Mapper.impl;

import com.hemofarm.Gemba_SPRING.DTO.KlasterDTO;

import com.hemofarm.Gemba_SPRING.Entity.Klaster;
import com.hemofarm.Gemba_SPRING.Mapper.DtoEntityMapper;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

/**
 *
 * @author zpercinov
 */
@Component
public class KlasterMapperImpl implements DtoEntityMapper<KlasterDTO, Klaster> {  

    private final ListaProveraMapperImpl listaProveraMapper;

   public KlasterMapperImpl(@Lazy ListaProveraMapperImpl listaProveraMapper) {
    this.listaProveraMapper = listaProveraMapper;
}

    @Override
    public KlasterDTO toDto(Klaster entity) {  
        if (entity == null) {
            return null;
        }
        
        KlasterDTO dto = new KlasterDTO();
        
        // Osnovna polja
        dto.setIDCluster(entity.getiDCluster());
        dto.setNaziv(entity.getNaziv());
        
     
        
        return dto;
    }

    @Override
    public Klaster toEntity(KlasterDTO dto) {  
        if (dto == null) {
            return null;
        }
        
        Klaster entity = new Klaster();
        
       
        entity.setiDCluster(dto.getIDCluster());
        entity.setNaziv(dto.getNaziv());
        
     
        
        return entity;
    }
    
    /**
     * Pomoćna metoda za osnovni DTO (bez kolekcije provera)
     */
    public KlasterDTO toBasicDto(Klaster entity) {
        if (entity == null) {
            return null;
        }
        
        return new KlasterDTO(
            entity.getiDCluster(),
            entity.getNaziv()
        );
    }
    
    /**
     * Pomoćna metoda za DTO sa brojem provera (bez cele kolekcije)
     */
    public KlasterDTO toDtoWithCount(Klaster entity) {
        if (entity == null) {
            return null;
        }
        
        KlasterDTO dto = toBasicDto(entity);
        
        if (entity.getListaProveraCollection() != null) {
            // Ne učitavamo celu kolekciju, ali možemo dodati broj
            // dto.setBrojProvera(entity.getListaProveraCollection().size()); // Ako dodate ovo polje u DTO
        }
        
        return dto;
    }
    
    /**
     * Pomoćna metoda za kreiranje entiteta samo sa ID-em (za reference)
     */
    public Klaster toEntityReference(Integer id) {
        if (id == null) {
            return null;
        }
        Klaster entity = new Klaster();
        entity.setiDCluster(id);
        return entity;
    }
    
    /**
     * Pomoćna metoda za ažuriranje entiteta iz DTO-a
     */
    public void updateEntityFromDto(KlasterDTO dto, Klaster entity) {
        if (dto == null || entity == null) {
            return;
        }
        
       
        entity.setNaziv(dto.getNaziv());
        
      
    }
}