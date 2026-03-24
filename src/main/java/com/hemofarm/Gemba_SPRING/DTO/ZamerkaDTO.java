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
public class ZamerkaDTO {
    
    private Integer iDZamerka;
    private String naziv;
    
   
    private AktivnostDTO aktivnost;
    private List<ListaProveraAktZamerkaDTO> listaProveraAktZamerkaCollection;

    
    public ZamerkaDTO() {
        this.listaProveraAktZamerkaCollection = new ArrayList<>();
    }

   
    public ZamerkaDTO(Integer iDZamerka, String naziv) {
        this.iDZamerka = iDZamerka;
        this.naziv = naziv;
        this.listaProveraAktZamerkaCollection = new ArrayList<>();
    }

    
    public ZamerkaDTO(Integer iDZamerka, String naziv, 
                     AktivnostDTO aktivnost,
                     List<ListaProveraAktZamerkaDTO> listaProveraAktZamerkaCollection) {
        this.iDZamerka = iDZamerka;
        this.naziv = naziv;
        this.aktivnost = aktivnost;
        this.listaProveraAktZamerkaCollection = listaProveraAktZamerkaCollection != null ? 
            listaProveraAktZamerkaCollection : new ArrayList<>();
    }

   
    public Integer getIDZamerka() {
        return iDZamerka;
    }

    public void setIDZamerka(Integer iDZamerka) {
        this.iDZamerka = iDZamerka;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public AktivnostDTO getAktivnost() {
        return aktivnost;
    }

    public void setAktivnost(AktivnostDTO aktivnost) {
        this.aktivnost = aktivnost;
    }

    public List<ListaProveraAktZamerkaDTO> getListaProveraAktZamerkaCollection() {
        return listaProveraAktZamerkaCollection;
    }

    public void setListaProveraAktZamerkaCollection(List<ListaProveraAktZamerkaDTO> listaProveraAktZamerkaCollection) {
        this.listaProveraAktZamerkaCollection = listaProveraAktZamerkaCollection != null ? 
            listaProveraAktZamerkaCollection : new ArrayList<>();
    }

    
}