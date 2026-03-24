/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hemofarm.Gemba_SPRING.Controller;


import com.hemofarm.Gemba_SPRING.DTO.FunkcijaDTO;
import com.hemofarm.Gemba_SPRING.DTO.GembaDTO;
import com.hemofarm.Gemba_SPRING.DTO.KlasterDTO;
import com.hemofarm.Gemba_SPRING.DTO.KorisnikDTO;
import com.hemofarm.Gemba_SPRING.DTO.ListaProveraAktDTO;
import com.hemofarm.Gemba_SPRING.DTO.NosilacDTO;
import com.hemofarm.Gemba_SPRING.DTO.OdeljenjeDTO;
import com.hemofarm.Gemba_SPRING.DTO.SajtDTO;
import com.hemofarm.Gemba_SPRING.DTO.VrstaGembeDTO;
import com.hemofarm.Gemba_SPRING.Service.GembaService;
import com.hemofarm.Gemba_SPRING.util.EnumActionMode;
import com.hemofarm.Gemba_SPRING.util.EnumGembaStatus;
import jakarta.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/gemba")
public class GembaController {

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }

    private final GembaService gembaService;

    public GembaController(GembaService gembaService) {
        this.gembaService = gembaService;
    }

    // ========== NOVA GEMBA ==========
    @PostMapping("/new")
    public String newGemba(HttpSession session, Model model) {
        KorisnikDTO loggedUser = (KorisnikDTO) session.getAttribute("loggedUser");
        if (loggedUser == null) {
            return "redirect:/login";
        }

        GembaDTO gemba = gembaService.createNewGemba();
        loadFormData(model, loggedUser);

        Integer currentStep = EnumGembaStatus.SPREMNO_ZA_UNOS.getStep();
        session.setAttribute("currentStep", currentStep);  // ← dodato
        model.addAttribute("currentStep", currentStep);
         
        model.addAttribute("gemba", gemba);
        model.addAttribute("actionMode", EnumActionMode.UNOS_NOVI_UNOS);
        model.addAttribute("korisnik", loggedUser);
        model.addAttribute("datum", new Date());

        return "gemba";
    }

    // ========== IZMENA GEMBE ==========
    @PostMapping("/edit")
    public String editGemba(HttpSession session, Model model) {
        KorisnikDTO loggedUser = (KorisnikDTO) session.getAttribute("loggedUser");
        if (loggedUser == null) return "redirect:/login";
        
        Integer gembaId = (Integer) session.getAttribute("editGembaId");
        if (gembaId == null) {
            return "redirect:/dashboard";
        }
        
        GembaDTO gemba = gembaService.findGembaById(gembaId);
        
        if (!gemba.getUserUnos().equals(loggedUser.getKorisnickoIme())) {
            return viewGemba(gembaId, session, model);
        }
        
        List<ListaProveraAktDTO> aktivnosti = gembaService.findAktivnostiByGembaId(gembaId);
        boolean imaAktivnosti = aktivnosti != null && !aktivnosti.isEmpty();
        Integer currentStep = gemba.getStatus();
        
        loadFormData(model, loggedUser);
         model.addAttribute("currentStep", currentStep);
        model.addAttribute("gemba", gemba);
        model.addAttribute("aktivnostiListaProvera", aktivnosti);
        model.addAttribute("zakljucano_vrsta_gemba", imaAktivnosti);
        model.addAttribute("actionMode", EnumActionMode.IZMENA);
        model.addAttribute("korisnik", loggedUser);
        model.addAttribute("datum", gemba.getDatum());
        
        
        
        return "gemba";
    }

    // ========== ČUVANJE GEMBE ==========
    @PostMapping("/save")
    public String saveGemba(@RequestParam(required = false) Integer id,
                            @RequestParam String datum,
                            @RequestParam Integer gembaVrsta,
                            @RequestParam Integer klaster,
                            @RequestParam Integer sajt,
                            @RequestParam Integer funkcija,
                            @RequestParam Integer odeljenje,
                            @RequestParam Integer nosilac,
                            HttpSession session,
                            Model model) {  
        
        KorisnikDTO loggedUser = (KorisnikDTO) session.getAttribute("loggedUser");
        if (loggedUser == null) return "redirect:/login";

        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date datumDate = sdf.parse(datum);
            
            GembaDTO gembaDTO = new GembaDTO();
            gembaDTO.setIDLisProvere(id);
            gembaDTO.setDatum(datumDate);
            
            VrstaGembeDTO vrstaGembeDTO = new VrstaGembeDTO();
            vrstaGembeDTO.setIDVrstaGem(gembaVrsta);
            gembaDTO.setVrstaGembe(vrstaGembeDTO);
            
            KlasterDTO klasterDTO = new KlasterDTO();
            klasterDTO.setIDCluster(klaster);
            gembaDTO.setKlaster(klasterDTO);
            
            SajtDTO sajtDTO = new SajtDTO();
            sajtDTO.setIDSajt(sajt);
            gembaDTO.setSajt(sajtDTO);
            
            FunkcijaDTO funkcijaDTO = new FunkcijaDTO();
            funkcijaDTO.setIDFun(funkcija);
            gembaDTO.setFunkcija(funkcijaDTO);
            
            OdeljenjeDTO odeljenjeDTO = new OdeljenjeDTO();
            odeljenjeDTO.setIDOdeljenje(odeljenje);
            gembaDTO.setOdeljenje(odeljenjeDTO);
            
            NosilacDTO nosilacDTO = new NosilacDTO();
            nosilacDTO.setIDNos(nosilac);
            gembaDTO.setNosilac(nosilacDTO);
            
            Integer savedId = gembaService.saveGemba(gembaDTO, loggedUser.getKorisnickoIme());
            
            session.setAttribute("editGembaId", savedId);
            
            if (id == null) {
                model.addAttribute("successMessage", "Podaci su uspešno sačuvani!");
                session.setAttribute("currentStep", EnumGembaStatus.GEMBA_REGISTROVANA.getStep());
            } else {
                model.addAttribute("successMessage", "Podaci su uspešno izmenjeni!");
            }
            
            return editGemba(session, model);
            
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("errorMessage", "Greška pri čuvanju: " + e.getMessage()); 
            
            if (id != null) {
                return "redirect:/gemba/edit";
            } else {
                return "redirect:/gemba/new";
            }
        }
    }

    // ========== PREGLED GEMBE ==========
    @PostMapping("/view")
    public String viewGemba(@RequestParam Integer gembaId, HttpSession session, Model model) {
        KorisnikDTO loggedUser = (KorisnikDTO) session.getAttribute("loggedUser");
        if (loggedUser == null) {
            return "redirect:/login";
        }

        GembaDTO gemba = gembaService.findGembaById(gembaId);
        List<ListaProveraAktDTO> aktivnosti = gembaService.findAktivnostiByGembaId(gembaId);

        boolean zakljucano = gemba.getStatus() == EnumGembaStatus.ARHIVIRANO.getStep() ||
                             !gemba.getUserUnos().equals(loggedUser.getKorisnickoIme());

        Integer currentStep = gemba.getStatus();
        
        
        model.addAttribute("currentStep", currentStep);
        session.setAttribute("editGembaId", gembaId); 
        model.addAttribute("gemba", gemba);
        model.addAttribute("aktivnostiListaProvera", aktivnosti);
        model.addAttribute("zakljucano", zakljucano);
        model.addAttribute("actionMode", EnumActionMode.PREGLED);
        model.addAttribute("korisnik", loggedUser);
        model.addAttribute("datum", gemba.getDatum());
        loadFormData(model, loggedUser);

        return "gemba";
    }

    // ========== INICIJALIZACIJA AKTIVNOSTI ==========
    @PostMapping("/aktivnosti/init")
    public String initAktivnosti(@RequestParam Integer gembaId,
                                 @RequestParam Integer idVrstaGem,
                                 HttpSession session,
                                 Model model) {

        KorisnikDTO loggedUser = (KorisnikDTO) session.getAttribute("loggedUser");
        if (loggedUser == null) {
            return "redirect:/login";
        }

        try {
            gembaService.inicijalizujAktivnosti(gembaId, idVrstaGem, loggedUser.getKorisnickoIme());
            
            session.setAttribute("currentStep", EnumGembaStatus.AKTIVNOSTI_INICIJALIZOVANE.getStep());
            session.setAttribute("editGembaId", gembaId);  

            model.addAttribute("successMessage", "Aktivnosti uspešno inicijalizovane!");
            
            return editGemba(session, model);
            
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("errorMessage", "Greška: " + e.getMessage());
            return "redirect:/dashboard";
        }
    }

    // ========== AŽURIRANJE ISHODA ==========
    @PostMapping("/aktivnosti/ishod/update")
    public String updateIshod(@RequestParam Integer LisProvereAktID,
                              @RequestParam Integer ishodId,
                              HttpSession session,
                              Model model) { 

        KorisnikDTO loggedUser = (KorisnikDTO) session.getAttribute("loggedUser");
        if (loggedUser == null) {
            return "redirect:/login";
        }

        try {
            gembaService.updateIshod(LisProvereAktID, ishodId, loggedUser.getKorisnickoIme());
            
            Integer gembaId = (Integer) session.getAttribute("editGembaId");
            
            if (gembaId == null) {
                model.addAttribute("errorMessage", "Nije pronađen ID gembe u sesiji");
                return "redirect:/dashboard";
            }
            
            GembaDTO gemba = gembaService.findGembaById(gembaId);
            session.setAttribute("currentStep", gemba.getStatus());
            
            model.addAttribute("successMessage", "Ishod uspešno ažuriran!");
            
            return editGemba(session, model);
            
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("errorMessage", "Greška: " + e.getMessage());
            return "redirect:/dashboard";
        }
    }

    // ========== BRISANJE AKTIVNOSTI ==========
    @PostMapping("/aktivnosti/delete")
    public String deleteAktivnost(@RequestParam Integer id,
                                  HttpSession session,
                                  Model model) {

        KorisnikDTO loggedUser = (KorisnikDTO) session.getAttribute("loggedUser");
        if (loggedUser == null) {
            return "redirect:/login";
        }

        try {
            gembaService.deleteAktivnost(id);
            
            Integer gembaId = (Integer) session.getAttribute("editGembaId");
            if (gembaId == null) {
                model.addAttribute("errorMessage", "Nije pronađen ID gembe u sesiji");
                return "redirect:/dashboard";
            }
            
            model.addAttribute("successMessage", "Aktivnost uspešno obrisana!");
            
            return editGemba(session, model);
            
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("errorMessage", "Greška: " + e.getMessage());
            return "redirect:/dashboard";
        }
    }

    // ========== BRISANJE GEMBE ==========
    @PostMapping("/delete")
    public String deleteGemba(@RequestParam Integer id,
                              HttpSession session,
                              RedirectAttributes redirectAttributes) {

        KorisnikDTO loggedUser = (KorisnikDTO) session.getAttribute("loggedUser");
        if (loggedUser == null) {
            return "redirect:/login";
        }

        try {
            gembaService.deleteGemba(id);
            redirectAttributes.addFlashAttribute("successMessage", "Gemba je uspešno obrisana!");
            session.setAttribute("currentStep", EnumGembaStatus.START.getStep());
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Greška: " + e.getMessage());
        }

        return "redirect:/dashboard";
    }

    // ========== ARHIVIRANJE GEMBE ==========
    @PostMapping("/archive")
    public String archiveGemba(@RequestParam Integer gembaId,
                               HttpSession session,
                               Model model) {

        KorisnikDTO loggedUser = (KorisnikDTO) session.getAttribute("loggedUser");
        if (loggedUser == null) {
            return "redirect:/login";
        }

        try {
            gembaService.archiveGemba(gembaId, loggedUser.getIDKorisnik());
            
            session.setAttribute("currentStep", EnumGembaStatus.ARHIVIRANO.getStep());
            session.setAttribute("editGembaId", gembaId);
            
            model.addAttribute("successMessage", "Gemba uspešno arhivirana!");
            
            return viewGemba(gembaId, session, model);
            
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("errorMessage", "Greška: " + e.getMessage());
            return "redirect:/dashboard";
        }
    }

    // ========== POMOĆNE METODE ==========
    private void loadFormData(Model model, KorisnikDTO loggedUser) {
        model.addAttribute("gembaVrste", gembaService.findAllVrstaGembe());
        model.addAttribute("klasteri", gembaService.findAllKlasteri());
        model.addAttribute("sajtovi", gembaService.findAllSajtovi());
        model.addAttribute("funkcije", gembaService.findAllFunkcije());
        model.addAttribute("odeljenja", gembaService.findAllOdeljenja());
        model.addAttribute("nosioci", gembaService.findAllNosioci());
        model.addAttribute("ishodi", gembaService.findAllIshodi());
        model.addAttribute("korisnik", loggedUser);
    }
}