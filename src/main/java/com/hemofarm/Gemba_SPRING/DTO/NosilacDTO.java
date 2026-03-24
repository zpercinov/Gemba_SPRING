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
public class NosilacDTO {
    
    private Integer iDNos;
    private String naziv;
    private List<ListaProveraDTO> listaProveraCollection;

   
    public NosilacDTO() {
        this.listaProveraCollection = new ArrayList<>();
    }

  
    public NosilacDTO(Integer iDNos, String naziv) {
        this.iDNos = iDNos;
        this.naziv = naziv;
        this.listaProveraCollection = new ArrayList<>();
    }

  
    public NosilacDTO(Integer iDNos, String naziv, List<ListaProveraDTO> listaProveraCollection) {
        this.iDNos = iDNos;
        this.naziv = naziv;
        this.listaProveraCollection = listaProveraCollection != null ? listaProveraCollection : new ArrayList<>();
    }

    
    public Integer getIDNos() {
        return iDNos;
    }

    public void setIDNos(Integer iDNos) {
        this.iDNos = iDNos;
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

   
}