/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hemofarm.Gemba_SPRING.Controller;

import com.hemofarm.Gemba_SPRING.DTO.KorisnikDTO;
import com.hemofarm.Gemba_SPRING.DTO.PasswordChangeDTO;
import com.hemofarm.Gemba_SPRING.Service.LoginService;
import com.hemofarm.Gemba_SPRING.util.EnumActionMode;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.server.ResponseStatusException;

/**
 *
 * @author zpercinov
 */
@Controller
@RequestMapping("/profile")
public class ProfileController {
    
   private final LoginService loginService;

   

    public ProfileController(LoginService loginService) {
        this.loginService = loginService;
    }
    
    
    @PostMapping
    public String profil(HttpSession session, Model model) {
 
            KorisnikDTO loggedUser = (KorisnikDTO) session.getAttribute("loggedUser");
            
                if (loggedUser == null) {
      
        return "redirect:/login";
    }
        
       
        model.addAttribute("korisnik", loggedUser);
        model.addAttribute("actionMode", EnumActionMode.PROFIL);
        
        return "profile"; 
    }
    
  @PostMapping("/password/save")
public String savePassword(@ModelAttribute PasswordChangeDTO passwordChange,
                          HttpSession session, 
                          Model model) {
    
    KorisnikDTO loggedUser = (KorisnikDTO) session.getAttribute("loggedUser");
    
    if (loggedUser == null) {
        return "redirect:/login";
    }
    
    try {
        loginService.changePassword(
            loggedUser.getIDKorisnik(), 
            passwordChange, 
            loggedUser.getIDKorisnik()
        );
        
        model.addAttribute("successMessage", "Lozinka je uspešno promenjena.");
        
    } catch (ResponseStatusException e) {
 
        model.addAttribute("errorMessage", e.getReason());  
        
      
        
    } catch (Exception e) {
        e.printStackTrace();
        model.addAttribute("errorMessage", "Greška prilikom promene lozinke.");
    }
    
    // Ponovo učitaj korisnika (osveženo)
    model.addAttribute("korisnik", loggedUser);
    model.addAttribute("actionMode", EnumActionMode.PROFIL);
    
    return "profile";
}
    
    
    
}
