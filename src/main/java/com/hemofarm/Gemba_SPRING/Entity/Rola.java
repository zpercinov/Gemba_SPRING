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
@Table(name = "Rola", schema = "dbo")
public class Rola implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDRole")
    private Integer iDRole;
    @Column(name = "Ime")
    private String ime;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "iDRola")
    private Collection<Korisnik> korisnikCollection;

    public Rola() {
    }

    public Rola(Integer iDRole) {
        this.iDRole = iDRole;
    }

    public Integer getIDRole() {
        return iDRole;
    }

    public void setIDRole(Integer iDRole) {
        this.iDRole = iDRole;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public Collection<Korisnik> getKorisnikCollection() {
        return korisnikCollection;
    }

    public void setKorisnikCollection(Collection<Korisnik> korisnikCollection) {
        this.korisnikCollection = korisnikCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iDRole != null ? iDRole.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Rola)) {
            return false;
        }
        Rola other = (Rola) object;
        if ((this.iDRole == null && other.iDRole != null) || (this.iDRole != null && !this.iDRole.equals(other.iDRole))) {
            return false;
        }
        return true;
    }

 
    
}
