/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hemofarm.Gemba_SPRING.DTO;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Hunter
 */
public class FunkcijaDTO {
    
    private Integer idFun;
    private String ime;
    private List<ListaProveraDTO> listaProveraCollection; // Opciono - samo ako treba

    // Default konstruktor
    public FunkcijaDTO() {
        this.listaProveraCollection = new ArrayList<>();
    }


    public FunkcijaDTO(Integer idFun, String ime) {
        this.idFun = idFun;
        this.ime = ime;
        this.listaProveraCollection = new ArrayList<>();
    }

    
    public FunkcijaDTO(Integer idFun, String ime, List<ListaProveraDTO> listaProveraCollection) {
        this.idFun = idFun;
        this.ime = ime;
        this.listaProveraCollection = listaProveraCollection != null ? listaProveraCollection : new ArrayList<>();
    }

    
    public Integer getIDFun() {
        return idFun;
    }

    public void setIDFun(Integer idFun) {
        this.idFun = idFun;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public List<ListaProveraDTO> getListaProveraCollection() {
        return listaProveraCollection;
    }

    public void setListaProveraCollection(List<ListaProveraDTO> listaProveraCollection) {
        this.listaProveraCollection = listaProveraCollection != null ? listaProveraCollection : new ArrayList<>();
    }

    
}