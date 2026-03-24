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
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

/**
 *
 * @author zpercinov
 */
@Component
public class AktivnostMapperImpl implements DtoEntityMapper<AktivnostDTO, Aktivnost> {  // DTO, pa Entity

    private final VrstaGembeMapperImpl vrstaGembeMapper;

    public AktivnostMapperImpl(@Lazy VrstaGembeMapperImpl vrstaGembeMapper) {
        this.vrstaGembeMapper = vrstaGembeMapper;
    }

    @Override
    public AktivnostDTO toDto(Aktivnost entity) {  // Entity -> DTO
        if (entity == null) {
            return null;
        }
        
        AktivnostDTO dto = new AktivnostDTO();
        
       
        dto.setIDAktivnosti(entity.getiDAktivnosti());
        dto.setNaziv(entity.getNaziv());
        
        
        if (entity.getiDVrstaGem() != null) {
            dto.setVrstaGembe(vrstaGembeMapper.toBasicDto(entity.getiDVrstaGem()));
        }
        
        return dto;
    }

    @Override
    public Aktivnost toEntity(AktivnostDTO dto) {  // DTO -> Entity
        if (dto == null) {
            return null;
        }
        
        Aktivnost entity = new Aktivnost();
        
        // Osnovna polja
        entity.setiDAktivnosti(dto.getIDAktivnosti());
        entity.setNaziv(dto.getNaziv());
        
       
        
        return entity;
    }
    
    /**
     * Pomoćna metoda za osnovni DTO (bez VrstaGembe)
     * Ovo je korisno za liste gde ne trebaju detalji o vrsti gembe
     */
    public AktivnostDTO toBasicDto(Aktivnost entity) {
        if (entity == null) {
            return null;
        }
        
        return new AktivnostDTO(
            entity.getiDAktivnosti(),
            entity.getNaziv(),
            null  // Bez VrstaGembeDTO
        );
    }
    
    /**
     * Pomoćna metoda za DTO sa osnovnim podacima o vrsti gembe
     * Vraća samo ID i naziv vrste gembe, bez cele kolekcije aktivnosti
     */
    public AktivnostDTO toDtoWithBasicVrstaGembe(Aktivnost entity) {
        if (entity == null) {
            return null;
        }
        
        AktivnostDTO dto = new AktivnostDTO();
        dto.setIDAktivnosti(entity.getiDAktivnosti());
        dto.setNaziv(entity.getNaziv());
        
        // Samo ID i naziv vrste gembe
        if (entity.getiDVrstaGem() != null) {
            VrstaGembeDTO vrstaBasic = new VrstaGembeDTO(
                entity.getiDVrstaGem().getiDVrstaGem(),
                entity.getiDVrstaGem().getNaziv()
            );
            dto.setVrstaGembe(vrstaBasic);
        }
        
        return dto;
    }
    
    /**
     * Pomoćna metoda za kreiranje entiteta samo sa ID-em (za reference)
     * Koristi se kada treba postaviti referencu na Aktivnost u drugom entitetu
     */
    public Aktivnost toEntityReference(Integer id) {
        if (id == null) {
            return null;
        }
        Aktivnost entity = new Aktivnost();
        entity.setiDAktivnosti(id);
        return entity;
    }
    
    /**
     * Pomoćna metoda za ažuriranje entiteta iz DTO-a
     * Ne ažurira ID
     */
    public void updateEntityFromDto(AktivnostDTO dto, Aktivnost entity) {
        if (dto == null || entity == null) {
            return;
        }
        
        // Ne ažuriramo ID
        entity.setNaziv(dto.getNaziv());
        
        // Napomena: VrstaGembe se ažurira posebno u servisu
    }
    
    /**
     * Pomoćna metoda za kreiranje entiteta sa VrstaGembe iz DTO-a
     * Ovo se koristi kada treba kompletno mapirati i VrstaGembe
     */
    public Aktivnost toEntityWithVrstaGembe(AktivnostDTO dto, VrstaGembe vrstaGembe) {
        if (dto == null) {
            return null;
        }
        
        Aktivnost entity = toEntity(dto);
        entity.setiDVrstaGem(vrstaGembe);
        
        return entity;
    }
}