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
@Table(name = "Korisnik", schema = "dbo")
public class Korisnik implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDKorisnik")
    private Integer iDKorisnik;

    @Column(name = "UserName", nullable = false, unique = true)
    private String korisnickoIme;
    @Column(name = "ImePrezime")
    private String imePrezime;
    @Column(name = "DatumUnosa")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datumUnosa;

    
    @ManyToOne(optional = false)
    @JoinColumn(name = "IDKorisnikUnos", referencedColumnName = "IDKorisnik")
    private Korisnik iDKorisnikUnos;

    @Column(name = "DatumIzmene")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datumIzmene;

    @ManyToOne
    @JoinColumn(name = "IDKorisnikIzmena", referencedColumnName = "IDKorisnik")
    private Korisnik iDKorisnikIzmena;

    @Basic(optional = false)

    @Column(name = "Lozinka")
    private String lozinka;
    @JoinColumn(name = "IDRola", referencedColumnName = "IDRole")
    @ManyToOne(optional = false)
    private Rola iDRola;
   @JoinColumn(name = "IDSite", referencedColumnName = "IDSite")
   @ManyToOne(optional = false)
   private Sajt iDSite;

    public Korisnik() {
    }

    public Korisnik(String korisnickoIme, String lozinka) {
        this.korisnickoIme = korisnickoIme;
        this.lozinka = lozinka;
    }

    public Integer getiDKorisnik() {
        return iDKorisnik;
    }

    public void setiDKorisnik(Integer iDKorisnik) {
        this.iDKorisnik = iDKorisnik;
    }

    public String getKorisnickoIme() {
        return korisnickoIme;
    }

    public void setKorisnickoIme(String korisnickoIme) {
        this.korisnickoIme = korisnickoIme;
    }

    public String getImePrezime() {
        return imePrezime;
    }

    public void setImePrezime(String imePrezime) {
        this.imePrezime = imePrezime;
    }

    public Date getDatumUnosa() {
        return datumUnosa;
    }

    public void setDatumUnosa(Date datumUnosa) {
        this.datumUnosa = datumUnosa;
    }

    public Korisnik getiDKorisnikUnos() {
        return iDKorisnikUnos;
    }

    public void setiDKorisnikUnos(Korisnik iDKorisnikUnos) {
        this.iDKorisnikUnos = iDKorisnikUnos;
    }

    public Date getDatumIzmene() {
        return datumIzmene;
    }

    public void setDatumIzmene(Date datumIzmene) {
        this.datumIzmene = datumIzmene;
    }

    public Korisnik getiDKorisnikIzmena() {
        return iDKorisnikIzmena;
    }

    public void setiDKorisnikIzmena(Korisnik iDKorisnikIzmena) {
        this.iDKorisnikIzmena = iDKorisnikIzmena;
    }

    public String getLozinka() {
        return lozinka;
    }

    public void setLozinka(String lozinka) {
        this.lozinka = lozinka;
    }

    public Rola getiDRola() {
        return iDRola;
    }

    public void setiDRola(Rola iDRola) {
        this.iDRola = iDRola;
    }

    public Sajt getiDSite() {
        return iDSite;
    }

    public void setiDSite(Sajt iDSite) {
        this.iDSite = iDSite;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iDKorisnik != null ? iDKorisnik.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Korisnik)) {
            return false;
        }
        Korisnik other = (Korisnik) object;
        if ((this.iDKorisnik == null && other.iDKorisnik != null) || (this.iDKorisnik != null && !this.iDKorisnik.equals(other.iDKorisnik))) {
            return false;
        }
        return true;
    }

    

}
