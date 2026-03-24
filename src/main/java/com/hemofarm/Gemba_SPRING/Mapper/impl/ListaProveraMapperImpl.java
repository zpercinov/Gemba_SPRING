/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hemofarm.Gemba_SPRING.Mapper.impl;


import com.hemofarm.Gemba_SPRING.DTO.ListaProveraDTO;
import com.hemofarm.Gemba_SPRING.Entity.ListaProvera;

import com.hemofarm.Gemba_SPRING.Mapper.DtoEntityMapper;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

/**
 *
 * @author zpercinov
 */
@Component
public class ListaProveraMapperImpl implements DtoEntityMapper<ListaProveraDTO, ListaProvera> {  

    private final KlasterMapperImpl klasterMapper;
    private final FunkcijaMapperImpl funkcijaMapper;
    private final NosilacMapperImpl nosilacMapper;
    private final VrstaGembeMapperImpl vrstaGembeMapper;
    private final OdeljenjeMapperImpl odeljenjeMapper;
    private final SajtMapperImpl sajtMapper;
    private final ListaProveraAktMapperImpl listaProveraAktMapper;

    public ListaProveraMapperImpl(@Lazy KlasterMapperImpl klasterMapper,
                              @Lazy FunkcijaMapperImpl funkcijaMapper,
                              @Lazy NosilacMapperImpl nosilacMapper,
                              @Lazy VrstaGembeMapperImpl vrstaGembeMapper,
                              @Lazy OdeljenjeMapperImpl odeljenjeMapper,
                              @Lazy SajtMapperImpl sajtMapper,
                              @Lazy ListaProveraAktMapperImpl listaProveraAktMapper) {
        this.klasterMapper = klasterMapper;
        this.funkcijaMapper = funkcijaMapper;
        this.nosilacMapper = nosilacMapper;
        this.vrstaGembeMapper = vrstaGembeMapper;
        this.odeljenjeMapper = odeljenjeMapper;
        this.sajtMapper = sajtMapper;
        this.listaProveraAktMapper = listaProveraAktMapper;
    }

    @Override
    public ListaProveraDTO toDto(ListaProvera entity) {  
        if (entity == null) {
            return null;
        }
        
        ListaProveraDTO dto = new ListaProveraDTO();
       
        // Osnovna polja
        dto.setiDLisProvere(entity.getiDLisProvere());
        dto.setDatum(entity.getDatum());
        dto.setUserUnos(entity.getUserUnos());
        dto.setDatumUnos(entity.getDatumUnos());
        dto.setUserIzmena(entity.getUserIzmena());
        dto.setDatumIzmena(entity.getDatumIzmena());
        dto.setStatus(entity.getStatus());
        
       
        if (entity.getiDCluster() != null) {
            dto.setKlaster(klasterMapper.toBasicDto(entity.getiDCluster()));
        }
        
        if (entity.getiDFun() != null) {
            dto.setFunkcija(funkcijaMapper.toBasicDto(entity.getiDFun()));
        }
        
        if (entity.getiDNos() != null) {
            dto.setNosilac(nosilacMapper.toBasicDto(entity.getiDNos()));
        }
        
        if (entity.getiDVrstaGem() != null) {
            dto.setVrstaGembe(vrstaGembeMapper.toBasicDto(entity.getiDVrstaGem()));
        }
        
        if (entity.getiDOdeljenje() != null) {
            dto.setOdeljenje(odeljenjeMapper.toBasicDto(entity.getiDOdeljenje()));
        }
        
        if (entity.getiDSajt() != null) {
            dto.setSajt(sajtMapper.toBasicDto(entity.getiDSajt()));
        }
        
        return dto;  
    }

    @Override
    public ListaProvera toEntity(ListaProveraDTO dto) {  
        if (dto == null) {
            return null;
        }
        
        ListaProvera entity = new ListaProvera();
        
        // Osnovna polja
        entity.setiDLisProvere(dto.getiDLisProvere());
        entity.setDatum(dto.getDatum());
        entity.setUserUnos(dto.getUserUnos());
        entity.setDatumUnos(dto.getDatumUnos());
        entity.setUserIzmena(dto.getUserIzmena());
        entity.setDatumIzmena(dto.getDatumIzmena());
        entity.setStatus(dto.getStatus());
        
        
        
        return entity;
    }
    
    /**
     * Pomoćna metoda za osnovni DTO (bez relacionih entiteta)
     */
    public ListaProveraDTO toBasicDto(ListaProvera entity) {
        if (entity == null) {
            return null;
        }
        
        ListaProveraDTO dto = new ListaProveraDTO();
        dto.setiDLisProvere(entity.getiDLisProvere());
        dto.setDatum(entity.getDatum());
        dto.setUserUnos(entity.getUserUnos());
        dto.setDatumUnos(entity.getDatumUnos());
        dto.setUserIzmena(entity.getUserIzmena());
        dto.setDatumIzmena(entity.getDatumIzmena());
        dto.setStatus(entity.getStatus());
        
        return dto;
    }
}