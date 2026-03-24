/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package com.hemofarm.Gemba_SPRING.util;

/**
 *
 * @author zpercinov
 */
public enum EnumActionMode {
    
    UNOS("Unos Gembe - "+EnumGembaStatus.START.getLabel(), "bi-pencil-square"),
    UNOS_NOVI_UNOS("Unos Gembe - "+EnumGembaStatus.SPREMNO_ZA_UNOS.getLabel(), "bi-pencil-square"),
    UNOS_SAVE("Unos Gembe - "+EnumGembaStatus.GEMBA_REGISTROVANA.getLabel(), "bi-pencil-square"),
    UNOS_AKTIVNOST("Unos Gembe - "+EnumGembaStatus.AKTIVNOSTI_INICIJALIZOVANE.getLabel(), "bi-pencil-square"),
    UNOS_IZMENI_ISHOD("Unos Gembe - "+EnumGembaStatus.FINALIZACIJA_U_TOKU.getLabel(), "bi-pencil-square"),
    UNOS_OBRISI_ISHOD("Unos Gembe - "+EnumGembaStatus.FINALIZACIJA_U_TOKU.getLabel(), "bi-pencil-square"),
    UNOS_ZAVRSENO("Unos Gembe - "+EnumGembaStatus.ZAVRSENO.getLabel(), "bi-pencil-square"),
    UNOS_ARHIVIRANO("Unos Gembe - "+EnumGembaStatus.ARHIVIRANO.getLabel(), "bi-pencil-square"),
    IZMENA("Izmena Gembe", "bi-pencil"),
    PREGLED("Pregled Gembe", "bi-eye"),
    PROFIL("Profil", "bi bi-person-square"),
    ADMINISTRACIJA("Administracija", "bi bi-gear-fill"),
    STATISTIKA("Statistika", "bi bi-bar-chart-fill"),
    ZAMERKA("Zamerka", "bi bi-exclamation-circle-fill"),
    ZAMERKA_NIJE_OK("Zamerku je nemoguće uneti jer ISHOD mora da ima vrednost NIJE OK", "bi bi-exclamation-circle-fill"),
    DASHBOARD("Gemba Dashboard",  "bi bi-motherboard"),
    DASHBOARD_SEARCH("Gemba Dashboard -  Pretraga",  "bi bi-motherboard"),
    DASHBOARD_SVE_GEMBE("Gemba Dashboard -  Sve Gembe",  "bi bi-motherboard"),
    DASHBOARD_MOJE_GEMBE("Gemba Dashboard - Moje Gembe",  "bi bi-motherboard");

    private final String displayText;
    
    private final String iconClass;

    EnumActionMode(String displayText, String iconClass) {
    
        this.displayText = displayText;
        this.iconClass = iconClass;
    }

    public String getDisplayText() {
        return displayText;
    }

    public String getIconClass() {
        return iconClass;
    }
}
