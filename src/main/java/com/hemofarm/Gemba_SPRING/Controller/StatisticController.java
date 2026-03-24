package com.hemofarm.Gemba_SPRING.Controller;

import com.hemofarm.Gemba_SPRING.DTO.KorisnikDTO;
import com.hemofarm.Gemba_SPRING.DTO.ListaProveraDTO;
import com.hemofarm.Gemba_SPRING.DTO.StatisticDTO;
import com.hemofarm.Gemba_SPRING.Service.ExcelExportService;
import com.hemofarm.Gemba_SPRING.Service.ListaProveraService;
import com.hemofarm.Gemba_SPRING.Service.StatisticService;
import com.hemofarm.Gemba_SPRING.util.EnumActionMode;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/statistic")
public class StatisticController {
    
   private final ListaProveraService listaProveraService;
   private final StatisticService statisticService; 
   private final ExcelExportService excelExportService;
    
   public StatisticController(ListaProveraService listaProveraService, 
                              StatisticService statisticService,
                              ExcelExportService excelExportService) {
        this.listaProveraService = listaProveraService;
        this.statisticService = statisticService;
        this.excelExportService = excelExportService;
        
    }
    
    @GetMapping
    public String statisticPage(HttpSession session, Model model) {
        KorisnikDTO loggedUser = (KorisnikDTO) session.getAttribute("loggedUser");
        
        if (loggedUser == null) {
            return "redirect:/login";
        }
        
        String username = loggedUser.getKorisnickoIme();
        
       
        List<ListaProveraDTO> listaProveraUser = listaProveraService.findByKorisnik(username);
        
       
        StatisticDTO stats = statisticService.izracunajStatistiku(username);
        
        model.addAttribute("listaProveraUser", listaProveraUser);
        model.addAttribute("total", stats.getTotal());
        model.addAttribute("completed", stats.getCompleted());
        model.addAttribute("pending", stats.getPending());
        model.addAttribute("archive", stats.getArchive());
        model.addAttribute("actionMode", EnumActionMode.STATISTIKA);
        model.addAttribute("korisnik", loggedUser);
        session.setAttribute("isAdmin", loggedUser.isAdmin());
        
        return "statistic";
    }
    
    @PostMapping
    public String filterStatistic(HttpSession session, Model model,
                                 @RequestParam(required = false) String statusFilter) {
        KorisnikDTO loggedUser = (KorisnikDTO) session.getAttribute("loggedUser");
        
        if (loggedUser == null) {
            return "redirect:/login";
        }
        
        String username = loggedUser.getKorisnickoIme();
        
        
        List<ListaProveraDTO> filteredList = statisticService.filtrirajPoStatusu(username, statusFilter);
        
        
        StatisticDTO stats = statisticService.izracunajStatistiku(username);
        
        model.addAttribute("listaProveraUser", filteredList);
        model.addAttribute("total", stats.getTotal());
        model.addAttribute("completed", stats.getCompleted());
        model.addAttribute("pending", stats.getPending());
        model.addAttribute("archive", stats.getArchive());
        model.addAttribute("actionMode", EnumActionMode.STATISTIKA);
        model.addAttribute("korisnik", loggedUser);
        model.addAttribute("currentFilter", statusFilter);
        session.setAttribute("isAdmin", loggedUser.isAdmin());
        
        return "statistic";
    }
    
       @PostMapping("/export")
    public void exportStatistic(HttpSession session, 
                                HttpServletResponse response,
                                @RequestParam(required = false) String statusFilter) throws IOException {
        
        KorisnikDTO loggedUser = (KorisnikDTO) session.getAttribute("loggedUser");
        
        if (loggedUser == null) {
            response.sendRedirect("/login");
            return;
        }
        
        String username = loggedUser.getKorisnickoIme();
        String imePrezime = loggedUser.getImePrezime() != null ? 
                            loggedUser.getImePrezime() : username;
        
       
        List<ListaProveraDTO> listaZaExport = statisticService.filtrirajPoStatusu(username, statusFilter);
        
        // Generisanje imena fajla preko ExcelExportService
        String fileName = excelExportService.generateFileName(statusFilter);
        
        // Podešavanje HTTP headera
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setHeader("Content-Disposition", "attachment; filename=" + fileName);
        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
        response.setHeader("Pragma", "no-cache");
        response.setDateHeader("Expires", 0);
        
        // Export u Excel
        excelExportService.exportStatistika(listaZaExport, imePrezime, response.getOutputStream());
        
        response.getOutputStream().flush();
    }
}
