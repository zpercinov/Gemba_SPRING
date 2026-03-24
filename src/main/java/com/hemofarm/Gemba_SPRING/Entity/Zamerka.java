/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hemofarm.Gemba_SPRING.Entity;

import jakarta.persistence.Basic;
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
import java.io.Serializable;
import java.util.Collection;

/**
 *
 * @author zpercinov
 */
@Entity
@Table(name = "Zamerka", schema = "dbo")
public class Zamerka implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDZamerka")
    private Integer iDZamerka;
    @Column(name = "Naziv")
    private String naziv;
    @OneToMany(mappedBy = "iDZamerka")
    private Collection<ListaProveraAktZamerka> listaProveraAktZamerkaCollection;
    @JoinColumn(name = "IDAktivnosti", referencedColumnName = "IDAktivnosti")
    @ManyToOne(optional = false)
    private Aktivnost iDAktivnosti;

    public Zamerka() {
    }

    public Zamerka(Integer iDZamerka) {
        this.iDZamerka = iDZamerka;
    }

    public Integer getiDZamerka() {
        return iDZamerka;
    }

    public void setiDZamerka(Integer iDZamerka) {
        this.iDZamerka = iDZamerka;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public Collection<ListaProveraAktZamerka> getListaProveraAktZamerkaCollection() {
        return listaProveraAktZamerkaCollection;
    }

    public void setListaProveraAktZamerkaCollection(Collection<ListaProveraAktZamerka> listaProveraAktZamerkaCollection) {
        this.listaProveraAktZamerkaCollection = listaProveraAktZamerkaCollection;
    }

    public Aktivnost getiDAktivnosti() {
        return iDAktivnosti;
    }

    public void setiDAktivnosti(Aktivnost iDAktivnosti) {
        this.iDAktivnosti = iDAktivnosti;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iDZamerka != null ? iDZamerka.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Zamerka)) {
            return false;
        }
        Zamerka other = (Zamerka) object;
        if ((this.iDZamerka == null && other.iDZamerka != null) || (this.iDZamerka != null && !this.iDZamerka.equals(other.iDZamerka))) {
            return false;
        }
        return true;
    }

   
    
}
