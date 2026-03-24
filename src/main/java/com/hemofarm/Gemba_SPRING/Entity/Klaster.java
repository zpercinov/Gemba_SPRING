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
@Table(name = "Cluster",schema = "dbo")
public class Klaster implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDCluster")
    private Integer iDKlaster;
   
    @Column(name = "Naziv")
    private String naziv;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "iDCluster")
    private Collection<ListaProvera> listaProveraCollection;

    public Klaster() {
    }

    public Klaster(Integer klasterId) {
        this.iDKlaster = klasterId;
    }

    public Integer getiDCluster() {
        return iDKlaster;
    }

    public void setiDCluster(Integer iDKlaster) {
        this.iDKlaster = iDKlaster;
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
        hash += (iDKlaster != null ? iDKlaster.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Klaster)) {
            return false;
        }
        Klaster other = (Klaster) object;
        if ((this.iDKlaster == null && other.iDKlaster != null) || (this.iDKlaster != null && !this.iDKlaster.equals(other.iDKlaster))) {
            return false;
        }
        return true;
    }

   
    
}
