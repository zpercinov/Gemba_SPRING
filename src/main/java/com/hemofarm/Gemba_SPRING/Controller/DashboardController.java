/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hemofarm.Gemba_SPRING.Controller;

import com.hemofarm.Gemba_SPRING.DTO.KorisnikDTO;
import com.hemofarm.Gemba_SPRING.DTO.ListaProveraDTO;
import com.hemofarm.Gemba_SPRING.Service.ListaProveraService;
import com.hemofarm.Gemba_SPRING.util.EnumActionMode;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author zpercinov
 */
@Controller
@RequestMapping("/dashboard")
public class DashboardController {
    
    private final ListaProveraService listaProveraService;

    public DashboardController(ListaProveraService listaProveraService) {
        this.listaProveraService = listaProveraService;
    }
    
    @GetMapping
    public String dashboard(HttpSession session, Model model) {
        KorisnikDTO loggedUser = (KorisnikDTO) session.getAttribute("loggedUser");
        
        if (loggedUser == null) {
            return "redirect:/login";
        }
        
         List<ListaProveraDTO> mojeGembe = listaProveraService.findByKorisnik(loggedUser.getKorisnickoIme());
    
        session.setAttribute("isAdmin", loggedUser.isAdmin());
        model.addAttribute("korisnik", loggedUser);
        model.addAttribute("actionMode", EnumActionMode.DASHBOARD);
        
        return "dashboard"; 
    }
    
    /**
     * Prikaz svih Gembi (Sve Gembe)
     */
    @PostMapping("/list/all")
    public String listAllGemba(HttpSession session, Model model) {
        // Provera autentifikacije
        KorisnikDTO loggedUser = (KorisnikDTO) session.getAttribute("loggedUser");
        if (loggedUser == null) {
            return "redirect:/login";
        }

        // Dohvatanje svih Gembi iz baze
        List<ListaProveraDTO> sveGembe = listaProveraService.findAll();
        
        // Postavljanje atributa za prikaz
        session.setAttribute("printGemba", sveGembe);
        session.setAttribute("gembaTitle", "Sve Gembe");
        model.addAttribute("actionMode", EnumActionMode.DASHBOARD_SVE_GEMBE);
        model.addAttribute("korisnik", loggedUser);
        session.setAttribute("isAdmin", loggedUser.isAdmin());
        
        return "dashboard"; 
    }

    /**
     * Prikaz Gembi trenutno ulogovanog korisnika (Moje Gembe)
     */
    @PostMapping("/list/my")
    public String listMyGemba(HttpSession session, Model model) {
        // Provera autentifikacije
        KorisnikDTO loggedUser = (KorisnikDTO) session.getAttribute("loggedUser");
        if (loggedUser == null) {
            return "redirect:/login";
        }

        // Dohvatanje Gembi za trenutnog korisnika
        List<ListaProveraDTO> mojeGembe = listaProveraService.findByKorisnik(loggedUser.getKorisnickoIme());
        
        // Postavljanje atributa za prikaz
        session.setAttribute("printGemba", mojeGembe);
       session.setAttribute("gembaTitle", "Moje Gembe");
        model.addAttribute("actionMode", EnumActionMode.DASHBOARD_MOJE_GEMBE);
        model.addAttribute("korisnik", loggedUser);
        session.setAttribute("isAdmin", loggedUser.isAdmin());
        
        return "dashboard";
    }
    
    @PostMapping("/list/search")
public String searchGemba(HttpSession session, Model model, 
                          @RequestParam(required = false) String query) {
    
    KorisnikDTO loggedUser = (KorisnikDTO) session.getAttribute("loggedUser");
    if (loggedUser == null) {
        return "redirect:/login";
    }
    
    @SuppressWarnings("unchecked")
    List<ListaProveraDTO> printGemba = (List<ListaProveraDTO>) session.getAttribute("printGemba");
    
    if (printGemba == null || printGemba.isEmpty()) {
        model.addAttribute("infoMessage", "Prvo prikažite podatke (\"Sve Gembe\" / \"Moje Gembe\").");
        session.setAttribute("gembaTitle", "Pretraga");
        session.setAttribute("printGemba", new ArrayList<>());
    } else {
        // DELEGIRAJ SERVISU
        List<ListaProveraDTO> filtered = listaProveraService.search(printGemba, query);
        session.setAttribute("printGemba", filtered);
        
        String replaced = query.replace("*", " AND ").replace("|", " OR ");
        session.setAttribute("gembaTitle", "Kriterijum pretrage („" + replaced + "”)");
    }
    
    session.setAttribute("isAdmin", loggedUser.isAdmin());
    model.addAttribute("korisnik", loggedUser);
    model.addAttribute("actionMode", EnumActionMode.DASHBOARD_SEARCH);

    return "dashboard";
}
    
}