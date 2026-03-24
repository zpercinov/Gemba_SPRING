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
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.io.Serializable;
import java.util.Collection;

/**
 *
 * @author zpercinov
 */
@Entity
@Table(name = "Site", schema = "dbo")
public class Sajt implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDSite")
    private Integer iDSajt;
    
    @Column(name = "Ime")
    private String ime;
    
    @Column(name = "IDCluster")
    private Integer iDKlaster;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "iDSajt")
    private Collection<ListaProvera> listaProveraCollection;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "iDSite")
    private Collection<Korisnik> korisnikCollection;

    public Sajt() {
    }

    public Sajt(Integer iDSajt) {
        this.iDSajt = iDSajt;
    }

    public Integer getiDSajt() {
        return iDSajt;
    }

    public void setiDSajt(Integer iDSajt) {
        this.iDSajt = iDSajt;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public Integer getiDCluster() {
        return iDKlaster;
    }

    public void setiDCluster(Integer iDKlaster) {
        this.iDKlaster = iDKlaster;
    }

    public Collection<ListaProvera> getListaProveraCollection() {
        return listaProveraCollection;
    }

    public void setListaProveraCollection(Collection<ListaProvera> listaProveraCollection) {
        this.listaProveraCollection = listaProveraCollection;
    }

    public Collection<Korisnik> getKorisnikCollection() {
        return korisnikCollection;
    }

    public void setKorisnikCollection(Collection<Korisnik> korisnikCollection) {
        this.korisnikCollection = korisnikCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iDSajt != null ? iDSajt.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sajt)) {
            return false;
        }
        Sajt other = (Sajt) object;
        if ((this.iDSajt == null && other.iDSajt != null) || (this.iDSajt != null && !this.iDSajt.equals(other.iDSajt))) {
            return false;
        }
        return true;
    }

  
    
}
