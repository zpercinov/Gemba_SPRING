/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hemofarm.Gemba_SPRING.Mapper.impl;

import com.hemofarm.Gemba_SPRING.DTO.ListaProveraAktDTO;
import com.hemofarm.Gemba_SPRING.DTO.ListaProveraAktZamerkaDTO;

import com.hemofarm.Gemba_SPRING.Entity.ListaProveraAkt;

import com.hemofarm.Gemba_SPRING.Mapper.DtoEntityMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author zpercinov
 */
@Component
public class ListaProveraAktMapperImpl implements DtoEntityMapper<ListaProveraAktDTO, ListaProveraAkt> {

    private final AktivnostMapperImpl aktivnostMapper;
    private final IshodMapperImpl ishodMapper;
    private final ListaProveraMapperImpl listaProveraMapper;
    private final ListaProveraAktZamerkaMapperImpl listaProveraAktZamerkaMapper;

    public ListaProveraAktMapperImpl(AktivnostMapperImpl aktivnostMapper,
            IshodMapperImpl ishodMapper,
            ListaProveraMapperImpl listaProveraMapper,
            ListaProveraAktZamerkaMapperImpl listaProveraAktZamerkaMapper) {
        this.aktivnostMapper = aktivnostMapper;
        this.ishodMapper = ishodMapper;
        this.listaProveraMapper = listaProveraMapper;
        this.listaProveraAktZamerkaMapper = listaProveraAktZamerkaMapper;
    }

    @Override
    public ListaProveraAktDTO toDto(ListaProveraAkt entity) {
        if (entity == null) {
            return null;
        }

        ListaProveraAktDTO dto = new ListaProveraAktDTO();

        
        dto.setIDLisProvereAkt(entity.getiDLisProvereAkt());
        dto.setUserUnos(entity.getUserUnos());
        dto.setDatumUnos(entity.getDatumUnos());
        dto.setUserIzmena(entity.getUserIzmena());
        dto.setDatumIzmena(entity.getDatumIzmena());
        dto.setHasZamerka(entity.isHasZamerka());

      
        if (entity.getiDAktivnosti() != null) {
            dto.setAktivnost(aktivnostMapper.toBasicDto(entity.getiDAktivnosti()));
        }

     
        if (entity.getiDIshod() != null) {
            dto.setIshod(ishodMapper.toBasicDto(entity.getiDIshod()));
        }

        
        if (entity.getiDLisProvere() != null) {
            dto.setListaProvera(listaProveraMapper.toBasicDto(entity.getiDLisProvere()));
        }

       
        if (entity.getListaProveraAktZamerkaCollection() != null
                && !entity.getListaProveraAktZamerkaCollection().isEmpty()) {

            List<ListaProveraAktZamerkaDTO> zamerkeDTO = entity.getListaProveraAktZamerkaCollection()
                    .stream()
                    .map(listaProveraAktZamerkaMapper::toBasicDto)
                    .collect(Collectors.toList());
            dto.setListaProveraAktZamerkaCollection(zamerkeDTO);
        }

        return dto;
    }

    @Override
    public ListaProveraAkt toEntity(ListaProveraAktDTO dto) {
        if (dto == null) {
            return null;
        }

        ListaProveraAkt entity = new ListaProveraAkt();
        entity.setiDLisProvereAkt(dto.getIDLisProvereAkt());
        entity.setUserUnos(dto.getUserUnos());
        entity.setDatumUnos(dto.getDatumUnos());
        entity.setUserIzmena(dto.getUserIzmena());
        entity.setDatumIzmena(dto.getDatumIzmena());
        entity.setHasZamerka(dto.isHasZamerka());

        return entity;
    }

    /**
     * Pomoćna metoda za osnovni DTO (bez relacionih entiteta)
     */
    public ListaProveraAktDTO toBasicDto(ListaProveraAkt entity) {
        if (entity == null) {
            return null;
        }

        ListaProveraAktDTO dto = new ListaProveraAktDTO(
                entity.getiDLisProvereAkt(),
                entity.getUserUnos(),
                entity.getDatumUnos()
        );
        dto.setHasZamerka(entity.isHasZamerka());

        return dto;
    }

    /**
     * Pomoćna metoda za DTO sa osnovnim relacionim entitetima (bez zamerki)
     */
    public ListaProveraAktDTO toDtoWithRelations(ListaProveraAkt entity) {
        if (entity == null) {
            return null;
        }

        ListaProveraAktDTO dto = toBasicDto(entity);

        if (entity.getiDAktivnosti() != null) {
            dto.setAktivnost(aktivnostMapper.toBasicDto(entity.getiDAktivnosti()));
        }

        if (entity.getiDIshod() != null) {
            dto.setIshod(ishodMapper.toBasicDto(entity.getiDIshod()));
        }

        return dto;
    }

    public List<ListaProveraAktDTO> toDtoList(List<ListaProveraAkt> entities) {
        if (entities == null) {
            return null;
        }
        return entities.stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }
}
