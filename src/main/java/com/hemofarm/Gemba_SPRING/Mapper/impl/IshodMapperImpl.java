/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hemofarm.Gemba_SPRING.Mapper.impl;

import com.hemofarm.Gemba_SPRING.DTO.IshodDTO;
import com.hemofarm.Gemba_SPRING.DTO.ListaProveraAktDTO;
import com.hemofarm.Gemba_SPRING.Entity.Ishod;
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
public class IshodMapperImpl implements DtoEntityMapper<IshodDTO, Ishod> {  

    private final ListaProveraAktMapperImpl listaProveraAktMapper;

    public IshodMapperImpl(@Lazy ListaProveraAktMapperImpl listaProveraAktMapper) {
        this.listaProveraAktMapper = listaProveraAktMapper;
    }

    @Override
    public IshodDTO toDto(Ishod entity) {  
        if (entity == null) {
            return null;
        }
        
        IshodDTO dto = new IshodDTO();
        
       
        dto.setIDIshod(entity.getiDIshod());
        dto.setNaziv(entity.getNaziv());
        
       
        if (entity.getListaProveraAktCollection() != null && !entity.getListaProveraAktCollection().isEmpty()) {
            List<ListaProveraAktDTO> aktivnostiDTO = entity.getListaProveraAktCollection()
                    .stream()
                    .map(listaProveraAktMapper::toBasicDto)  // Koristimo basic da izbegnemo ciklus
                    .collect(Collectors.toList());
            dto.setListaProveraAktCollection(aktivnostiDTO);
        }
        
        return dto;
    }

    @Override
    public Ishod toEntity(IshodDTO dto) { 
        if (dto == null) {
            return null;
        }
        
        Ishod entity = new Ishod();
        
        // Osnovna polja
        entity.setiDIshod(dto.getIDIshod());
        entity.setNaziv(dto.getNaziv());
        
      
        
        return entity;
    }
    
    /**
     * Pomoćna metoda za osnovni DTO (bez kolekcije aktivnosti)
     * Ovo je najčešće korišćena metoda za liste
     */
    public IshodDTO toBasicDto(Ishod entity) {
        if (entity == null) {
            return null;
        }
        
        return new IshodDTO(
            entity.getiDIshod(),
            entity.getNaziv()
        );
    }
    
    /**
     * Pomoćna metoda za DTO sa brojem aktivnosti (bez cele kolekcije)
     * Korisno za prikaz statistike bez učitavanja svih podataka
     */
    public IshodDTO toDtoWithCount(Ishod entity) {
        if (entity == null) {
            return null;
        }
        
        IshodDTO dto = toBasicDto(entity);
        
        if (entity.getListaProveraAktCollection() != null) {
            // Ne učitavamo celu kolekciju, ali možemo izračunati broj
            // dto.setBrojAktivnosti(entity.getListaProveraAktCollection().size()); // Već imate getBrojAktivnosti()
        }
        
        return dto;
    }
    
    /**
     * Pomoćna metoda za DTO sa statistikom po statusu
     * Ovo može biti korisno za izveštaje
     */
    public IshodDTO toDtoWithStats(Ishod entity, long brojAktivnosti, long brojZavrsenih) {
        if (entity == null) {
            return null;
        }
        
        IshodDTO dto = toBasicDto(entity);
        
        // Ovo zahteva da dodate polja u DTO za statistiku
        // dto.setBrojAktivnosti(brojAktivnosti);
        // dto.setBrojZavrsenih(brojZavrsenih);
        
        return dto;
    }
    
    /**
     * Pomoćna metoda za kreiranje entiteta samo sa ID-em (za reference)
     * Koristi se kada treba postaviti referencu na Ishod u drugom entitetu
     */
    public Ishod toEntityReference(Integer id) {
        if (id == null) {
            return null;
        }
        Ishod entity = new Ishod();
        entity.setiDIshod(id);
        return entity;
    }
    
    /**
     * Pomoćna metoda za ažuriranje entiteta iz DTO-a
     * Ne ažurira ID i kolekciju
     */
    public void updateEntityFromDto(IshodDTO dto, Ishod entity) {
        if (dto == null || entity == null) {
            return;
        }
        
     
        entity.setNaziv(dto.getNaziv());
        
      
    }
}