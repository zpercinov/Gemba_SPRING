/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hemofarm.Gemba_SPRING.DTO;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author zpercinov
 */
public class VrstaGembeDTO {
    
    private Integer iDVrstaGem;
    private String naziv;
    private List<AktivnostDTO> aktivnostCollection;

   
    public VrstaGembeDTO() {
        this.aktivnostCollection = new ArrayList<>();
    }

 
    public VrstaGembeDTO(Integer iDVrstaGem, String naziv) {
        this.iDVrstaGem = iDVrstaGem;
        this.naziv = naziv;
        this.aktivnostCollection = new ArrayList<>();
    }

    
    public VrstaGembeDTO(Integer iDVrstaGem, String naziv, List<AktivnostDTO> aktivnostCollection) {
        this.iDVrstaGem = iDVrstaGem;
        this.naziv = naziv;
        this.aktivnostCollection = aktivnostCollection != null ? aktivnostCollection : new ArrayList<>();
    }

   
    public Integer getIDVrstaGem() {
        return iDVrstaGem;
    }

    public void setIDVrstaGem(Integer iDVrstaGem) {
        this.iDVrstaGem = iDVrstaGem;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public List<AktivnostDTO> getAktivnostCollection() {
        return aktivnostCollection;
    }

    public void setAktivnostCollection(List<AktivnostDTO> aktivnostCollection) {
        this.aktivnostCollection = aktivnostCollection != null ? aktivnostCollection : new ArrayList<>();
    }

    
    public String getDisplayName() {
        return naziv != null ? naziv : "";
    }
    
    public int getBrojAktivnosti() {
        return aktivnostCollection != null ? aktivnostCollection.size() : 0;
    }
    
    public List<String> getAktivnostiNazivi() {
        if (aktivnostCollection == null || aktivnostCollection.isEmpty()) {
            return new ArrayList<>();
        }
        return aktivnostCollection.stream()
                .map(AktivnostDTO::getNaziv)
                .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
    }
    
    public String getAktivnostiNaziviString() {
        List<String> nazivi = getAktivnostiNazivi();
        return String.join(", ", nazivi);
    }

    @Override
    public String toString() {
        return "VrstaGembeDTO{" +
                "idVrstaGem=" + iDVrstaGem +
                ", naziv='" + naziv + '\'' +
                ", brojAktivnosti=" + getBrojAktivnosti() +
                '}';
    }
}