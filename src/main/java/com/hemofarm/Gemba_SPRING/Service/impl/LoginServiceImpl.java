package com.hemofarm.Gemba_SPRING.Service.impl;

import com.hemofarm.Gemba_SPRING.DTO.KorisnikDTO;
import com.hemofarm.Gemba_SPRING.DTO.LoginDto;
import com.hemofarm.Gemba_SPRING.DTO.PasswordChangeDTO;
import com.hemofarm.Gemba_SPRING.Entity.Korisnik;
import com.hemofarm.Gemba_SPRING.Mapper.impl.KorisnikMapperImpl;
import com.hemofarm.Gemba_SPRING.Repository.KorisnikRepository;
import com.hemofarm.Gemba_SPRING.Service.LoginService;
import java.util.Date;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

@Service
public class LoginServiceImpl implements LoginService {
    
    private final KorisnikRepository korisnikRepository;
    private final KorisnikMapperImpl korisnikMapper;
   

    public LoginServiceImpl(KorisnikRepository korisnikRepository, 
                            KorisnikMapperImpl korisnikMapper) { 
        this.korisnikRepository = korisnikRepository;
        this.korisnikMapper = korisnikMapper;
        
   
       
        
    }

    @Override
    public KorisnikDTO login(LoginDto req) {
     
        if (req.getKorisnickoIme() == null || req.getKorisnickoIme().trim().isEmpty() ||
            req.getLozinka() == null || req.getLozinka().trim().isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Korisničko ime i lozinka su obavezni");
        }

       
        
        Korisnik korisnik = korisnikRepository.findByKorisnickoImeAndLozinka(
                req.getKorisnickoIme().trim(), 
                req.getLozinka().trim()  // ← DIREKTNO POREĐENJE!
            ).orElseThrow(() -> new ResponseStatusException(
                HttpStatus.UNAUTHORIZED, 
                "Pogrešno korisničko ime ili lozinka"
            ));

        
          System.out.println("Maper mapira na DTO"); 
            

    KorisnikDTO dto = korisnikMapper.toDto(korisnik);
    
    
    boolean isAdmin = dto.getRola() != null && 
                      "Administrator".equals(dto.getRola().getNaziv());
    dto.setAdmin(isAdmin);  
    
    return dto;
    }
    
    @Override
    public boolean isAdmin(KorisnikDTO korisnik) {
        return korisnik != null && 
               korisnik.getRola() != null && 
               "Administrator".equals(korisnik.getRola().getNaziv());
    }

    @Override
@Transactional
public void changePassword(Integer userId, PasswordChangeDTO passwordChange, Integer changedByUserId) {
    
    
    if (passwordChange.getNovaLozinka() == null || 
        passwordChange.getNovaLozinka().trim().isEmpty()) {
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Lozinka ne može biti prazna.");
    }
    
    if (!passwordChange.getNovaLozinka().equals(passwordChange.getPotvrdaLozinke())) {
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Lozinke se ne poklapaju.");
    }
    
    
    Korisnik userFromDB = korisnikRepository.findById(userId)
        .orElseThrow(() -> new ResponseStatusException(
            HttpStatus.NOT_FOUND, "Korisnik nije pronađen u bazi."));
    
   
    Korisnik changedByUser = korisnikRepository.findById(changedByUserId)
        .orElseThrow(() -> new ResponseStatusException(
            HttpStatus.NOT_FOUND, "Korisnik koji vrši izmenu nije pronađen."));
    
   
    userFromDB.setLozinka(passwordChange.getNovaLozinka());
    userFromDB.setDatumIzmene(new Date());
    userFromDB.setiDKorisnikIzmena(changedByUser);  
    
    korisnikRepository.save(userFromDB);
}
        
        
    }
