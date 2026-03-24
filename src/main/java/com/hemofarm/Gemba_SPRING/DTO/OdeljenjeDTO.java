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
public class OdeljenjeDTO {
    
    private Integer iDOdeljenje;
    private String ime;
    private int idFun;
    private List<ListaProveraDTO> listaProveraCollection;
    
  
    private FunkcijaDTO funkcija;

   
    public OdeljenjeDTO() {
        this.listaProveraCollection = new ArrayList<>();
    }

    
    public OdeljenjeDTO(Integer idOdeljenje, String ime, int idFun) {
        this.iDOdeljenje = idOdeljenje;
        this.ime = ime;
        this.idFun = idFun;
        this.listaProveraCollection = new ArrayList<>();
    }

  
    public OdeljenjeDTO(Integer idOdeljenje, String ime, int idFun, 
                       List<ListaProveraDTO> listaProveraCollection,
                       FunkcijaDTO funkcija) {
        this.iDOdeljenje = idOdeljenje;
        this.ime = ime;
        this.idFun = idFun;
        this.listaProveraCollection = listaProveraCollection != null ? listaProveraCollection : new ArrayList<>();
        this.funkcija = funkcija;
    }

   
    public Integer getIDOdeljenje() {
        return iDOdeljenje;
    }

    public void setIDOdeljenje(Integer idOdeljenje) {
        this.iDOdeljenje = idOdeljenje;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public int getIdFun() {
        return idFun;
    }

    public void setIdFun(int idFun) {
        this.idFun = idFun;
    }

    public List<ListaProveraDTO> getListaProveraCollection() {
        return listaProveraCollection;
    }

    public void setListaProveraCollection(List<ListaProveraDTO> listaProveraCollection) {
        this.listaProveraCollection = listaProveraCollection != null ? listaProveraCollection : new ArrayList<>();
    }

    public FunkcijaDTO getFunkcija() {
        return funkcija;
    }

    public void setFunkcija(FunkcijaDTO funkcija) {
        this.funkcija = funkcija;
    }

    public String getDisplayName() {
        return ime != null ? ime : "";
    }
    
    public int getBrojProvera() {
        return listaProveraCollection != null ? listaProveraCollection.size() : 0;
    }
    
    public int getBrojAktivnihProvera() {
        if (listaProveraCollection == null) return 0;
        return (int) listaProveraCollection.stream()
                .filter(p -> p.getStatus() == 1) // 1 = AKTIVAN
                .count();
    }
    
    public int getBrojZavrsenihProvera() {
        if (listaProveraCollection == null) return 0;
        return (int) listaProveraCollection.stream()
                .filter(p -> p.getStatus() == 2) // 2 = ZAVRSEN
                .count();
    }
    
    
}