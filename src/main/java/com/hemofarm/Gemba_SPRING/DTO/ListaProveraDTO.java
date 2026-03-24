/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hemofarm.Gemba_SPRING.DTO;

import com.hemofarm.Gemba_SPRING.util.EnumGembaStatus;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author zpercinov
 */
public class ListaProveraDTO {
    
    private Integer iDLisProvere;
    private Date datum;
    private String userUnos;
    private Date datumUnos;
    private String userIzmena;
    private Date datumIzmena;
    private int status;
    
  
    private KlasterDTO klaster;
    private FunkcijaDTO funkcija;
    private NosilacDTO nosilac;
    private VrstaGembeDTO vrstaGembe;
    private OdeljenjeDTO odeljenje;
    private SajtDTO sajt;
    
  
    private List<ListaProveraAktDTO> listaProveraAktCollection;

   
    public ListaProveraDTO() {
        this.listaProveraAktCollection = new ArrayList<>();
    }

    
    public ListaProveraDTO(Integer idLisProvere, Date datum, String userUnos, Date datumUnos, int status) {
        this.iDLisProvere = idLisProvere;
        this.datum = datum;
        this.userUnos = userUnos;
        this.datumUnos = datumUnos;
        this.status = status;
        this.listaProveraAktCollection = new ArrayList<>();
    }

   
    public Integer getiDLisProvere() {
        return iDLisProvere;
    }

    public void setiDLisProvere(Integer idLisProvere) {
        this.iDLisProvere = idLisProvere;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public KlasterDTO getKlaster() {
        return klaster;
    }

    public void setKlaster(KlasterDTO klaster) {
        this.klaster = klaster;
    }

    public FunkcijaDTO getFunkcija() {
        return funkcija;
    }

    public void setFunkcija(FunkcijaDTO funkcija) {
        this.funkcija = funkcija;
    }

    public NosilacDTO getNosilac() {
        return nosilac;
    }

    public void setNosilac(NosilacDTO nosilac) {
        this.nosilac = nosilac;
    }

    public VrstaGembeDTO getVrstaGembe() {
        return vrstaGembe;
    }

    public void setVrstaGembe(VrstaGembeDTO vrstaGembe) {
        this.vrstaGembe = vrstaGembe;
    }

    public OdeljenjeDTO getOdeljenje() {
        return odeljenje;
    }

    public void setOdeljenje(OdeljenjeDTO odeljenje) {
        this.odeljenje = odeljenje;
    }

    public SajtDTO getSajt() {
        return sajt;
    }

    public void setSajt(SajtDTO sajt) {
        this.sajt = sajt;
    }

    public List<ListaProveraAktDTO> getListaProveraAktCollection() {
        return listaProveraAktCollection;
    }

    public void setListaProveraAktCollection(List<ListaProveraAktDTO> listaProveraAktCollection) {
        this.listaProveraAktCollection = listaProveraAktCollection != null ? 
            listaProveraAktCollection : new ArrayList<>();
    }

    
    public EnumGembaStatus getStatusEnum() {
        return EnumGembaStatus.fromStep(this.status);
    }
    
    public String getStatusDisplay() {
        EnumGembaStatus statusEnum = getStatusEnum();
        return statusEnum != null ? statusEnum.getLabel() : "Nepoznat";
    }
    
    public String getStatusBadgeClass() {
        EnumGembaStatus statusEnum = getStatusEnum();
        if (statusEnum == null) return "bg-secondary text-white";
        
        
        return statusEnum.getBadgeClass();
    }
    
    
    

    

   
}