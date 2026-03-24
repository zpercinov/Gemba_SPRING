/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hemofarm.Gemba_SPRING.Mapper;

/**
 *
 * @author zpercinov
 */
public interface DtoEntityMapper<D, E> {
    
    /**
     * Konvertuje Entity u DTO
     * @param entity Entity objekat
     * @return DTO objekat
     */
    
    D toDto(E entity);
    
    /**
     * Konvertuje DTO u Entity
     * @param dto DTO objekat
     * @return Entity objekat
     */
    
    E toEntity(D dto);
}
