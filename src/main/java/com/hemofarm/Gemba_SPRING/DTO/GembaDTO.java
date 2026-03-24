/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hemofarm.Gemba_SPRING.DTO;

import java.util.Date;
import java.util.List;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author zpercinov
 */
public class GembaDTO {
    
    
    private Integer iDLisProvere;         
    
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date datum;                     
    
    private Integer status;                 
    
  
    private String userUnos;                
    private Date datumUnos;                   
    private String userIzmena;            
    private Date datumIzmena;                 
    
 
    private VrstaGembeDTO vrstaGembe;          
    private KlasterDTO klaster;                  
    private SajtDTO sajt;                       
    private FunkcijaDTO funkcija;                
    private OdeljenjeDTO odeljenje;               
    private NosilacDTO nosilac;                   
    
 
    private List<ListaProveraAktDTO> aktivnosti;       
    
  
    private boolean zakljucano;                    // Da li je gemba zaključana
    private boolean zakljucanoVrstaGemba;          // Da li je vrsta gembe zaključana
    
 
    public GembaDTO() {
    }
    
    public GembaDTO(Integer iDLisProvere, Date datum, Integer status) {
        this.iDLisProvere = iDLisProvere;
        this.datum = datum;
        this.status = status;
    }

  
    
  
    public Integer getIDLisProvere() {
        return iDLisProvere;
    }

    public void setIDLisProvere(Integer iDLisProvere) {
        this.iDLisProvere = iDLisProvere;
    }

  
    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

  
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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

  
    public VrstaGembeDTO getVrstaGembe() {
        return vrstaGembe;
    }

    public void setVrstaGembe(VrstaGembeDTO vrstaGembe) {
        this.vrstaGembe = vrstaGembe;
    }

    public KlasterDTO getKlaster() {
        return klaster;
    }

    public void setKlaster(KlasterDTO klaster) {
        this.klaster = klaster;
    }

    public SajtDTO getSajt() {
        return sajt;
    }

    public void setSajt(SajtDTO sajt) {
        this.sajt = sajt;
    }

    public FunkcijaDTO getFunkcija() {
        return funkcija;
    }

    public void setFunkcija(FunkcijaDTO funkcija) {
        this.funkcija = funkcija;
    }

    public OdeljenjeDTO getOdeljenje() {
        return odeljenje;
    }

    public void setOdeljenje(OdeljenjeDTO odeljenje) {
        this.odeljenje = odeljenje;
    }

    public NosilacDTO getNosilac() {
        return nosilac;
    }

    public void setNosilac(NosilacDTO nosilac) {
        this.nosilac = nosilac;
    }

 
    public List<ListaProveraAktDTO> getAktivnosti() {
        return aktivnosti;
    }

    public void setAktivnosti(List<ListaProveraAktDTO> aktivnosti) {
        this.aktivnosti = aktivnosti;
    }

  
    public boolean isZakljucano() {
        return zakljucano;
    }

    public void setZakljucano(boolean zakljucano) {
        this.zakljucano = zakljucano;
    }

    public boolean isZakljucanoVrstaGemba() {
        return zakljucanoVrstaGemba;
    }

    public void setZakljucanoVrstaGemba(boolean zakljucanoVrstaGemba) {
        this.zakljucanoVrstaGemba = zakljucanoVrstaGemba;
    }

  
    public Integer getGembaId() {
        return iDLisProvere;
    }
    
   
    public boolean isArhivirana() {
        return status != null && status == 6; // 6 = ARHIVIRANO
    }
  
    public boolean isZavrsena() {
        return status != null && status == 5; // 5 = ZAVRSENO
    }
    
  
    public String getDatumString() {
        return datum != null ? datum.toString() : "";
    }

    @Override
    public String toString() {
        return "GembaDTO{" +
                "iDLisProvere=" + iDLisProvere +
                ", datum=" + datum +
                ", status=" + status +
                ", vrstaGembe=" + (vrstaGembe != null ? vrstaGembe.getNaziv() : "null") +
                ", klaster=" + (klaster != null ? klaster.getNaziv() : "null") +
                ", sajt=" + (sajt != null ? sajt.getIme() : "null") +
                ", brojAktivnosti=" + (aktivnosti != null ? aktivnosti.size() : 0) +
                '}';
    }
}
