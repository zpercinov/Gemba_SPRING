/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hemofarm.Gemba_SPRING.Service.impl;

import com.hemofarm.Gemba_SPRING.DTO.ListaProveraDTO;
import com.hemofarm.Gemba_SPRING.DTO.StatisticDTO;
import com.hemofarm.Gemba_SPRING.Entity.ListaProvera;
import com.hemofarm.Gemba_SPRING.Mapper.impl.ListaProveraMapperImpl;
import com.hemofarm.Gemba_SPRING.Repository.StatisticRepository;
import com.hemofarm.Gemba_SPRING.Service.StatisticService;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

/**
 *
 * @author zpercinov
 */
@Service
public class StatisticServiceImpl implements StatisticService {
    
    private static final int COMPLETED_STATUS = 5;
    private static final int MIN_PENDING_STATUS = 0;
    private static final int MAX_PENDING_STATUS = 4;
    
    private static final String FILTER_ALL = "all";
    private static final String FILTER_COMPLETED = "completed";
    private static final String FILTER_PENDING = "pending";
    private static final String FILTER_ARCHIVE = "archive";
    
    private final StatisticRepository statisticRepository;
    private final ListaProveraMapperImpl listaProveraMapper;
    
    public StatisticServiceImpl(StatisticRepository statisticRepository,
                                ListaProveraMapperImpl listaProveraMapper) {
        this.statisticRepository = statisticRepository;
        this.listaProveraMapper = listaProveraMapper;
    }
    
    @Override
    public StatisticDTO izracunajStatistiku(String username) {
     
        return statisticRepository.getStatisticForUser(username);
    }
    
    @Override
    public List<ListaProveraDTO> filtrirajPoStatusu(String username, String statusFilter) {
        List<ListaProvera> entities;
        
        if (statusFilter == null || statusFilter.equals(FILTER_ALL)) {
            entities = statisticRepository.findByUserUnos(username);
        } else if (FILTER_COMPLETED.equals(statusFilter)) {
            entities = statisticRepository.findByUserUnosAndStatus(username, COMPLETED_STATUS);
        } else if (FILTER_PENDING.equals(statusFilter)) {
            entities = statisticRepository.findByUserUnosAndStatusBetween(
                username, MIN_PENDING_STATUS, MAX_PENDING_STATUS);
        } else if (FILTER_ARCHIVE.equals(statusFilter)) {
            entities = statisticRepository.findByUserUnosAndStatusLessThanOrStatusGreaterThan(
                username, MIN_PENDING_STATUS, COMPLETED_STATUS);
        } else {
            entities = statisticRepository.findByUserUnos(username);
        }
        
     if (entities == null) {
    return new ArrayList<>();
}
return entities.stream()
        .map(listaProveraMapper::toDto)
        .collect(Collectors.toList());
    }
    
    
    @Override
    public StatisticDTO izracunajStatistiku(List<ListaProveraDTO> lista) {
        if (lista == null || lista.isEmpty()) {
            return new StatisticDTO(0, 0, 0, 0);
        }
        
        int total = lista.size();
        int completed = 0;
        int pending = 0;
        int archive = 0;
        
        for (ListaProveraDTO lp : lista) {
            Integer status = lp.getStatus();
            if (status == null) {
                archive++;
                continue;
            }
            
            if (status == COMPLETED_STATUS) {
                completed++;
            } else if (status >= MIN_PENDING_STATUS && status <= MAX_PENDING_STATUS) {
                pending++;
            } else {
                archive++;
            }
        }
        
        return new StatisticDTO(total, completed, pending, archive);
    }
    
    @Override
    public List<ListaProveraDTO> filtrirajPoStatusu(List<ListaProveraDTO> lista, String statusFilter) {
        if (statusFilter == null || statusFilter.equals(FILTER_ALL) || lista == null) {
            return lista;
        }
        
        List<ListaProveraDTO> filtered = new ArrayList<>();
        
        for (ListaProveraDTO lp : lista) {
            Integer status = lp.getStatus();
            if (status == null) {
                if (FILTER_ARCHIVE.equals(statusFilter)) {
                    filtered.add(lp);
                }
                continue;
            }
            
            if (FILTER_COMPLETED.equals(statusFilter) && status == COMPLETED_STATUS) {
                filtered.add(lp);
            } else if (FILTER_PENDING.equals(statusFilter) && status >= MIN_PENDING_STATUS && status <= MAX_PENDING_STATUS) {
                filtered.add(lp);
            } else if (FILTER_ARCHIVE.equals(statusFilter) && (status < MIN_PENDING_STATUS || status > COMPLETED_STATUS)) {
                filtered.add(lp);
            }
        }
        
        return filtered;
    }
}