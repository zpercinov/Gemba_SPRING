/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hemofarm.Gemba_SPRING.DTO;

/**
 *
 * @author zpercinov
 */
public class StatisticDTO {
    
    private int total;
    private int completed;
    private int pending;
    private int archive;
    
    public StatisticDTO() {
    }
    
    public StatisticDTO(int total, int completed, int pending, int archive) {
        this.total = total;
        this.completed = completed;
        this.pending = pending;
        this.archive = archive;
    }
    
 
    public int getTotal() {
        return total;
    }
    
    public void setTotal(int total) {
        this.total = total;
    }
    
    public int getCompleted() {
        return completed;
    }
    
    public void setCompleted(int completed) {
        this.completed = completed;
    }
    
    public int getPending() {
        return pending;
    }
    
    public void setPending(int pending) {
        this.pending = pending;
    }
    
    public int getArchive() {
        return archive;
    }
    
    public void setArchive(int archive) {
        this.archive = archive;
    }
}
    

