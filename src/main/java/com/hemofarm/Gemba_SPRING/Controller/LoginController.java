/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hemofarm.Gemba_SPRING.Controller;

import com.hemofarm.Gemba_SPRING.DTO.KorisnikDTO;
import com.hemofarm.Gemba_SPRING.DTO.LoginDto;
import com.hemofarm.Gemba_SPRING.Service.LoginService;
import org.springframework.ui.Model;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author zpercinov
 */
@Controller
@RequestMapping("/login")
public class LoginController {

    private final LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @GetMapping
    public String loginPage(@RequestParam(required = false) String logout, Model model) {
        if ("success".equals(logout)) {
            model.addAttribute("successMessage", "Uspešno ste se odjavili.");
        }
        model.addAttribute("loginRequest", new LoginDto());
        return "index";
    }

    @PostMapping
    public String loginSubmit(@Valid @ModelAttribute LoginDto loginRequest,
            BindingResult result,
            HttpSession session,
            Model model) {

        System.out.println("Preuzimanje sa login forme");
        System.out.println("Username: " + loginRequest.getKorisnickoIme());
        System.out.println("Password: " + loginRequest.getLozinka());

        if (result.hasErrors()) {
            return "index";
        }

        try {
            KorisnikDTO korisnik = loginService.login(loginRequest);
            session.setAttribute("loggedUser", korisnik);

            return "redirect:/dashboard";

        } catch (Exception e) {
            model.addAttribute("errorMessage", "Pogrešno korisničko ime ili lozinka!");
            return "index";
        }
    }

}
