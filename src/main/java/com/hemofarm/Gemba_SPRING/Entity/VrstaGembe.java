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
@Table(name = "VrstaGembe", schema = "dbo")
public class VrstaGembe implements Serializable {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "iDVrstaGem")
    private Collection<Aktivnost> aktivnostCollection;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDVrstaGem")
    private Integer iDVrstaGem;
    @Column(name = "Naziv")
    private String naziv;
    
   

 

 

    public VrstaGembe() {
    }

    public VrstaGembe(Integer iDVrstaGem) {
        this.iDVrstaGem = iDVrstaGem;
    }

    public Integer getiDVrstaGem() {
        return iDVrstaGem;
    }

    public void setiDVrstaGem(Integer iDVrstaGem) {
        this.iDVrstaGem = iDVrstaGem;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iDVrstaGem != null ? iDVrstaGem.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VrstaGembe)) {
            return false;
        }
        VrstaGembe other = (VrstaGembe) object;
        if ((this.iDVrstaGem == null && other.iDVrstaGem != null) || (this.iDVrstaGem != null && !this.iDVrstaGem.equals(other.iDVrstaGem))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.hemofarm.gemba.mvc.domain.VrstaGembe[ iDVrstaGem=" + iDVrstaGem + " ]";
    }



    public Collection<Aktivnost> getAktivnostCollection() {
        return aktivnostCollection;
    }

    public void setAktivnostCollection(Collection<Aktivnost> aktivnostCollection) {
        this.aktivnostCollection = aktivnostCollection;
    }
    
}
