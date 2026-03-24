/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hemofarm.Gemba_SPRING.DTO;




/**
 *
 * @author zpercinov
 */
public class KorisnikDTO {
    
    private Integer iDKorisnik;
    private String korisnickoIme;
    private String imePrezime;
    private boolean admin;
    private RolaDTO rola;  
    
   
    public KorisnikDTO() {}
    
 
    public KorisnikDTO(Integer iDKorisnik, String korisnickoIme, String imePrezime, RolaDTO rola) {
        this.iDKorisnik = iDKorisnik;
        this.korisnickoIme = korisnickoIme;
        this.imePrezime = imePrezime;
        this.rola = rola;
        
    }
    
   
    public Integer getIDKorisnik() {
        return iDKorisnik;
    }
    
    public void setIDKorisnik(Integer iDKorisnik) {
        this.iDKorisnik = iDKorisnik;
    }
    
    public String getKorisnickoIme() {
        return korisnickoIme;
    }
    
    public void setKorisnickoIme(String korisnickoIme) {
        this.korisnickoIme = korisnickoIme;
    }
    
    public String getImePrezime() {
        return imePrezime;
    }
    
    public void setImePrezime(String imePrezime) {
        this.imePrezime = imePrezime;
    }
    
 
    
    public RolaDTO getRola() {
        return rola;
    }
    
    
    public void setRola(RolaDTO rola) {
        this.rola = rola;
    }
    
     public boolean isAdmin() {
        return admin;
    }
    
    public void setAdmin(boolean admin) {
        this.admin = admin;
    }
}
    
   
