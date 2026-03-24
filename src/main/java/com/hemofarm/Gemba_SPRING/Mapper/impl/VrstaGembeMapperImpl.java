/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hemofarm.Gemba_SPRING.Mapper.impl;

import com.hemofarm.Gemba_SPRING.DTO.AktivnostDTO;
import com.hemofarm.Gemba_SPRING.DTO.VrstaGembeDTO;
import com.hemofarm.Gemba_SPRING.Entity.Aktivnost;
import com.hemofarm.Gemba_SPRING.Entity.VrstaGembe;
import com.hemofarm.Gemba_SPRING.Mapper.DtoEntityMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.context.annotation.Lazy;

/**
 *
 * @author zpercinov
 */
@Component
public class VrstaGembeMapperImpl implements DtoEntityMapper<VrstaGembeDTO, VrstaGembe> {  

    private final AktivnostMapperImpl aktivnostMapper;

    public VrstaGembeMapperImpl(@Lazy AktivnostMapperImpl aktivnostMapper) {
        this.aktivnostMapper = aktivnostMapper;
    }

    @Override
    public VrstaGembeDTO toDto(VrstaGembe entity) {  
        if (entity == null) {
            return null;
        }
        
        VrstaGembeDTO dto = new VrstaGembeDTO();
        
        
        dto.setIDVrstaGem(entity.getiDVrstaGem());
        dto.setNaziv(entity.getNaziv());
        
        
        if (entity.getAktivnostCollection() != null && !entity.getAktivnostCollection().isEmpty()) {
            List<AktivnostDTO> aktivnostiDTO = entity.getAktivnostCollection()
                    .stream()
                    .map(aktivnostMapper::toBasicDto)  
                    .collect(Collectors.toList());
            dto.setAktivnostCollection(aktivnostiDTO);
        }
        
        return dto;
    }

    @Override
    public VrstaGembe toEntity(VrstaGembeDTO dto) {  
        if (dto == null) {
            return null;
        }
        
        VrstaGembe entity = new VrstaGembe();
        
        // Osnovna polja
        entity.setiDVrstaGem(dto.getIDVrstaGem());
        entity.setNaziv(dto.getNaziv());
        
      
        
        return entity;
    }
    
    /**
     * Pomoćna metoda za osnovni DTO (bez kolekcije aktivnosti)
     * Ovo je najčešće korišćena metoda za liste
     */
    public VrstaGembeDTO toBasicDto(VrstaGembe entity) {
        if (entity == null) {
            return null;
        }
        
        return new VrstaGembeDTO(
            entity.getiDVrstaGem(),
            entity.getNaziv()
        );
    }
    
    /**
     * Pomoćna metoda za DTO sa brojem aktivnosti (bez cele kolekcije)
     * Korisno za prikaz statistike bez učitavanja svih podataka
     */
    public VrstaGembeDTO toDtoWithCount(VrstaGembe entity) {
        if (entity == null) {
            return null;
        }
        
        VrstaGembeDTO dto = toBasicDto(entity);
        
        if (entity.getAktivnostCollection() != null) {
          
        }
        
        return dto;
    }
    
    /**
     * Pomoćna metoda za DTO sa nazivima aktivnosti (bez celih objekata)
     * Korisno za prikaz u listi bez učitavanja svih podataka
     */
    public VrstaGembeDTO toDtoWithActivityNames(VrstaGembe entity) {
        if (entity == null) {
            return null;
        }
        
        VrstaGembeDTO dto = toBasicDto(entity);
        
        if (entity.getAktivnostCollection() != null && !entity.getAktivnostCollection().isEmpty()) {
            List<String> nazivi = entity.getAktivnostCollection()
                    .stream()
                    .map(Aktivnost::getNaziv)
                    .collect(Collectors.toList());
           
        }
        
        return dto;
    }
    
    /**
     * Pomoćna metoda za kreiranje entiteta samo sa ID-em (za reference)
     * Koristi se kada treba postaviti referencu na VrstaGembe u drugom entitetu
     */
    public VrstaGembe toEntityReference(Integer id) {
        if (id == null) {
            return null;
        }
        VrstaGembe entity = new VrstaGembe();
        entity.setiDVrstaGem(id);
        return entity;
    }
    
    /**
     * Pomoćna metoda za ažuriranje entiteta iz DTO-a
     * Ne ažurira ID i kolekciju
     */
    public void updateEntityFromDto(VrstaGembeDTO dto, VrstaGembe entity) {
        if (dto == null || entity == null) {
            return;
        }
        
      
        entity.setNaziv(dto.getNaziv());
        
        
    }
}