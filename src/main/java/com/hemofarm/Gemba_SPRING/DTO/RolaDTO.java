/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hemofarm.Gemba_SPRING.DTO;

/**
 *
 * @author zpercinov
 */
public class RolaDTO {
    
    private Integer iDRole;
    private String naziv;
    
   public RolaDTO() {
    }

    public RolaDTO(Integer iDRole, String naziv) {
        this.iDRole = iDRole;
        this.naziv = naziv;
    }

    public Integer getIDRole() {
        return iDRole;
    }

    public void setIDRole(Integer iDRole) {
        this.iDRole = iDRole;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    @Override
    public String toString() {
        return "RolaDto{" + "id=" + iDRole + ", naziv=" + naziv + '}';
    }
   
   
    
    
    
}
