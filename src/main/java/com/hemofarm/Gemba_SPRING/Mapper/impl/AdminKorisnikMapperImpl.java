/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hemofarm.Gemba_SPRING.Mapper.impl;

import com.hemofarm.Gemba_SPRING.DTO.KorisnikAdminDTO;
import com.hemofarm.Gemba_SPRING.DTO.KorisnikDTO;
import com.hemofarm.Gemba_SPRING.DTO.RolaDTO;
import com.hemofarm.Gemba_SPRING.DTO.SajtDTO;
import com.hemofarm.Gemba_SPRING.Entity.Korisnik;
import com.hemofarm.Gemba_SPRING.Mapper.DtoEntityMapper;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

/**
 *
 * @author zpercinov
 */
@Component
public class AdminKorisnikMapperImpl implements DtoEntityMapper<KorisnikAdminDTO, Korisnik> {

   @Override
    public KorisnikAdminDTO toDto(Korisnik entity) {
        if (entity == null) return null;
        
        KorisnikAdminDTO dto = new KorisnikAdminDTO();
        dto.setiDKorisnik(entity.getiDKorisnik());
        dto.setKorisnickoIme(entity.getKorisnickoIme());
        dto.setImePrezime(entity.getImePrezime());
        dto.setLozinka(entity.getLozinka());
        dto.setDatumUnosa(entity.getDatumUnosa());
        dto.setDatumIzmene(entity.getDatumIzmene());
        
        // Mapiraj RolaDTO objekat
        if (entity.getiDRola() != null) {
            RolaDTO rolaDTO = new RolaDTO();
            rolaDTO.setIDRole(entity.getiDRola().getIDRole());
            rolaDTO.setNaziv(entity.getiDRola().getIme());  // Entity ima getIme(), DTO ima naziv
            dto.setRola(rolaDTO);
            dto.setIdRola(entity.getiDRola().getIDRole());  // za formu
        }
        
        // Mapiraj SajtDTO objekat
        if (entity.getiDSite() != null) {
            SajtDTO sajtDTO = new SajtDTO();
            sajtDTO.setIDSajt(entity.getiDSite().getiDSajt());
            sajtDTO.setIme(entity.getiDSite().getIme());
            dto.setSajt(sajtDTO);
            dto.setIdSajt(entity.getiDSite().getiDSajt());  // za formu
        }
        
        // Mapiraj korisnika koji je uneo
        if (entity.getiDKorisnikUnos() != null) {
            KorisnikDTO unosDTO = new KorisnikDTO();
            unosDTO.setIDKorisnik(entity.getiDKorisnikUnos().getiDKorisnik());
            unosDTO.setKorisnickoIme(entity.getiDKorisnikUnos().getKorisnickoIme());
            dto.setKorisnikUnos(unosDTO);
        }
        
        // Mapiraj korisnika koji je izmenio
        if (entity.getiDKorisnikIzmena() != null) {
            KorisnikDTO izmenaDTO = new KorisnikDTO();
            izmenaDTO.setIDKorisnik(entity.getiDKorisnikIzmena().getiDKorisnik());
            izmenaDTO.setKorisnickoIme(entity.getiDKorisnikIzmena().getKorisnickoIme());
            dto.setKorisnikIzmena(izmenaDTO);
        }
        
        return dto;
    }

    @Override
    public Korisnik toEntity(KorisnikAdminDTO dto) {
        if (dto == null) return null;
        
        Korisnik entity = new Korisnik();
        entity.setiDKorisnik(dto.getiDKorisnik());
        entity.setKorisnickoIme(dto.getKorisnickoIme());
        entity.setImePrezime(dto.getImePrezime());
        entity.setLozinka(dto.getLozinka());
        
       
        return entity;
    }
    
    // Dodatne metode za rad sa listama (opciono)
    public List<KorisnikAdminDTO> toDtoList(List<Korisnik> entities) {
        if (entities == null) return null;
        return entities.stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }
    
   
}
