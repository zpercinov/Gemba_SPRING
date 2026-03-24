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
import java.io.Serializable;

/**
 *
 * @author zpercinov
 */
@Entity
@Table(name = "Aktivnost" , schema = "dbo")
public class Aktivnost implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDAktivnosti")
    private Integer iDAktivnosti;
    @Basic(optional = false)
    @Column(name = "Naziv")
    private String naziv;
    @JoinColumn(name = "IDVrstaGem", referencedColumnName = "IDVrstaGem")
    @ManyToOne(optional = false)
    private VrstaGembe iDVrstaGem;

    public Aktivnost() {
    }

    public Aktivnost(Integer iDAktivnosti) {
        this.iDAktivnosti = iDAktivnosti;
    }

    public Aktivnost(Integer iDAktivnosti, String naziv) {
        this.iDAktivnosti = iDAktivnosti;
        this.naziv = naziv;
    }

    public Integer getiDAktivnosti() {
        return iDAktivnosti;
    }

    public void setiDAktivnosti(Integer iDAktivnosti) {
        this.iDAktivnosti = iDAktivnosti;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public VrstaGembe getiDVrstaGem() {
        return iDVrstaGem;
    }

    public void setiDVrstaGem(VrstaGembe iDVrstaGem) {
        this.iDVrstaGem = iDVrstaGem;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iDAktivnosti != null ? iDAktivnosti.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Aktivnost)) {
            return false;
        }
        Aktivnost other = (Aktivnost) object;
        if ((this.iDAktivnosti == null && other.iDAktivnosti != null) || (this.iDAktivnosti != null && !this.iDAktivnosti.equals(other.iDAktivnosti))) {
            return false;
        }
        return true;
    }

  
    
}
