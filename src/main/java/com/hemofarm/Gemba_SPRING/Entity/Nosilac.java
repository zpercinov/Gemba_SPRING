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
@Table(name = "Nosilac", schema = "dbo")
public class Nosilac implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDNos")
    private Integer iDNos;
    @Basic(optional = false)

    @Column(name = "Naziv")
    private String naziv;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "iDNos")
    private Collection<ListaProvera> listaProveraCollection;

    public Nosilac() {
    }

    public Nosilac(Integer iDNos) {
        this.iDNos = iDNos;
    }

    public Nosilac(Integer iDNos, String naziv) {
        this.iDNos = iDNos;
        this.naziv = naziv;
    }

    public Integer getiDNos() {
        return iDNos;
    }

    public void setiDNos(Integer iDNos) {
        this.iDNos = iDNos;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
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
        hash += (iDNos != null ? iDNos.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Nosilac)) {
            return false;
        }
        Nosilac other = (Nosilac) object;
        if ((this.iDNos == null && other.iDNos != null) || (this.iDNos != null && !this.iDNos.equals(other.iDNos))) {
            return false;
        }
        return true;
    }

   
    
}
