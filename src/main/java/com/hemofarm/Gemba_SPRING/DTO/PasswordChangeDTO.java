/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hemofarm.Gemba_SPRING.DTO;

/**
 *
 * @author zpercinov
 */
public class PasswordChangeDTO {
    private String novaLozinka;
    private String potvrdaLozinke;
    
    public String getNovaLozinka() {
        return novaLozinka;
    }
    
    public void setNovaLozinka(String novaLozinka) {
        this.novaLozinka = novaLozinka;
    }
    
    public String getPotvrdaLozinke() {
        return potvrdaLozinke;
    }
    
    public void setPotvrdaLozinke(String potvrdaLozinke) {
        this.potvrdaLozinke = potvrdaLozinke;
    }
}