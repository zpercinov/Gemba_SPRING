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
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.Transient;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

/**
 *
 * @author zpercinov
 */
@Entity
@Table(name = "ListaProveraAkt", schema = "dbo")

public class ListaProveraAkt implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)

    @Column(name = "IDLisProvereAkt")
    private Integer iDLisProvereAkt;

    @JoinColumn(name = "IDAktivnosti", referencedColumnName = "IDAktivnosti")
    @ManyToOne(optional = false)
    private Aktivnost iDAktivnosti;

    @Column(name = "UserUnos")
    private String userUnos;
    @Basic(optional = false)

    @Column(name = "DatumUnos")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datumUnos;

    @Column(name = "UserIzmena")
    private String userIzmena;

    @Column(name = "DatumIzmena")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datumIzmena;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "iDLisProvereAkt")
    private Collection<ListaProveraAktZamerka> listaProveraAktZamerkaCollection;

    @JoinColumn(name = "IDIshod", referencedColumnName = "IDIshod")
    @ManyToOne(optional = false)
    private Ishod iDIshod;

    @JoinColumn(name = "IDLisProvere", referencedColumnName = "IDLisProvere")
    @ManyToOne(optional = false)
    private ListaProvera iDLisProvere;

    public ListaProveraAkt() {
    }

    public ListaProveraAkt(Integer iDLisProvereAkt) {
        this.iDLisProvereAkt = iDLisProvereAkt;
    }

    public ListaProveraAkt(Integer iDLisProvereAkt, String userUnos, Date datumUnos) {
        this.iDLisProvereAkt = iDLisProvereAkt;
        this.userUnos = userUnos;
        this.datumUnos = datumUnos;
    }

    public Integer getiDLisProvereAkt() {
        return iDLisProvereAkt;
    }

    public void setiDLisProvereAkt(Integer iDLisProvereAkt) {
        this.iDLisProvereAkt = iDLisProvereAkt;
    }

    public Aktivnost getiDAktivnosti() {
        return iDAktivnosti;
    }

    public void setiDAktivnosti(Aktivnost iDAktivnosti) {
        this.iDAktivnosti = iDAktivnosti;
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

    public Collection<ListaProveraAktZamerka> getListaProveraAktZamerkaCollection() {
        return listaProveraAktZamerkaCollection;
    }

    public void setListaProveraAktZamerkaCollection(Collection<ListaProveraAktZamerka> listaProveraAktZamerkaCollection) {
        this.listaProveraAktZamerkaCollection = listaProveraAktZamerkaCollection;
    }

    public Ishod getiDIshod() {
        return iDIshod;
    }

    public void setiDIshod(Ishod iDIshod) {
        this.iDIshod = iDIshod;
    }

    public ListaProvera getiDLisProvere() {
        return iDLisProvere;
    }

    public void setiDLisProvere(ListaProvera iDLisProvere) {
        this.iDLisProvere = iDLisProvere;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iDLisProvereAkt != null ? iDLisProvereAkt.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ListaProveraAkt)) {
            return false;
        }
        ListaProveraAkt other = (ListaProveraAkt) object;
        if ((this.iDLisProvereAkt == null && other.iDLisProvereAkt != null) || (this.iDLisProvereAkt != null && !this.iDLisProvereAkt.equals(other.iDLisProvereAkt))) {
            return false;
        }
        return true;
    }

    @Transient
    private boolean hasZamerka;

    public boolean isHasZamerka() {
        return hasZamerka;
    }

    public void setHasZamerka(boolean hasZamerka) {
        this.hasZamerka = hasZamerka;
    }

}
