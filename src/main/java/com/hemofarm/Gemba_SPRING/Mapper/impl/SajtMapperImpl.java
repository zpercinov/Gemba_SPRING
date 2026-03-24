/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hemofarm.Gemba_SPRING.Mapper.impl;


import com.hemofarm.Gemba_SPRING.DTO.SajtDTO;
import com.hemofarm.Gemba_SPRING.Entity.Klaster;
import com.hemofarm.Gemba_SPRING.Entity.Korisnik;
import com.hemofarm.Gemba_SPRING.Entity.ListaProvera;
import com.hemofarm.Gemba_SPRING.Entity.Sajt;
import com.hemofarm.Gemba_SPRING.Mapper.DtoEntityMapper;
import org.springframework.stereotype.Component;
import java.util.List;
import org.springframework.context.annotation.Lazy;

/**
 *
 * @author zpercinov
 */
@Component
public class SajtMapperImpl implements DtoEntityMapper<SajtDTO, Sajt> {  

    private final KlasterMapperImpl klasterMapper;
    private final ListaProveraMapperImpl listaProveraMapper;
    private final KorisnikMapperImpl korisnikMapper;

    public SajtMapperImpl( @Lazy KlasterMapperImpl klasterMapper,
                     @Lazy ListaProveraMapperImpl listaProveraMapper,
                     @Lazy KorisnikMapperImpl korisnikMapper) {
        this.klasterMapper = klasterMapper;
        this.listaProveraMapper = listaProveraMapper;
        this.korisnikMapper = korisnikMapper;
    }

    @Override
    public SajtDTO toDto(Sajt entity) {  
        if (entity == null) {
            return null;
        }
        
        SajtDTO dto = new SajtDTO();
        
        // Osnovna polja
        dto.setIDSajt(entity.getiDSajt());
        dto.setIme(entity.getIme());
        dto.setIdKlaster(entity.getiDCluster());
        
  
        
       
        
        return dto;
    }

    @Override
    public Sajt toEntity(SajtDTO dto) {  
        if (dto == null) {
            return null;
        }
        
        Sajt entity = new Sajt();
        
       
        entity.setiDSajt(dto.getIDSajt());
        entity.setIme(dto.getIme());
        entity.setiDCluster(dto.getIdKlaster());
        
     
        
        return entity;
    }
    
    /**
     * Pomoćna metoda za osnovni DTO (bez kolekcija)
     * Ovo je najčešće korišćena metoda za liste
     */
    public SajtDTO toBasicDto(Sajt entity) {
        if (entity == null) {
            return null;
        }
        
        return new SajtDTO(
            entity.getiDSajt(),
            entity.getIme(),
            entity.getiDCluster()
        );
    }
    
    /**
     * Pomoćna metoda za DTO sa statistikom (bez celih kolekcija)
     * Korisno za prikaz broja provera i korisnika bez učitavanja svih podataka
     */
    public SajtDTO toDtoWithStats(Sajt entity) {
        if (entity == null) {
            return null;
        }
        
        SajtDTO dto = toBasicDto(entity);
        
        if (entity.getListaProveraCollection() != null) {
          
        }
        
        if (entity.getKorisnikCollection() != null) {
            
        }
        
        return dto;
    }
    
    /**
     * Pomoćna metoda za DTO sa klasterom (ako je dostupan)
     * Ovo zahteva da se Klaster entity dohvati posebno
     */
    public SajtDTO toDtoWithKlaster(Sajt entity, Klaster klaster) {
        if (entity == null) {
            return null;
        }
        
        SajtDTO dto = toBasicDto(entity);
        
        if (klaster != null) {
            dto.setKlaster(klasterMapper.toBasicDto(klaster));
        }
        
        return dto;
    }
    
    /**
     * Pomoćna metoda za DTO sa svim relacionim podacima
     * Ovo zahteva posebne upite za svaku kolekciju
     */
    public SajtDTO toDtoWithAllRelations(Sajt entity, 
                                         Klaster klaster,
                                         List<ListaProvera> provere,
                                         List<Korisnik> korisnici) {
        if (entity == null) {
            return null;
        }
        
        SajtDTO dto = toBasicDto(entity);
        
        if (klaster != null) {
            dto.setKlaster(klasterMapper.toBasicDto(klaster));
        }
        
       
        
        return dto;
    }
    
    /**
     * Pomoćna metoda za kreiranje entiteta samo sa ID-em (za reference)
     * Koristi se kada treba postaviti referencu na Sajt u drugom entitetu
     */
    public Sajt toEntityReference(Integer id) {
        if (id == null) {
            return null;
        }
        Sajt entity = new Sajt();
        entity.setiDSajt(id);
        return entity;
    }
    
    /**
     * Pomoćna metoda za ažuriranje entiteta iz DTO-a
     */
    public void updateEntityFromDto(SajtDTO dto, Sajt entity) {
        if (dto == null || entity == null) {
            return;
        }
        
      
        entity.setIme(dto.getIme());
        entity.setiDCluster(dto.getIdKlaster());
        
       
    }
}