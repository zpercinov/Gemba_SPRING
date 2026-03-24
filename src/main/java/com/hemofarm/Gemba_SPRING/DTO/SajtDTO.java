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
public class SajtDTO {
    
    private Integer iDSajt;
    private String ime;
    private Integer idKlaster;
    
   
    private KlasterDTO klaster;
    private List<ListaProveraDTO> listaProveraCollection;
    private List<KorisnikDTO> korisnikCollection;

    
    public SajtDTO() {
        this.listaProveraCollection = new ArrayList<>();
        this.korisnikCollection = new ArrayList<>();
    }

 
    public SajtDTO(Integer iDSajt, String ime, Integer idKlaster) {
        this.iDSajt = iDSajt;
        this.ime = ime;
        this.idKlaster = idKlaster;
        this.listaProveraCollection = new ArrayList<>();
        this.korisnikCollection = new ArrayList<>();
    }

    
    public SajtDTO(Integer idSajt, String ime, Integer idKlaster, 
                  KlasterDTO klaster,
                  List<ListaProveraDTO> listaProveraCollection,
                  List<KorisnikDTO> korisnikCollection) {
        this.iDSajt = idSajt;
        this.ime = ime;
        this.idKlaster = idKlaster;
        this.klaster = klaster;
        this.listaProveraCollection = listaProveraCollection != null ? listaProveraCollection : new ArrayList<>();
        this.korisnikCollection = korisnikCollection != null ? korisnikCollection : new ArrayList<>();
    }
    
    public SajtDTO(Integer idSajt, String ime) {
    this.iDSajt = idSajt;
    this.ime = ime;
    this.listaProveraCollection = new ArrayList<>();
    this.korisnikCollection = new ArrayList<>();
}

    
    public Integer getIDSajt() {
        return iDSajt;
    }

    public void setIDSajt(Integer iDSajt) {
        this.iDSajt = iDSajt;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public Integer getIdKlaster() {
        return idKlaster;
    }

    public void setIdKlaster(Integer idKlaster) {
        this.idKlaster = idKlaster;
    }

    public KlasterDTO getKlaster() {
        return klaster;
    }

    public void setKlaster(KlasterDTO klaster) {
        this.klaster = klaster;
    }

    public List<ListaProveraDTO> getListaProveraCollection() {
        return listaProveraCollection;
    }

    public void setListaProveraCollection(List<ListaProveraDTO> listaProveraCollection) {
        this.listaProveraCollection = listaProveraCollection != null ? listaProveraCollection : new ArrayList<>();
    }

    public List<KorisnikDTO> getKorisnikCollection() {
        return korisnikCollection;
    }

    public void setKorisnikCollection(List<KorisnikDTO> korisnikCollection) {
        this.korisnikCollection = korisnikCollection != null ? korisnikCollection : new ArrayList<>();
    }

    
}