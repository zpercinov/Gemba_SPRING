/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hemofarm.Gemba_SPRING.Mapper.impl;

import com.hemofarm.Gemba_SPRING.DTO.KorisnikDTO;
import com.hemofarm.Gemba_SPRING.DTO.RolaDTO;
import com.hemofarm.Gemba_SPRING.Entity.Korisnik;
import com.hemofarm.Gemba_SPRING.Entity.Rola;
import com.hemofarm.Gemba_SPRING.Mapper.DtoEntityMapper;
import org.springframework.stereotype.Component;

/**
 *
 * @author zpercinov
 */
@Component
public class KorisnikMapperImpl implements DtoEntityMapper<KorisnikDTO, Korisnik>{

    @Override
    public KorisnikDTO toDto(Korisnik entity) {
        if (entity == null) return null;
        
        KorisnikDTO dto = new KorisnikDTO();
        dto.setIDKorisnik(entity.getiDKorisnik()); 
        dto.setKorisnickoIme(entity.getKorisnickoIme());
        dto.setImePrezime(entity.getImePrezime());
      
        
       
        if (entity.getiDRola()!= null) {  
            RolaDTO rolaDto = new RolaDTO();
            rolaDto.setIDRole(entity.getiDRola().getIDRole());
            rolaDto.setNaziv(entity.getiDRola().getIme());
            dto.setRola(rolaDto);
        } else if (entity.getiDRola() != null) {
           
            RolaDTO rolaDto = new RolaDTO();
            rolaDto.setIDRole(entity.getiDRola().getIDRole());
            dto.setRola(rolaDto);
        }
        
      
        
        return dto;
    }

    @Override
    public Korisnik toEntity(KorisnikDTO dto) {
        if (dto == null) return null;
        
        Korisnik entity = new Korisnik();
        entity.setiDKorisnik(dto.getIDKorisnik());  
        entity.setKorisnickoIme(dto.getKorisnickoIme());
        entity.setImePrezime(dto.getImePrezime());
        
        
       
        if (dto.getRola() != null) {
            Rola rola = new Rola();
            rola.setIDRole(dto.getRola().getIDRole());
            rola.setIme(dto.getRola().getNaziv()); 
            entity.setiDRola(rola);
        }
        
       
        
        return entity;
    }
     
}