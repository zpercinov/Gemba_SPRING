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
public class KlasterDTO {
    
    private Integer iDCluster;
    private String naziv;
    private List<ListaProveraDTO> listaProveraCollection;

    
    public KlasterDTO() {
        this.listaProveraCollection = new ArrayList<>();
    }

  
    public KlasterDTO(Integer iDCluster, String naziv) {
        this.iDCluster = iDCluster;
        this.naziv = naziv;
        this.listaProveraCollection = new ArrayList<>();
    }

   
    public KlasterDTO(Integer iDCluster, String naziv, List<ListaProveraDTO> listaProveraCollection) {
        this.iDCluster = iDCluster;
        this.naziv = naziv;
        this.listaProveraCollection = listaProveraCollection != null ? listaProveraCollection : new ArrayList<>();
    }

    
    public Integer getIDCluster() {
        return iDCluster;
    }

    public void setIDCluster(Integer iDCluster) {
        this.iDCluster = iDCluster;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public List<ListaProveraDTO> getListaProveraCollection() {
        return listaProveraCollection;
    }

    public void setListaProveraCollection(List<ListaProveraDTO> listaProveraCollection) {
        this.listaProveraCollection = listaProveraCollection != null ? listaProveraCollection : new ArrayList<>();
    }

   
    public String getDisplayName() {
        return naziv != null ? naziv : "";
    }
    
    public int getBrojProvera() {
        return listaProveraCollection != null ? listaProveraCollection.size() : 0;
    }

    @Override
    public String toString() {
        return "KlasterDTO{" +
                "iDCluster=" + iDCluster +
                ", naziv='" + naziv + '\'' +
                ", brojProvera=" + getBrojProvera() +
                '}';
    }
}