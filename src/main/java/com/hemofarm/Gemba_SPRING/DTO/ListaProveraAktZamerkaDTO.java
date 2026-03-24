/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hemofarm.Gemba_SPRING.DTO;

import java.util.Date;

/**
 *
 * @author Hunter
 */
public class ListaProveraAktZamerkaDTO {
    
    private Integer idLisProvereAktZamerka;
    private String napomena;
    private String userUnos;
    private Date datumUnos;
    private String userIzmena;
    private Date datumIzmena;
    
    // Related DTOs
    private ListaProveraAktDTO listaProveraAkt;
    private ZamerkaDTO zamerka;

    // Default konstruktor
    public ListaProveraAktZamerkaDTO() {
    }

    // Konstruktor sa osnovnim poljima
    public ListaProveraAktZamerkaDTO(Integer idLisProvereAktZamerka, String userUnos, Date datumUnos) {
        this.idLisProvereAktZamerka = idLisProvereAktZamerka;
        this.userUnos = userUnos;
        this.datumUnos = datumUnos;
    }

    // Konstruktor sa svim poljima
    public ListaProveraAktZamerkaDTO(Integer idLisProvereAktZamerka, String napomena, 
                                     String userUnos, Date datumUnos, 
                                     String userIzmena, Date datumIzmena,
                                     ListaProveraAktDTO listaProveraAkt, 
                                     ZamerkaDTO zamerka) {
        this.idLisProvereAktZamerka = idLisProvereAktZamerka;
        this.napomena = napomena;
        this.userUnos = userUnos;
        this.datumUnos = datumUnos;
        this.userIzmena = userIzmena;
        this.datumIzmena = datumIzmena;
        this.listaProveraAkt = listaProveraAkt;
        this.zamerka = zamerka;
    }

    // Getteri i setteri
    public Integer getIDLisProvereAktZamerka() {
        return idLisProvereAktZamerka;
    }

    public void setIDLisProvereAktZamerka(Integer idLisProvereAktZamerka) {
        this.idLisProvereAktZamerka = idLisProvereAktZamerka;
    }

    public String getNapomena() {
        return napomena;
    }

    public void setNapomena(String napomena) {
        this.napomena = napomena;
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

    public ListaProveraAktDTO getListaProveraAkt() {
        return listaProveraAkt;
    }

    public void setListaProveraAkt(ListaProveraAktDTO listaProveraAkt) {
        this.listaProveraAkt = listaProveraAkt;
    }

    public ZamerkaDTO getZamerka() {
        return zamerka;
    }

    public void setZamerka(ZamerkaDTO zamerka) {
        this.zamerka = zamerka;
    }

    // Pomoćne metode za ListaProveraAkt
    public Integer getListaProveraAktId() {
        return listaProveraAkt != null ? listaProveraAkt.getIDLisProvereAkt() : null;
    }
    
    public String getListaProveraAktNaziv() {
        if (listaProveraAkt != null && listaProveraAkt.getAktivnost() != null) {
            return listaProveraAkt.getAktivnostNaziv();
        }
        return "";
    }

    
    
}