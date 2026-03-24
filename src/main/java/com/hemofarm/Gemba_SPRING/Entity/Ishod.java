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
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.util.Collection;

/**
 *
 * @author zpercinov
 */
@Entity
@Table(name = "Ishod", schema = "dbo")
public class Ishod implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDIshod")
    private Integer iDIshod;
  
    @Column(name = "Naziv")
    private String naziv;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "iDIshod")
    private Collection<ListaProveraAkt> listaProveraAktCollection;

    public Ishod() {
    }

    public Ishod(Integer iDIshod) {
        this.iDIshod = iDIshod;
    }

    public Integer getiDIshod() {
        return iDIshod;
    }

    public void setiDIshod(Integer iDIshod) {
        this.iDIshod = iDIshod;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
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
        hash += (iDIshod != null ? iDIshod.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ishod)) {
            return false;
        }
        Ishod other = (Ishod) object;
        if ((this.iDIshod == null && other.iDIshod != null) || (this.iDIshod != null && !this.iDIshod.equals(other.iDIshod))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.hemofarm.gemba.mvc.domain.Ishod[ iDIshod=" + iDIshod + " ]";
    }
    
}
