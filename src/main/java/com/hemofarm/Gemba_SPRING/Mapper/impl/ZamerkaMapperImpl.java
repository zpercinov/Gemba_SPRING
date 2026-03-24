/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hemofarm.Gemba_SPRING.Mapper.impl;


import com.hemofarm.Gemba_SPRING.DTO.ZamerkaDTO;

import com.hemofarm.Gemba_SPRING.Entity.ListaProveraAktZamerka;
import com.hemofarm.Gemba_SPRING.Entity.Zamerka;
import com.hemofarm.Gemba_SPRING.Mapper.DtoEntityMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import org.springframework.context.annotation.Lazy;


/**
 *
 * @author zpercinov
 */
@Component
public class ZamerkaMapperImpl implements DtoEntityMapper<ZamerkaDTO, Zamerka> {  

    private final AktivnostMapperImpl aktivnostMapper;
    private final ListaProveraAktZamerkaMapperImpl listaProveraAktZamerkaMapper;

    public ZamerkaMapperImpl(@Lazy AktivnostMapperImpl aktivnostMapper,
                        @Lazy ListaProveraAktZamerkaMapperImpl listaProveraAktZamerkaMapper) {
        this.aktivnostMapper = aktivnostMapper;
        this.listaProveraAktZamerkaMapper = listaProveraAktZamerkaMapper;
    }

    @Override
    public ZamerkaDTO toDto(Zamerka entity) {  
        if (entity == null) {
            return null;
        }
        
        ZamerkaDTO dto = new ZamerkaDTO();
        
       
        dto.setIDZamerka(entity.getiDZamerka());
        dto.setNaziv(entity.getNaziv());
        
      
        if (entity.getiDAktivnosti() != null) {
            dto.setAktivnost(aktivnostMapper.toBasicDto(entity.getiDAktivnosti()));
        }
        
        
        
        return dto;
    }

    @Override
    public Zamerka toEntity(ZamerkaDTO dto) { 
        if (dto == null) {
            return null;
        }
        
        Zamerka entity = new Zamerka();
        
        
        entity.setiDZamerka(dto.getIDZamerka());
        entity.setNaziv(dto.getNaziv());
        
       
        
        return entity;
    }
    
    /**
     * Pomoćna metoda za osnovni DTO (bez relacionih entiteta i kolekcija)
     * Ovo je najčešće korišćena metoda za liste
     */
    public ZamerkaDTO toBasicDto(Zamerka entity) {
        if (entity == null) {
            return null;
        }
        
        return new ZamerkaDTO(
            entity.getiDZamerka(),
            entity.getNaziv()
        );
    }
    
    /**
     * Pomoćna metoda za DTO sa aktivnošću (bez kolekcije pojavljivanja)
     * Korisno za prikaz osnovnih informacija sa aktivnošću
     */
    public ZamerkaDTO toDtoWithActivity(Zamerka entity) {
        if (entity == null) {
            return null;
        }
        
        ZamerkaDTO dto = toBasicDto(entity);
        
        if (entity.getiDAktivnosti() != null) {
            dto.setAktivnost(aktivnostMapper.toBasicDto(entity.getiDAktivnosti()));
        }
        
        return dto;
    }
    
    /**
     * Pomoćna metoda za DTO sa statistikom 
     */
    public ZamerkaDTO toDtoWithStats(Zamerka entity) {
        if (entity == null) {
            return null;
        }
        
        ZamerkaDTO dto = toDtoWithActivity(entity);
        
        if (entity.getListaProveraAktZamerkaCollection() != null) {
           
        }
        
        return dto;
    }
    
    /**
     * Pomoćna metoda za DTO sa svim relacionim podacima
     * Ovo zahteva posebne upite za kolekciju pojavljivanja
     */
    public ZamerkaDTO toDtoWithAllRelations(Zamerka entity,
                                           List<ListaProveraAktZamerka> pojavljivanja) {
        if (entity == null) {
            return null;
        }
        
        ZamerkaDTO dto = toDtoWithActivity(entity);
        
        
        
        return dto;
    }
    
    /**
     * Pomoćna metoda za DTO sa poslednjom napomenom
     */
    public ZamerkaDTO toDtoWithLastNote(Zamerka entity, String lastNote) {
        if (entity == null) {
            return null;
        }
        
        ZamerkaDTO dto = toDtoWithActivity(entity);
        
        
        
        return dto;
    }
    
    /**
     * Pomoćna metoda za kreiranje entiteta samo sa ID-em 
     */
    public Zamerka toEntityReference(Integer id) {
        if (id == null) {
            return null;
        }
        Zamerka entity = new Zamerka();
        entity.setiDZamerka(id);
        return entity;
    }
    
    /**
     * Pomoćna metoda za ažuriranje entiteta iz DTO-a
     */
    public void updateEntityFromDto(ZamerkaDTO dto, Zamerka entity) {
        if (dto == null || entity == null) {
            return;
        }
        
       
        entity.setNaziv(dto.getNaziv());
        
        
    }
}