/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hemofarm.Gemba_SPRING.Service;

import com.hemofarm.Gemba_SPRING.DTO.KorisnikDTO;
import com.hemofarm.Gemba_SPRING.DTO.LoginDto;
import com.hemofarm.Gemba_SPRING.DTO.PasswordChangeDTO;

/**
 *
 * @author zpercinov
 */
public interface LoginService {
    
     KorisnikDTO login(LoginDto loginRequest);
     
     boolean isAdmin(KorisnikDTO korisnik);
     
     void changePassword(Integer userId, PasswordChangeDTO passwordChange, Integer changedByUserId);
     
     
     
    
    
}
