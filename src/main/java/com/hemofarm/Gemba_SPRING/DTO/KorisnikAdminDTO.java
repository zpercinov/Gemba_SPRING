/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hemofarm.Gemba_SPRING.DTO;

import java.util.Date;

/**
 *
 * @author zpercinov
 */
public class KorisnikAdminDTO {
    
 
    private Integer iDKorisnik;
    private String korisnickoIme;
    private String imePrezime;
    private String lozinka;
    
   
    private RolaDTO rola;              
    private SajtDTO sajt;               
    private KorisnikDTO korisnikUnos;    
    private KorisnikDTO korisnikIzmena;  
    
    
    private Date datumUnosa;
    private Date datumIzmene;
    
   
    private Integer idRola;
    private Integer idSajt;

   
    public Integer getiDKorisnik() {
        return iDKorisnik;
    }

    public void setiDKorisnik(Integer iDKorisnik) {
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

    public String getLozinka() {
        return lozinka;
    }

    public void setLozinka(String lozinka) {
        this.lozinka = lozinka;
    }

    public RolaDTO getRola() {
        return rola;
    }

    public void setRola(RolaDTO rola) {
        this.rola = rola;
        if (rola != null) {
            this.idRola = rola.getIDRole(); 
        }
    }

    public SajtDTO getSajt() {
        return sajt;
    }

    public void setSajt(SajtDTO sajt) {
        this.sajt = sajt;
        if (sajt != null) {
            this.idSajt = sajt.getIDSajt();  
        }
    }

    public KorisnikDTO getKorisnikUnos() {
        return korisnikUnos;
    }

    public void setKorisnikUnos(KorisnikDTO korisnikUnos) {
        this.korisnikUnos = korisnikUnos;
    }

    public KorisnikDTO getKorisnikIzmena() {
        return korisnikIzmena;
    }

    public void setKorisnikIzmena(KorisnikDTO korisnikIzmena) {
        this.korisnikIzmena = korisnikIzmena;
    }

    public Date getDatumUnosa() {
        return datumUnosa;
    }

    public void setDatumUnosa(Date datumUnosa) {
        this.datumUnosa = datumUnosa;
    }

    public Date getDatumIzmene() {
        return datumIzmene;
    }

    public void setDatumIzmene(Date datumIzmene) {
        this.datumIzmene = datumIzmene;
    }

    public Integer getIdRola() {
        return idRola;
    }

    public void setIdRola(Integer idRola) {
        this.idRola = idRola;
    }

    public Integer getIdSajt() {
        return idSajt;
    }

    public void setIdSajt(Integer idSajt) {
        this.idSajt = idSajt;
    }
}
