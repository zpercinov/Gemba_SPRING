/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.hemofarm.Gemba_SPRING.Service;

import com.hemofarm.Gemba_SPRING.DTO.KorisnikAdminDTO;
import com.hemofarm.Gemba_SPRING.DTO.RolaDTO;
import com.hemofarm.Gemba_SPRING.DTO.SajtDTO;
import java.util.List;

/**
 *
 * @author zpercinov
 */
public interface KorisnikAdminService {
    
    
    List<KorisnikAdminDTO> findAllKorisnici();
    
    KorisnikAdminDTO findKorisnikById(Integer id);
    
    List<RolaDTO> findAllRole();
    
    List<SajtDTO> findAllSajtovi();
    
    void saveKorisnik(KorisnikAdminDTO korisnikDTO, Integer loggedUserId);
    
    void deleteKorisnik(Integer id);
}
