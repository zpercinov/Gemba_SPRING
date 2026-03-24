/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hemofarm.Gemba_SPRING.Entity;

import jakarta.persistence.Basic;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;

import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

/**
 *
 * @author zpercinov
 */
@Entity
@Table(name = "ListaProvera",schema = "dbo")
public class ListaProvera implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDLisProvere")
    private Integer iDLisProvere;
    @Basic(optional = false)
  
    @Column(name = "Datum")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datum;
    @Basic(optional = false)
  
    @Column(name = "UserUnos")
    private String userUnos;
    @Basic(optional = false)
    
    @Column(name = "DatumUnos")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datumUnos;
    
    @Column(name = "UserIzmena")
    private String userIzmena;
    
    @Column(name = "Status")
    private int  status;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
    
    
    
    @Column(name = "DatumIzmena")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datumIzmena;
   
    @JoinColumn(name = "IDCluster", referencedColumnName = "IDCluster")
    @ManyToOne(optional = false)
    private Klaster iDCluster;
    @JoinColumn(name = "IDFun", referencedColumnName = "IDFun")
    @ManyToOne(optional = false)
    private Funkcija iDFun;
    @JoinColumn(name = "IDNos", referencedColumnName = "IDNos")
    @ManyToOne(optional = false)
    private Nosilac iDNos;
    
    @JoinColumn(name = "IDVrstaGem", referencedColumnName = "IDVrstaGem")
    @ManyToOne(optional = false)
    private VrstaGembe iDVrstaGem;

  
    
    
    @JoinColumn(name = "IDOdeljenje", referencedColumnName = "IDOdeljenje")
    @ManyToOne(optional = false)
    private Odeljenje iDOdeljenje;
    @JoinColumn(name = "IDSite", referencedColumnName = "IDSite")
    @ManyToOne(optional = false)
    private Sajt iDSajt;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "iDLisProvere")
    private Collection<ListaProveraAkt> listaProveraAktCollection;

    public ListaProvera() {
    }

    public ListaProvera(Integer iDLisProvere) {
        this.iDLisProvere = iDLisProvere;
    }

    public ListaProvera(Integer iDLisProvere, Date datum, String userUnos, Date datumUnos) {
        this.iDLisProvere = iDLisProvere;
        this.datum = datum;
        this.userUnos = userUnos;
        this.datumUnos = datumUnos;
    }

    public Integer getiDLisProvere() {
        return iDLisProvere;
    }

    public void setiDLisProvere(Integer iDLisProvere) {
        this.iDLisProvere = iDLisProvere;
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



    public Klaster getiDCluster() {
        return iDCluster;
    }

    public void setiDCluster(Klaster iDCluster) {
        this.iDCluster = iDCluster;
    }

    public Funkcija getiDFun() {
        return iDFun;
    }

    public void setiDFun(Funkcija iDFun) {
        this.iDFun = iDFun;
    }

    public Nosilac getiDNos() {
        return iDNos;
    }

    public void setiDNos(Nosilac iDNos) {
        this.iDNos = iDNos;
    }

    public Odeljenje getiDOdeljenje() {
        return iDOdeljenje;
    }

    public void setiDOdeljenje(Odeljenje iDOdeljenje) {
        this.iDOdeljenje = iDOdeljenje;
    }

    public Sajt getiDSajt() {
        return iDSajt;
    }

    public void setiDSajt(Sajt iDSajt) {
        this.iDSajt = iDSajt;
    }

    public VrstaGembe getiDVrstaGem() {
        return iDVrstaGem;
    }

    public void setiDVrstaGem(VrstaGembe iDVrstaGem) {
        this.iDVrstaGem = iDVrstaGem;
    }

    
    
    public Collection<ListaProveraAkt> getListaProveraAktCollection() {
        return listaProveraAktCollection;
    }

    public void setListaProveraAktCollection(Collection<ListaProveraAkt> listaProveraAktCollection) {
        this.listaProveraAktCollection = listaProveraAktCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iDLisProvere != null ? iDLisProvere.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ListaProvera)) {
            return false;
        }
        ListaProvera other = (ListaProvera) object;
        if ((this.iDLisProvere == null && other.iDLisProvere != null) || (this.iDLisProvere != null && !this.iDLisProvere.equals(other.iDLisProvere))) {
            return false;
        }
        return true;
    }

    
}
