/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hemofarm.Gemba_SPRING.Mapper.impl;


import com.hemofarm.Gemba_SPRING.DTO.ListaProveraAktZamerkaDTO;
import com.hemofarm.Gemba_SPRING.DTO.ZamerkaDTO;
import com.hemofarm.Gemba_SPRING.Entity.ListaProveraAkt;
import com.hemofarm.Gemba_SPRING.Entity.ListaProveraAktZamerka;
import com.hemofarm.Gemba_SPRING.Entity.Zamerka;
import com.hemofarm.Gemba_SPRING.Mapper.DtoEntityMapper;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

/**
 *
 * @author zpercinov
 */
@Component
public class ListaProveraAktZamerkaMapperImpl implements DtoEntityMapper<ListaProveraAktZamerkaDTO, ListaProveraAktZamerka> {  // DTO, pa Entity

    private final ListaProveraAktMapperImpl listaProveraAktMapper;
    private final ZamerkaMapperImpl zamerkaMapper;

    public ListaProveraAktZamerkaMapperImpl(@Lazy ListaProveraAktMapperImpl listaProveraAktMapper,
                                       @Lazy ZamerkaMapperImpl zamerkaMapper) {
        this.listaProveraAktMapper = listaProveraAktMapper;
        this.zamerkaMapper = zamerkaMapper;
    }

    @Override
    public ListaProveraAktZamerkaDTO toDto(ListaProveraAktZamerka entity) { 
        if (entity == null) {
            return null;
        }
        
        ListaProveraAktZamerkaDTO dto = new ListaProveraAktZamerkaDTO();
        
      
        dto.setIDLisProvereAktZamerka(entity.getiDLisProvereAktZamerka());
        dto.setNapomena(entity.getNapomena());
        dto.setUserUnos(entity.getUserUnos());
        dto.setDatumUnos(entity.getDatumUnos());
        dto.setUserIzmena(entity.getUserIzmena());
        dto.setDatumIzmena(entity.getDatumIzmena());
        
        
        if (entity.getiDLisProvereAkt() != null) {
            dto.setListaProveraAkt(listaProveraAktMapper.toBasicDto(entity.getiDLisProvereAkt()));
        }
        
     
        if (entity.getiDZamerka() != null) {
            dto.setZamerka(zamerkaMapper.toBasicDto(entity.getiDZamerka()));
        }
        
        return dto;
    }

    @Override
    public ListaProveraAktZamerka toEntity(ListaProveraAktZamerkaDTO dto) {  
        if (dto == null) {
            return null;
        }
        
        ListaProveraAktZamerka entity = new ListaProveraAktZamerka();
        
        
        entity.setiDLisProvereAktZamerka(dto.getIDLisProvereAktZamerka());
        entity.setNapomena(dto.getNapomena());
        entity.setUserUnos(dto.getUserUnos());
        entity.setDatumUnos(dto.getDatumUnos());
        entity.setUserIzmena(dto.getUserIzmena());
        entity.setDatumIzmena(dto.getDatumIzmena());
        
       
        
        return entity;
    }
    
    /**
     * Pomoćna metoda za osnovni DTO (bez relacionih entiteta)
     * Ovo je najčešće korišćena metoda za liste
     */
    public ListaProveraAktZamerkaDTO toBasicDto(ListaProveraAktZamerka entity) {
        if (entity == null) {
            return null;
        }
        
        ListaProveraAktZamerkaDTO dto = new ListaProveraAktZamerkaDTO(
            entity.getiDLisProvereAktZamerka(),
            entity.getUserUnos(),
            entity.getDatumUnos()
        );
        
       
        dto.setNapomena(entity.getNapomena());
        
        return dto;
    }
    
    /**
     * Pomoćna metoda za DTO sa osnovnim relacionim entitetima (bez detalja)
     * Korisno za prikaz osnovnih informacija
     */
    public ListaProveraAktZamerkaDTO toDtoWithRelations(ListaProveraAktZamerka entity) {
        if (entity == null) {
            return null;
        }
        
        ListaProveraAktZamerkaDTO dto = toBasicDto(entity);
        
        if (entity.getiDZamerka() != null) {
            // Samo ID i naziv zamerke
            ZamerkaDTO zamerkaBasic = new ZamerkaDTO();
            zamerkaBasic.setIDZamerka(entity.getiDZamerka().getiDZamerka());
            zamerkaBasic.setNaziv(entity.getiDZamerka().getNaziv());
            dto.setZamerka(zamerkaBasic);
        }
        
        return dto;
    }
    
    /**
     * Pomoćna metoda za DTO sa svim relacionim podacima
     */
    public ListaProveraAktZamerkaDTO toDtoWithAllRelations(ListaProveraAktZamerka entity,
                                                          ListaProveraAkt listaProveraAkt,
                                                          Zamerka zamerka) {
        if (entity == null) {
            return null;
        }
        
        ListaProveraAktZamerkaDTO dto = toBasicDto(entity);
        
        if (listaProveraAkt != null) {
            dto.setListaProveraAkt(listaProveraAktMapper.toBasicDto(listaProveraAkt));
        }
        
        if (zamerka != null) {
            dto.setZamerka(zamerkaMapper.toBasicDto(zamerka));
        }
        
        return dto;
    }
    
    /**
     * Pomoćna metoda za kreiranje entiteta samo sa ID-em (za reference)
     */
    public ListaProveraAktZamerka toEntityReference(Integer id) {
        if (id == null) {
            return null;
        }
        ListaProveraAktZamerka entity = new ListaProveraAktZamerka();
        entity.setiDLisProvereAktZamerka(id);
        return entity;
    }
    
    /**
     * Pomoćna metoda za ažuriranje entiteta iz DTO-a
     * Ne ažurira ID
     */
    public void updateEntityFromDto(ListaProveraAktZamerkaDTO dto, ListaProveraAktZamerka entity) {
        if (dto == null || entity == null) {
            return;
        }
        
       
        entity.setNapomena(dto.getNapomena());
        entity.setUserUnos(dto.getUserUnos());
        entity.setDatumUnos(dto.getDatumUnos());
        entity.setUserIzmena(dto.getUserIzmena());
        entity.setDatumIzmena(dto.getDatumIzmena());
       
    }
    
    /**
     * Pomoćna metoda za kreiranje DTO sa kratkim opisom
     */
    public ListaProveraAktZamerkaDTO toDtoWithShortDescription(ListaProveraAktZamerka entity) {
        if (entity == null) {
            return null;
        }
        
        ListaProveraAktZamerkaDTO dto = toBasicDto(entity);
        
       
        
        return dto;
    }
}