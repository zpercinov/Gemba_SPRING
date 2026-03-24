/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hemofarm.Gemba_SPRING.Controller;

import com.hemofarm.Gemba_SPRING.DTO.KorisnikAdminDTO;
import com.hemofarm.Gemba_SPRING.DTO.KorisnikDTO;
import com.hemofarm.Gemba_SPRING.DTO.RolaDTO;
import com.hemofarm.Gemba_SPRING.DTO.SajtDTO;
import com.hemofarm.Gemba_SPRING.Service.KorisnikAdminService;
import com.hemofarm.Gemba_SPRING.util.EnumActionMode;
import jakarta.servlet.http.HttpSession;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author zpercinov
 */
@Controller
@RequestMapping("/administration")
public class AdministrationController {

    private final KorisnikAdminService korisnikAdminService;

    public AdministrationController(KorisnikAdminService korisnikAdminService) {
        this.korisnikAdminService = korisnikAdminService;
    }

    // OBA METODA - i GET i POST za istu stranu
    @GetMapping
    public String adminPageGet(HttpSession session, Model model) {
        return showAdminPage(session, model);
    }
    
    @PostMapping
    public String adminPagePost(HttpSession session, Model model) {
        return showAdminPage(session, model);
    }
    
    // Zajednička metoda za prikaz stranice
    private String showAdminPage(HttpSession session, Model model) {
        KorisnikDTO loggedUser = (KorisnikDTO) session.getAttribute("loggedUser");
        
        if (loggedUser == null) {
            return "redirect:/login";
        }
        
        // Proveri da li je admin
        if (!loggedUser.isAdmin()) {
            return "redirect:/dashboard";
        }
        
        try {
            // Učitaj podatke
            List<KorisnikAdminDTO> korisnici = korisnikAdminService.findAllKorisnici();
            List<RolaDTO> role = korisnikAdminService.findAllRole();
            List<SajtDTO> sajtovi = korisnikAdminService.findAllSajtovi();
            
            model.addAttribute("korisnici", korisnici);
            model.addAttribute("role", role);
            model.addAttribute("sajtovi", sajtovi);
            model.addAttribute("actionMode", EnumActionMode.ADMINISTRACIJA);
            model.addAttribute("korisnik", loggedUser);
            
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("errorMessage", "Greška pri učitavanju podataka: " + e.getMessage());
        }
        
        session.setAttribute("isAdmin", loggedUser.isAdmin());
        return "administration";
    }
    
    @PostMapping("/edit")
    public String editKorisnik(@RequestParam Integer id, 
                               HttpSession session, 
                               Model model,
                               RedirectAttributes redirectAttributes) {
        
        KorisnikDTO loggedUser = (KorisnikDTO) session.getAttribute("loggedUser");
        
        if (loggedUser == null) {
            return "redirect:/login";
        }
        
        if (!loggedUser.isAdmin()) {
            return "redirect:/dashboard";
        }
        
        try {
            // Dohvati korisnika za izmenu
            KorisnikAdminDTO korisnik = korisnikAdminService.findKorisnikById(id);
            
            // Dohvati role i sajtove za padajuće liste
            List<RolaDTO> role = korisnikAdminService.findAllRole();
            List<SajtDTO> sajtovi = korisnikAdminService.findAllSajtovi();
            List<KorisnikAdminDTO> korisnici = korisnikAdminService.findAllKorisnici();
            
            // Postavi vrednosti za formu
            model.addAttribute("korisnickoIme", korisnik.getKorisnickoIme());
            model.addAttribute("imePrezime", korisnik.getImePrezime());
            model.addAttribute("lozinka", korisnik.getLozinka());
            model.addAttribute("idRola", korisnik.getIdRola());
            model.addAttribute("idSajt", korisnik.getIdSajt());
            model.addAttribute("idKorisnika", korisnik.getiDKorisnik());
            
            model.addAttribute("korisnici", korisnici);
            model.addAttribute("role", role);
            model.addAttribute("sajtovi", sajtovi);
            model.addAttribute("actionMode", EnumActionMode.ADMINISTRACIJA);
            model.addAttribute("korisnik", loggedUser);
            
        } catch (ResponseStatusException e) {
            redirectAttributes.addFlashAttribute("errorMessage", e.getReason());
            return "redirect:/administration";
        } catch (Exception e) {
            e.printStackTrace();
            redirectAttributes.addFlashAttribute("errorMessage", "Greška pri učitavanju korisnika: " + e.getMessage());
            return "redirect:/administration";
        }
        
        session.setAttribute("isAdmin", loggedUser.isAdmin());
        return "administration";
    }
    
