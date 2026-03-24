/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hemofarm.Gemba_SPRING.DTO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author zpercinov
 */
public class ListaProveraAktDTO {
    
    private Integer idLisProvereAkt;
    private String userUnos;
    private Date datumUnos;
    private String userIzmena;
    private Date datumIzmena;
    private boolean hasZamerka;
    
   
    private AktivnostDTO aktivnost;
    private IshodDTO ishod;
    private ListaProveraDTO listaProvera;
    
    
    private List<ListaProveraAktZamerkaDTO> listaProveraAktZamerkaCollection;

  
    public ListaProveraAktDTO() {
        this.listaProveraAktZamerkaCollection = new ArrayList<>();
    }

    
    public ListaProveraAktDTO(Integer idLisProvereAkt, String userUnos, Date datumUnos) {
        this.idLisProvereAkt = idLisProvereAkt;
        this.userUnos = userUnos;
        this.datumUnos = datumUnos;
        this.listaProveraAktZamerkaCollection = new ArrayList<>();
    }

   
    public Integer getIDLisProvereAkt() {
        return idLisProvereAkt;
    }

    public void setIDLisProvereAkt(Integer idLisProvereAkt) {
        this.idLisProvereAkt = idLisProvereAkt;
    }

    public String getUserUnos() {
        return userUnos;
    }

    public void setUserUnos(String userUnos) {
        this.userUnos = userUnos;
    }

    public Date getDatumUnos() {
        return datumUnos;
    }

    public void setDatumUnos(Date datumUnos) {
        this.datumUnos = datumUnos;
    }

    public String getUserIzmena() {
        return userIzmena;
    }

    public void setUserIzmena(String userIzmena) {
        this.userIzmena = userIzmena;
    }

    public Date getDatumIzmena() {
        return datumIzmena;
    }

    public void setDatumIzmena(Date datumIzmena) {
        this.datumIzmena = datumIzmena;
    }

    public boolean isHasZamerka() {
        return hasZamerka;
    }

    public void setHasZamerka(boolean hasZamerka) {
        this.hasZamerka = hasZamerka;
    }

    public AktivnostDTO getAktivnost() {
        return aktivnost;
    }

    public void setAktivnost(AktivnostDTO aktivnost) {
        this.aktivnost = aktivnost;
    }

    public IshodDTO getIshod() {
        return ishod;
    }

    public void setIshod(IshodDTO ishod) {
        this.ishod = ishod;
    }

    public ListaProveraDTO getListaProvera() {
        return listaProvera;
    }

    public void setListaProvera(ListaProveraDTO listaProvera) {
        this.listaProvera = listaProvera;
    }

    public List<ListaProveraAktZamerkaDTO> getListaProveraAktZamerkaCollection() {
        return listaProveraAktZamerkaCollection;
    }

    public void setListaProveraAktZamerkaCollection(List<ListaProveraAktZamerkaDTO> listaProveraAktZamerkaCollection) {
        this.listaProveraAktZamerkaCollection = listaProveraAktZamerkaCollection != null ? 
            listaProveraAktZamerkaCollection : new ArrayList<>();
        // Automatski postavi hasZamerka flag ako ima zamerki
        this.hasZamerka = this.listaProveraAktZamerkaCollection != null && 
                          !this.listaProveraAktZamerkaCollection.isEmpty();
    }

   
    public String getAktivnostNaziv() {
        return aktivnost != null ? aktivnost.getNaziv() : "";
    }
    
    public Integer getAktivnostId() {
        return aktivnost != null ? aktivnost.getIDAktivnosti() : null;
    }
    
        public IshodDTO getIDIshod() {
        return ishod;
    }

    

   
}