/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hemofarm.Gemba_SPRING.Service.impl;

import com.hemofarm.Gemba_SPRING.DTO.ListaProveraDTO;
import com.hemofarm.Gemba_SPRING.Mapper.impl.ListaProveraMapperImpl;
import com.hemofarm.Gemba_SPRING.Repository.ListaProveraRepository;
import com.hemofarm.Gemba_SPRING.Service.ListaProveraService;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ListaProveraServiceImpl implements ListaProveraService {
    
    private final ListaProveraRepository listaProveraRepository;
    private final ListaProveraMapperImpl listaProveraMapper;

    public ListaProveraServiceImpl(ListaProveraRepository listaProveraRepository,
                                  ListaProveraMapperImpl listaProveraMapper) {
        this.listaProveraRepository = listaProveraRepository;
        this.listaProveraMapper = listaProveraMapper;
    }

    @Override
    public List<ListaProveraDTO> findAll() {
        return listaProveraRepository.findAll()
                .stream()
                .map(listaProveraMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<ListaProveraDTO> findByKorisnik(String korisnickoIme) {
        return listaProveraRepository.findByUserUnos(korisnickoIme)
                .stream()
                .map(listaProveraMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<ListaProveraDTO> search(List<ListaProveraDTO> listaZaPretragu, String query) {
             if (listaZaPretragu == null || listaZaPretragu.isEmpty() || query == null || query.trim().isEmpty()) {
            return listaZaPretragu != null ? listaZaPretragu : new ArrayList<>();
        }

        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        String[] orGroups = query.toLowerCase().split("\\|");
        List<ListaProveraDTO> filtered = new ArrayList<>();

        for (ListaProveraDTO g : listaZaPretragu) {
            boolean matchesAnyOrGroup = false;
            for (String orGroup : orGroups) {
                String[] andKeywords = orGroup.trim().split("\\*");
                if (matchesAll(g, andKeywords, sdf)) {
                    matchesAnyOrGroup = true;
                    break;
                }
            }
            if (matchesAnyOrGroup) filtered.add(g);
        }
        return filtered;
    }
    
   private boolean matchesAll(ListaProveraDTO g, String[] keywords, SimpleDateFormat sdf) {
        for (String kw : keywords) {
            kw = kw.trim();
            if (kw.isEmpty()) continue;
            if (!containsKeyword(g, kw, sdf)) return false;
        }
        return true;
    }

    private boolean containsKeyword(ListaProveraDTO g, String kw, SimpleDateFormat sdf) {
        if (g.getOdeljenje() != null && g.getOdeljenje().getIme() != null
                && g.getOdeljenje().getIme().toLowerCase().contains(kw))
            return true;
        
        if (g.getKlaster() != null && g.getKlaster().getNaziv() != null
                && g.getKlaster().getNaziv().toLowerCase().contains(kw))
            return true;
        
        if (g.getVrstaGembe() != null && g.getVrstaGembe().getNaziv() != null
                && g.getVrstaGembe().getNaziv().toLowerCase().contains(kw))
            return true;
        
        if (g.getSajt() != null && g.getSajt().getIme() != null
                && g.getSajt().getIme().toLowerCase().contains(kw))
            return true;
        
        if (g.getFunkcija() != null && g.getFunkcija().getIme() != null
                && g.getFunkcija().getIme().toLowerCase().contains(kw))
            return true;
        
        if (g.getNosilac() != null && g.getNosilac().getNaziv() != null
                && g.getNosilac().getNaziv().toLowerCase().contains(kw))
            return true;
        
        if (g.getUserUnos() != null && g.getUserUnos().toLowerCase().contains(kw))
            return true;
        
        if (String.valueOf(g.getiDLisProvere()).contains(kw))
            return true;
        
        if (g.getDatum() != null && sdf.format(g.getDatum()).contains(kw))
            return true;
        
        return false;
    } 
}
