/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hemofarm.Gemba_SPRING.Service.impl;

import com.hemofarm.Gemba_SPRING.DTO.KorisnikAdminDTO;
import com.hemofarm.Gemba_SPRING.DTO.RolaDTO;
import com.hemofarm.Gemba_SPRING.DTO.SajtDTO;
import com.hemofarm.Gemba_SPRING.Entity.Korisnik;
import com.hemofarm.Gemba_SPRING.Entity.Rola;
import com.hemofarm.Gemba_SPRING.Entity.Sajt;
import com.hemofarm.Gemba_SPRING.Mapper.impl.AdminKorisnikMapperImpl;
import com.hemofarm.Gemba_SPRING.Repository.KorisnikRepository;
import com.hemofarm.Gemba_SPRING.Repository.RolaRepository;
import com.hemofarm.Gemba_SPRING.Repository.SajtRepository;
import com.hemofarm.Gemba_SPRING.Service.KorisnikAdminService;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

/**
 *
 * @author zpercinov
 */
@Service
public class KorisnikAdminServiceImpl implements KorisnikAdminService {

    private final KorisnikRepository korisnikRepository;
    private final RolaRepository rolaRepository;
    private final SajtRepository sajtRepository;
    private final AdminKorisnikMapperImpl adminKorisnikMapper;  

    public KorisnikAdminServiceImpl(KorisnikRepository korisnikRepository,
                                    RolaRepository rolaRepository,
                                    SajtRepository sajtRepository,
                                    AdminKorisnikMapperImpl adminKorisnikMapper) {  
        this.korisnikRepository = korisnikRepository;
        this.rolaRepository = rolaRepository;
        this.sajtRepository = sajtRepository;
        this.adminKorisnikMapper = adminKorisnikMapper;  
    }

    @Override
    public List<KorisnikAdminDTO> findAllKorisnici() {
        List<Korisnik> korisnici = korisnikRepository.findAll();
        return adminKorisnikMapper.toDtoList(korisnici); 
    }

    @Override
    public KorisnikAdminDTO findKorisnikById(Integer id) {
        Korisnik korisnik = korisnikRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Korisnik nije pronađen"));
        return adminKorisnikMapper.toDto(korisnik);  
    }

    @Override
public List<RolaDTO> findAllRole() {
    return rolaRepository.findAll().stream()
            .map(r -> {
                RolaDTO dto = new RolaDTO();
                dto.setIDRole(r.getIDRole());  
                dto.setNaziv(r.getIme());
                return dto;
            })
            .collect(Collectors.toList());
}

    @Override
    public List<SajtDTO> findAllSajtovi() {
        return sajtRepository.findAll().stream()
                .map(s -> new SajtDTO(s.getiDSajt(), s.getIme()))
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void saveKorisnik(KorisnikAdminDTO korisnikDTO, Integer loggedUserId) {
        // Validacija
        if (korisnikDTO.getKorisnickoIme() == null || korisnikDTO.getKorisnickoIme().trim().isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Korisničko ime je obavezno");
        }
        
        if (korisnikDTO.getLozinka() == null || korisnikDTO.getLozinka().trim().isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Lozinka je obavezna");
        }
        
        // Provera duplikata (samo za novog korisnika)
        if (korisnikDTO.getiDKorisnik() == null) {
            boolean exists = korisnikRepository.existsByKorisnickoIme(korisnikDTO.getKorisnickoIme());
            if (exists) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, 
                    "Korisničko ime već postoji");
            }
        }
        
        // Pronađi logged user
        Korisnik loggedUser = korisnikRepository.findById(loggedUserId)
                .orElseThrow(() -> new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Korisnik nije pronađen"));
        
        
        Korisnik korisnik;
        if (korisnikDTO.getiDKorisnik() != null) {
            // Izmena - dohvati postojećeg
            korisnik = korisnikRepository.findById(korisnikDTO.getiDKorisnik())
                    .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Korisnik nije pronađen"));
            korisnik.setDatumIzmene(new Date());
            korisnik.setiDKorisnikIzmena(loggedUser);
        } else {
            // Novi korisnik
            korisnik = adminKorisnikMapper.toEntity(korisnikDTO);  // ← KORISTI MAPPER
            korisnik.setDatumUnosa(new Date());
            korisnik.setiDKorisnikUnos(loggedUser);
        }
        
       
        korisnik.setKorisnickoIme(korisnikDTO.getKorisnickoIme());
        korisnik.setImePrezime(korisnikDTO.getImePrezime());
        
        // Lozinka se menja samo ako je poslata nova
        if (korisnikDTO.getLozinka() != null && !korisnikDTO.getLozinka().trim().isEmpty()) {
            korisnik.setLozinka(korisnikDTO.getLozinka());
        }
        
        // Postavi relacije
        if (korisnikDTO.getIdRola() != null) {
            Rola rola = rolaRepository.findById(korisnikDTO.getIdRola())
                    .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.BAD_REQUEST, "Rola nije pronađena"));
            korisnik.setiDRola(rola);
        }
        
        if (korisnikDTO.getIdSajt() != null) {
            Sajt sajt = sajtRepository.findById(korisnikDTO.getIdSajt())
                    .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.BAD_REQUEST, "Sajt nije pronađen"));
            korisnik.setiDSite(sajt);
        }
        
        korisnikRepository.save(korisnik);
    }

    @Override
    @Transactional
    public void deleteKorisnik(Integer id) {
        // Proveri da li korisnik postoji
        Korisnik korisnik = korisnikRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Korisnik nije pronađen"));
        
        korisnikRepository.deleteById(id);
    }
}