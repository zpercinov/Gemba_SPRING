/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hemofarm.Gemba_SPRING.Controller;

import com.hemofarm.Gemba_SPRING.DTO.AktivnostDTO;
import com.hemofarm.Gemba_SPRING.DTO.KorisnikDTO;
import com.hemofarm.Gemba_SPRING.DTO.ListaProveraAktDTO;
import com.hemofarm.Gemba_SPRING.DTO.ListaProveraAktZamerkaDTO;
import com.hemofarm.Gemba_SPRING.DTO.ZamerkaDTO;
import com.hemofarm.Gemba_SPRING.Service.GembaService;
import com.hemofarm.Gemba_SPRING.util.EnumActionMode;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


/**
 *
 * @author zpercinov
 */

    
@Controller
@RequestMapping("gemba/zamerka")
public class ZamerkaController {

    private final GembaService gembaService;

    public ZamerkaController(GembaService gembaService) {
        this.gembaService = gembaService;
    }

    @PostMapping
    public String showZamerkaForm(@RequestParam Integer idListaAktivnosti,
                                   @RequestParam(required = false) Integer idAktivnosti,
                                   @RequestParam(required = false) Boolean viewMode,
                                   HttpSession session,
                                   Model model) {
        
        KorisnikDTO loggedUser = (KorisnikDTO) session.getAttribute("loggedUser");
        if (loggedUser == null) return "redirect:/login";
        
           boolean isView = viewMode != null && viewMode;
        
          if (!isView) {
        
        boolean canAdd = gembaService.canAddZamerka(idListaAktivnosti);
        String ishodStatus = gembaService.getIshodStatus(idListaAktivnosti);
        
        if (!canAdd) {
            String errorMsg = "Zamerku je nemoguće uneti jer ISHOD mora da ima vrednost 'NIJE OK'";
            if (ishodStatus.equals("NEMA ISHODA")) {
                errorMsg = "Zamerku je nemoguće uneti jer aktivnost nema definisan ISHOD";
            } else {
                errorMsg = "Zamerku je nemoguće uneti jer ISHOD mora da ima vrednost 'NIJE OK' (trenutno: " + ishodStatus + ")";
            }
            
            model.addAttribute("errorMessage", errorMsg);
            // Vrati se na gemba view
            return "zamerka";
        }
    }
      
        List<ZamerkaDTO> zamerke = new ArrayList<>();
    String headerAktivnost = "";
    
    if (idAktivnosti != null) {
    zamerke = gembaService.findZamerkeByMasterAktivnostId(idAktivnosti);
    
    
    AktivnostDTO aktivnost = gembaService.findAktivnostById(idAktivnosti);
    if (aktivnost != null) {
        headerAktivnost = aktivnost.getNaziv();
    }
}
        

        List<ListaProveraAktZamerkaDTO> vezaneZamerke = gembaService.findZamerkeByAktivnostId(idListaAktivnosti);
        
 
        
        model.addAttribute("zamerke", zamerke);
        model.addAttribute("vezaneZamerke", vezaneZamerke);
        model.addAttribute("idLisProvereAkt", idListaAktivnosti);
        model.addAttribute("idAktivnosti", idAktivnosti);
        model.addAttribute("headerAktivnost", headerAktivnost);
        model.addAttribute("viewMode", viewMode != null ? viewMode : false);
        model.addAttribute("actionMode", EnumActionMode.ZAMERKA);
        session.setAttribute("currentListaAktivnostiId", idListaAktivnosti);
    session.setAttribute("currentAktivnostId", idAktivnosti);
        
        return "zamerka";
    }

