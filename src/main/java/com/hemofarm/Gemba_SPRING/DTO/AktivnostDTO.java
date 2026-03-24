/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hemofarm.Gemba_SPRING.DTO;

/**
 *
 * @author Rick Hunter
 */
public class AktivnostDTO {
    
    private Integer idAktivnosti;
    private String naziv;
    private VrstaGembeDTO vrstaGembe;  // DTO za VrstaGembe

    // Default konstruktor
    public AktivnostDTO() {
    }

    // Konstruktor sa svim poljima
    public AktivnostDTO(Integer idAktivnosti, String naziv, VrstaGembeDTO vrstaGembe) {
        this.idAktivnosti = idAktivnosti;
        this.naziv = naziv;
        this.vrstaGembe = vrstaGembe;
    }

    // Getteri i setteri
    public Integer getIDAktivnosti() {
        return idAktivnosti;
    }

    public void setIDAktivnosti(Integer idAktivnosti) {
        this.idAktivnosti = idAktivnosti;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public VrstaGembeDTO getVrstaGembe() {
        return vrstaGembe;
    }

    public void setVrstaGembe(VrstaGembeDTO vrstaGembe) {
        this.vrstaGembe = vrstaGembe;
    }

    
    
}
