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
@Table(name = "[Function]", schema = "dbo")
public class Funkcija implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDFun")
    private Integer iDFun;
    
    @Column(name = "Ime")
    private String ime;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "iDFun")
    private Collection<ListaProvera> listaProveraCollection;

    public Funkcija() {
    }

    public Funkcija(Integer iDFun) {
        this.iDFun = iDFun;
    }

    public Integer getiDFun() {
        return iDFun;
    }

    public void setiDFun(Integer iDFun) {
        this.iDFun = iDFun;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public Collection<ListaProvera> getListaProveraCollection() {
        return listaProveraCollection;
    }

    public void setListaProveraCollection(Collection<ListaProvera> listaProveraCollection) {
        this.listaProveraCollection = listaProveraCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iDFun != null ? iDFun.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Funkcija)) {
            return false;
        }
        Funkcija other = (Funkcija) object;
        if ((this.iDFun == null && other.iDFun != null) || (this.iDFun != null && !this.iDFun.equals(other.iDFun))) {
            return false;
        }
        return true;
    }

  
    
}
