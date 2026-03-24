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
public class IshodDTO {
    
    private Integer idIshod;
    private String naziv;
    private List<ListaProveraAktDTO> listaProveraAktCollection;

   
    public IshodDTO() {
        this.listaProveraAktCollection = new ArrayList<>();
    }

   
    public IshodDTO(Integer idIshod, String naziv) {
        this.idIshod = idIshod;
        this.naziv = naziv;
        this.listaProveraAktCollection = new ArrayList<>();
    }

  
    public IshodDTO(Integer idIshod, String naziv, List<ListaProveraAktDTO> listaProveraAktCollection) {
        this.idIshod = idIshod;
        this.naziv = naziv;
        this.listaProveraAktCollection = listaProveraAktCollection != null ? listaProveraAktCollection : new ArrayList<>();
    }

   
    public Integer getIDIshod() {
        return idIshod;
    }

    public void setIDIshod(Integer idIshod) {
        this.idIshod = idIshod;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public List<ListaProveraAktDTO> getListaProveraAktCollection() {
        return listaProveraAktCollection;
    }

    public void setListaProveraAktCollection(List<ListaProveraAktDTO> listaProveraAktCollection) {
        this.listaProveraAktCollection = listaProveraAktCollection != null ? listaProveraAktCollection : new ArrayList<>();
    }

    
}