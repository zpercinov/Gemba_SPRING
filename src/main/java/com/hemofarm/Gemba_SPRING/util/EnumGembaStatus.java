/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package com.hemofarm.Gemba_SPRING.util;

/**
 *
 * @author zpercinov
 */
public enum EnumGembaStatus {
    START(0, "Start", "bi-play-circle", "bg-primary text-white"),
    SPREMNO_ZA_UNOS(1, "Spremno za unos", "bi-pencil-square", "bg-info text-white"),
    GEMBA_REGISTROVANA(2, "Gemba registrovana", "bi-file-earmark-check", "bg-primary text-white"),
    AKTIVNOSTI_INICIJALIZOVANE(3, "Aktivnosti inicijalizovane", "bi-gear", "bg-warning text-black"),
    FINALIZACIJA_U_TOKU(4, "Finalizacija u toku", "bi-hourglass-split", "bg-info text-white"),
    ZAVRSENO(5, "Završeno", "bi-check-circle", "bg-success text-white"),
    ARHIVIRANO(6, "Arhivirano", "bi-lock-fill", "bg-secondary text-white");

    private final int step;
    private final String label;
    private final String icon;
     private final String badgeClass;

EnumGembaStatus(int step, String label, String icon, String badgeClass) {
        this.step = step;
        this.label = label;
        this.icon = icon;
        this.badgeClass = badgeClass;
    }

    public int getStep() { return step; }

    public String getLabel() { return label; }

    public String getIcon() { return icon; }
    
     public String getBadgeClass() { return badgeClass; }
    
    public static EnumGembaStatus fromStep(int step) {
    for (EnumGembaStatus status : values()) {
        if (status.getStep() == step) return status;
    }
    return null; 
}
 
}
