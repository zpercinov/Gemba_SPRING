/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hemofarm.Gemba_SPRING.Mapper.impl;


import com.hemofarm.Gemba_SPRING.DTO.NosilacDTO;

import com.hemofarm.Gemba_SPRING.Entity.Nosilac;
import com.hemofarm.Gemba_SPRING.Mapper.DtoEntityMapper;
import org.springframework.stereotype.Component;
import org.springframework.context.annotation.Lazy;

/**
 *
 * @author zpercinov
 */
@Component
public class NosilacMapperImpl implements DtoEntityMapper<NosilacDTO, Nosilac> {  

    private final ListaProveraMapperImpl listaProveraMapper;

    public NosilacMapperImpl(@Lazy ListaProveraMapperImpl listaProveraMapper) {
        this.listaProveraMapper = listaProveraMapper;
    }

    @Override
    public NosilacDTO toDto(Nosilac entity) { 
        if (entity == null) {
            return null;
        }
        
        NosilacDTO dto = new NosilacDTO();
        
        // Osnovna polja
        dto.setIDNos(entity.getiDNos());
        dto.setNaziv(entity.getNaziv());
        
       
        
        return dto;
    }

    @Override
    public Nosilac toEntity(NosilacDTO dto) {  
        if (dto == null) {
            return null;
        }
        
        Nosilac entity = new Nosilac();
        
       
        entity.setiDNos(dto.getIDNos());
        entity.setNaziv(dto.getNaziv());
     
        
        return entity;
    }
    
    /**
     * Pomoćna metoda za osnovni DTO (bez kolekcije provera)
     * Ovo je najčešće korišćena metoda za liste
     */
    public NosilacDTO toBasicDto(Nosilac entity) {
        if (entity == null) {
            return null;
        }
        
        return new NosilacDTO(
            entity.getiDNos(),
            entity.getNaziv()
        );
    }
    
    /**
     * Pomoćna metoda za DTO sa statistikom (bez cele kolekcije)
     * Ovo je korisno za prikaz broja provera bez učitavanja svih podataka
     */
    public NosilacDTO toDtoWithStats(Nosilac entity) {
        if (entity == null) {
            return null;
        }
        
        NosilacDTO dto = toBasicDto(entity);
        
        if (entity.getListaProveraCollection() != null) {
          
        }
        
        return dto;
    }
    
    /**
     * Pomoćna metoda za kreiranje entiteta samo sa ID-em (za reference)
     * Koristi se kada treba postaviti referencu na Nosilac u drugom entitetu
     */
    public Nosilac toEntityReference(Integer id) {
        if (id == null) {
            return null;
        }
        Nosilac entity = new Nosilac();
        entity.setiDNos(id);
        return entity;
    }
    
    /**
     * Pomoćna metoda za ažuriranje entiteta iz DTO-a
     */
    public void updateEntityFromDto(NosilacDTO dto, Nosilac entity) {
        if (dto == null || entity == null) {
            return;
        }
        
       
        entity.setNaziv(dto.getNaziv());
        
     
    }
}