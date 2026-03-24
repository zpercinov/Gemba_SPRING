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

import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author zpercinov
 */
@Entity
@Table(name = "ListaProveraAktZamerka", schema  = "dbo")
public class ListaProveraAktZamerka implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDLisProvereAktZamerka")
    private Integer iDLisProvereAktZamerka;
   
    @Column(name = "Napomena")
    private String napomena;
    @Basic(optional = false)

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
    @JoinColumn(name = "IDLisProvereAkt", referencedColumnName = "IDLisProvereAkt")
    @ManyToOne(optional = false)
    private ListaProveraAkt iDLisProvereAkt;
    @JoinColumn(name = "IDZamerka", referencedColumnName = "IDZamerka")
    @ManyToOne
    private Zamerka iDZamerka;

    public ListaProveraAktZamerka() {
    }

    public ListaProveraAktZamerka(Integer iDLisProvereAktZamerka) {
        this.iDLisProvereAktZamerka = iDLisProvereAktZamerka;
    }

    public ListaProveraAktZamerka(Integer iDLisProvereAktZamerka, String userUnos, Date datumUnos) {
        this.iDLisProvereAktZamerka = iDLisProvereAktZamerka;
        this.userUnos = userUnos;
        this.datumUnos = datumUnos;
    }

    public Integer getiDLisProvereAktZamerka() {
        return iDLisProvereAktZamerka;
    }

    public void setiDLisProvereAktZamerka(Integer iDLisProvereAktZamerka) {
        this.iDLisProvereAktZamerka = iDLisProvereAktZamerka;
    }

    public String getNapomena() {
        return napomena;
    }

    public void setNapomena(String napomena) {
        this.napomena = napomena;
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

    public ListaProveraAkt getiDLisProvereAkt() {
        return iDLisProvereAkt;
    }

    public void setiDLisProvereAkt(ListaProveraAkt iDLisProvereAkt) {
        this.iDLisProvereAkt = iDLisProvereAkt;
    }

    public Zamerka getiDZamerka() {
        return iDZamerka;
    }

    public void setiDZamerka(Zamerka iDZamerka) {
        this.iDZamerka = iDZamerka;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iDLisProvereAktZamerka != null ? iDLisProvereAktZamerka.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ListaProveraAktZamerka)) {
            return false;
        }
        ListaProveraAktZamerka other = (ListaProveraAktZamerka) object;
        if ((this.iDLisProvereAktZamerka == null && other.iDLisProvereAktZamerka != null) || (this.iDLisProvereAktZamerka != null && !this.iDLisProvereAktZamerka.equals(other.iDLisProvereAktZamerka))) {
            return false;
        }
        return true;
    }

  
    
}