    @PostMapping("/save")
    public String saveKorisnik(@RequestParam(required = false) Integer id,
                               @RequestParam String korisnickoIme,
                               @RequestParam String imePrezime,
                               @RequestParam String lozinka,
                               @RequestParam Integer idRola,
                               @RequestParam Integer idSajt,
                               HttpSession session,
                               RedirectAttributes redirectAttributes) {
        
        KorisnikDTO loggedUser = (KorisnikDTO) session.getAttribute("loggedUser");
        
        if (loggedUser == null) {
            return "redirect:/login";
        }
        
        if (!loggedUser.isAdmin()) {
            return "redirect:/dashboard";
        }
        
        try {
            // Kreiraj DTO
            KorisnikAdminDTO dto = new KorisnikAdminDTO();
            dto.setiDKorisnik(id);
            dto.setKorisnickoIme(korisnickoIme);
            dto.setImePrezime(imePrezime);
            dto.setLozinka(lozinka);
            dto.setIdRola(idRola);
            dto.setIdSajt(idSajt);
            
            // Sačuvaj korisnika
            korisnikAdminService.saveKorisnik(dto, loggedUser.getIDKorisnik());
            
            if (id == null) {
                redirectAttributes.addFlashAttribute("successMessage", "Korisnik je uspešno dodat!");
            } else {
                redirectAttributes.addFlashAttribute("successMessage", "Korisnik je uspešno izmenjen!");
            }
            
        } catch (ResponseStatusException e) {
            redirectAttributes.addFlashAttribute("errorMessage", e.getReason());
        } catch (Exception e) {
            e.printStackTrace();
            redirectAttributes.addFlashAttribute("errorMessage", "Greška pri čuvanju korisnika: " + e.getMessage());
        }
        
        return "redirect:/administration";
    }
    
    @PostMapping("/delete")
    public String deleteKorisnik(@RequestParam Integer id,
                                 HttpSession session,
                                 RedirectAttributes redirectAttributes) {
        
        KorisnikDTO loggedUser = (KorisnikDTO) session.getAttribute("loggedUser");
        
        if (loggedUser == null) {
            return "redirect:/login";
        }
        
        if (!loggedUser.isAdmin()) {
            return "redirect:/dashboard";
        }
        
        // Spreči brisanje samog sebe
        if (loggedUser.getIDKorisnik().equals(id)) {
            redirectAttributes.addFlashAttribute("errorMessage", "Ne možete obrisati sami sebe!");
            return "redirect:/administration";
        }
        
        try {
            korisnikAdminService.deleteKorisnik(id);
            redirectAttributes.addFlashAttribute("successMessage", "Korisnik je uspešno obrisan!");
        } catch (ResponseStatusException e) {
            redirectAttributes.addFlashAttribute("errorMessage", e.getReason());
        } catch (Exception e) {
            e.printStackTrace();
            redirectAttributes.addFlashAttribute("errorMessage", "Greška pri brisanju korisnika!");
        }
        
        return "redirect:/administration";
    }
    
    @PostMapping("/reset-form")
    public String resetForm(HttpSession session) {
        return "redirect:/administration";
    }
}
    
