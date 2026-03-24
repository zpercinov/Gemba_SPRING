/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hemofarm.Gemba_SPRING.Mapper.impl;


import com.hemofarm.Gemba_SPRING.DTO.OdeljenjeDTO;
import com.hemofarm.Gemba_SPRING.Entity.Funkcija;

import com.hemofarm.Gemba_SPRING.Entity.Odeljenje;
import com.hemofarm.Gemba_SPRING.Mapper.DtoEntityMapper;
import org.springframework.stereotype.Component;
import org.springframework.context.annotation.Lazy;

/**
 *
 * @author zpercinov
 */
@Component
public class OdeljenjeMapperImpl implements DtoEntityMapper<OdeljenjeDTO, Odeljenje> {  

    private final FunkcijaMapperImpl funkcijaMapper;
    private final ListaProveraMapperImpl listaProveraMapper;

    public OdeljenjeMapperImpl( @Lazy FunkcijaMapperImpl funkcijaMapper,
                          @Lazy ListaProveraMapperImpl listaProveraMapper) {
        this.funkcijaMapper = funkcijaMapper;
        this.listaProveraMapper = listaProveraMapper;
    }

    @Override
    public OdeljenjeDTO toDto(Odeljenje entity) {  
        if (entity == null) {
            return null;
        }
        
        OdeljenjeDTO dto = new OdeljenjeDTO();
        
       
        dto.setIDOdeljenje(entity.getiDOdeljenje());
        dto.setIme(entity.getIme());
        dto.setIdFun(entity.getiDFun());
        
    
        
      
        
        return dto;
    }

    @Override
    public Odeljenje toEntity(OdeljenjeDTO dto) {  
        if (dto == null) {
            return null;
        }
        
        Odeljenje entity = new Odeljenje();
        
        // Osnovna polja
        entity.setiDOdeljenje(dto.getIDOdeljenje());
        entity.setIme(dto.getIme());
        entity.setiDFun(dto.getIdFun());
        
     
        
        return entity;
    }
    
    /**
     * Pomoćna metoda za osnovni DTO (bez kolekcije provera)
     * Ovo je najčešće korišćena metoda za liste
     */
    public OdeljenjeDTO toBasicDto(Odeljenje entity) {
        if (entity == null) {
            return null;
        }
        
        return new OdeljenjeDTO(
            entity.getiDOdeljenje(),
            entity.getIme(),
            entity.getiDFun()
        );
    }
    
    /**
     * Pomoćna metoda za DTO sa statistikom (bez cele kolekcije)
     * Korisno za prikaz broja provera bez učitavanja svih podataka
     */
    public OdeljenjeDTO toDtoWithStats(Odeljenje entity) {
        if (entity == null) {
            return null;
        }
        
        OdeljenjeDTO dto = toBasicDto(entity);
        
        if (entity.getListaProveraCollection() != null) {
            // Ne učitavamo celu kolekciju
            // Statistika se može izračunati posebnim upitom
        }
        
        return dto;
    }
    
    /**
     * Pomoćna metoda za DTO sa funkcijom (ako je dostupna)
     * Ovo zahteva da se Funkcija entity dohvati posebno
     */
    public OdeljenjeDTO toDtoWithFunkcija(Odeljenje entity, Funkcija funkcija) {
        if (entity == null) {
            return null;
        }
        
        OdeljenjeDTO dto = toBasicDto(entity);
        
        if (funkcija != null) {
            dto.setFunkcija(funkcijaMapper.toBasicDto(funkcija));
        }
        
        return dto;
    }
    
    /**
     * Pomoćna metoda za kreiranje entiteta samo sa ID-em (za reference)
     * Koristi se kada treba postaviti referencu na Odeljenje u drugom entitetu
     */
    public Odeljenje toEntityReference(Integer id) {
        if (id == null) {
            return null;
        }
        Odeljenje entity = new Odeljenje();
        entity.setiDOdeljenje(id);
        return entity;
    }
    
    /**
     * Pomoćna metoda za ažuriranje entiteta iz DTO-a
     * Ne ažurira ID i kolekciju
     */
    public void updateEntityFromDto(OdeljenjeDTO dto, Odeljenje entity) {
        if (dto == null || entity == null) {
            return;
        }
        
        // Ne ažuriramo ID
        entity.setIme(dto.getIme());
        entity.setiDFun(dto.getIdFun());
        
      
    }
}