  @PostMapping("/save")
public String saveZamerka(@RequestParam(required = false) Integer idLisProvereAktZamerka,
                          @RequestParam Integer idZamerke,
                          @RequestParam(required = false) String napomena,
                          @RequestParam Integer idListaAktivnosti,
                          @RequestParam(required = false) Integer idAktivnosti,  
                          HttpSession session,
                          Model model) {  
    
    KorisnikDTO loggedUser = (KorisnikDTO) session.getAttribute("loggedUser");
    if (loggedUser == null) return "redirect:/login";
    
    try {
        ListaProveraAktZamerkaDTO dto = new ListaProveraAktZamerkaDTO();
        dto.setIDLisProvereAktZamerka(idLisProvereAktZamerka);
        dto.setNapomena(napomena);
        
        ZamerkaDTO zamerkaDTO = new ZamerkaDTO();
        zamerkaDTO.setIDZamerka(idZamerke);
        dto.setZamerka(zamerkaDTO);
        
        ListaProveraAktDTO aktivnostDTO = new ListaProveraAktDTO();
        aktivnostDTO.setIDLisProvereAkt(idListaAktivnosti);
        dto.setListaProveraAkt(aktivnostDTO);
        
        Integer savedId = gembaService.saveZamerka(dto, "", loggedUser.getKorisnickoIme());
        
        if (idLisProvereAktZamerka == null) {
            model.addAttribute("successMessage", "Zamerka uspešno dodata!");
        } else {
            model.addAttribute("successMessage", "Zamerka uspešno izmenjena!");
        }
        
       
        session.setAttribute("editZamerkaId", savedId);
        session.setAttribute("currentListaAktivnostiId", idListaAktivnosti);
        session.setAttribute("currentAktivnostId", idAktivnosti);
        
        
        return showZamerkaForm(idListaAktivnosti, idAktivnosti, false, session, model);
        
    } catch (Exception e) {
        e.printStackTrace();
        model.addAttribute("errorMessage", "Greška: " + e.getMessage());
        return showZamerkaForm(idListaAktivnosti, idAktivnosti, false, session, model);
    }
}

    @PostMapping("/edit")
public String editZamerka(@RequestParam Integer lastLisProvereAktZamerka,
                          @RequestParam String headerAktivnost,
                          @RequestParam(required = false) Integer idAktivnosti,
                          HttpSession session,
                          Model model) {
    
    KorisnikDTO loggedUser = (KorisnikDTO) session.getAttribute("loggedUser");
    if (loggedUser == null) return "redirect:/login";
    
    ListaProveraAktZamerkaDTO zamerka = gembaService.findZamerkaById(lastLisProvereAktZamerka);
    
  
    List<ZamerkaDTO> zamerke = new ArrayList<>();
    if (idAktivnosti != null) {
        zamerke = gembaService.findZamerkeByMasterAktivnostId(idAktivnosti);
    }
    
    List<ListaProveraAktZamerkaDTO> vezaneZamerke = gembaService.findZamerkeByAktivnostId(
            zamerka.getListaProveraAkt().getIDLisProvereAkt());
    
    model.addAttribute("zamerke", zamerke);
    model.addAttribute("vezaneZamerke", vezaneZamerke);
    model.addAttribute("idLisProvereAkt", zamerka.getListaProveraAkt().getIDLisProvereAkt());
    model.addAttribute("idLisProvereAktZamerka", zamerka.getIDLisProvereAktZamerka());
    model.addAttribute("idZamerka", zamerka.getZamerka().getIDZamerka());
    model.addAttribute("napomena", zamerka.getNapomena());
    model.addAttribute("headerAktivnost", headerAktivnost);
    model.addAttribute("idAktivnosti", idAktivnosti);
    model.addAttribute("viewMode", false);
    model.addAttribute("actionMode", EnumActionMode.ZAMERKA);
    
    return "zamerka";
}

  @PostMapping("/delete")
public String deleteZamerka(@RequestParam Integer id,
                            @RequestParam(required = false) Integer idAktivnosti, 
                            HttpSession session,
                            Model model) {
    
    KorisnikDTO loggedUser = (KorisnikDTO) session.getAttribute("loggedUser");
    if (loggedUser == null) return "redirect:/login";
    
    // Ako nije prosleđen, uzmi iz sesije
    if (idAktivnosti == null) {
        idAktivnosti = (Integer) session.getAttribute("currentAktivnostId");
    }
    
    Integer idListaAktivnosti = (Integer) session.getAttribute("currentListaAktivnostiId");
    
    System.out.println("===== DELETE ZAMERKA =====");
    System.out.println("id za brisanje: " + id);
    System.out.println("idAktivnosti: " + idAktivnosti);
    System.out.println("idListaAktivnosti iz sesije: " + idListaAktivnosti);
    
    if (idListaAktivnosti == null) {
        model.addAttribute("errorMessage", "Nije pronađen ID liste aktivnosti u sesiji");
        return "redirect:/dashboard";
    }
    
    try {
        gembaService.deleteZamerka(id);
        model.addAttribute("successMessage", "Zamerka uspešno obrisana!");
        
        return showZamerkaForm(idListaAktivnosti, idAktivnosti, false, session, model);
        
    } catch (Exception e) {
        e.printStackTrace();
        model.addAttribute("errorMessage", "Greška: " + e.getMessage());
        return "redirect:/dashboard";
    }
}

}
    

