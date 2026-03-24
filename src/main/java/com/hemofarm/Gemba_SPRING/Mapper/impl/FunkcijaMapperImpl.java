/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hemofarm.Gemba_SPRING.Mapper.impl;

import com.hemofarm.Gemba_SPRING.DTO.FunkcijaDTO;

import com.hemofarm.Gemba_SPRING.Entity.Funkcija;

import com.hemofarm.Gemba_SPRING.Mapper.DtoEntityMapper;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;



/**
 *
 * @author zpercinov
 */
@Component
public class FunkcijaMapperImpl implements DtoEntityMapper<FunkcijaDTO, Funkcija> {  

    private final ListaProveraMapperImpl listaProveraMapper;

    public FunkcijaMapperImpl(@Lazy ListaProveraMapperImpl listaProveraMapper) {
        this.listaProveraMapper = listaProveraMapper;
    }

    @Override
    public FunkcijaDTO toDto(Funkcija entity) { 
        if (entity == null) {
            return null;
        }
        
        FunkcijaDTO dto = new FunkcijaDTO();
        
        
        dto.setIDFun(entity.getiDFun());
        dto.setIme(entity.getIme());
        
       
        
        return dto;
    }

    @Override
    public Funkcija toEntity(FunkcijaDTO dto) {  
        if (dto == null) {
            return null;
        }
        
        Funkcija entity = new Funkcija();
        
        // Osnovna polja
        entity.setiDFun(dto.getIDFun());
        entity.setIme(dto.getIme());
       
        return entity;
    }
    
    /**
     * Pomoćna metoda za osnovni DTO (bez kolekcije provera)
     */
    public FunkcijaDTO toBasicDto(Funkcija entity) {
        if (entity == null) {
            return null;
        }
        
        return new FunkcijaDTO(
            entity.getiDFun(),
            entity.getIme()
        );
    }
    
    /**
     * Pomoćna metoda za DTO sa brojem provera (bez cele kolekcije)
     */
    public FunkcijaDTO toDtoWithCount(Funkcija entity) {
        if (entity == null) {
            return null;
        }
        
        FunkcijaDTO dto = toBasicDto(entity);
        
        if (entity.getListaProveraCollection() != null) {
            
        }
        
        return dto;
    }
    
    /**
     * Pomoćna metoda za kreiranje entiteta samo sa ID-em (za reference)
     */
    public Funkcija toEntityReference(Integer id) {
        if (id == null) {
            return null;
        }
        Funkcija entity = new Funkcija();
        entity.setiDFun(id);
        return entity;
    }
    
    /**
     * Pomoćna metoda za ažuriranje entiteta iz DTO-a
     */
    public void updateEntityFromDto(FunkcijaDTO dto, Funkcija entity) {
        if (dto == null || entity == null) {
            return;
        }
        
        
        entity.setIme(dto.getIme());
        
        
    }
}