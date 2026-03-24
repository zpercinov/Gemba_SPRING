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
@Table(name = "Odeljenje",schema = "dbo")
public class Odeljenje implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDOdeljenje")
    private Integer iDOdeljenje;
 
    @Column(name = "Ime")
    private String ime;
    @Basic(optional = false)
   
    @Column(name = "IDFun")
    private int iDFun;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "iDOdeljenje")
    private Collection<ListaProvera> listaProveraCollection;

    public Odeljenje() {
    }

    public Odeljenje(Integer iDOdeljenje) {
        this.iDOdeljenje = iDOdeljenje;
    }

    public Odeljenje(Integer iDOdeljenje, int iDFun) {
        this.iDOdeljenje = iDOdeljenje;
        this.iDFun = iDFun;
    }

    public Integer getiDOdeljenje() {
        return iDOdeljenje;
    }

    public void setiDOdeljenje(Integer iDOdeljenje) {
        this.iDOdeljenje = iDOdeljenje;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public int getiDFun() {
        return iDFun;
    }

    public void setiDFun(int iDFun) {
        this.iDFun = iDFun;
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
        hash += (iDOdeljenje != null ? iDOdeljenje.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Odeljenje)) {
            return false;
        }
        Odeljenje other = (Odeljenje) object;
        if ((this.iDOdeljenje == null && other.iDOdeljenje != null) || (this.iDOdeljenje != null && !this.iDOdeljenje.equals(other.iDOdeljenje))) {
            return false;
        }
        return true;
    }

   
    
}
