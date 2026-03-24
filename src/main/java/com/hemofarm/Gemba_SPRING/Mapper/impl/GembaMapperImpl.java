/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hemofarm.Gemba_SPRING.Mapper.impl;


import com.hemofarm.Gemba_SPRING.DTO.GembaDTO;
import com.hemofarm.Gemba_SPRING.DTO.ListaProveraAktDTO;
import com.hemofarm.Gemba_SPRING.Entity.ListaProvera;
import com.hemofarm.Gemba_SPRING.Entity.ListaProveraAkt;
import com.hemofarm.Gemba_SPRING.Mapper.DtoEntityMapper;
import com.hemofarm.Gemba_SPRING.util.EnumGembaStatus;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

/**
 *
 * @author zpercinov
 */
@Component
public class GembaMapperImpl implements DtoEntityMapper<GembaDTO, ListaProvera> {

    private final VrstaGembeMapperImpl vrstaGembeMapper;
    private final KlasterMapperImpl klasterMapper;
    private final SajtMapperImpl sajtMapper;
    private final FunkcijaMapperImpl funkcijaMapper;
    private final OdeljenjeMapperImpl odeljenjeMapper;
    private final NosilacMapperImpl nosilacMapper;
    private final ListaProveraAktMapperImpl listaProveraAktMapper;

    public GembaMapperImpl(VrstaGembeMapperImpl vrstaGembeMapper,
                          KlasterMapperImpl klasterMapper,
                          SajtMapperImpl sajtMapper,
                          FunkcijaMapperImpl funkcijaMapper,
                          OdeljenjeMapperImpl odeljenjeMapper,
                          NosilacMapperImpl nosilacMapper,
                          ListaProveraAktMapperImpl listaProveraAktMapper) {
        this.vrstaGembeMapper = vrstaGembeMapper;
        this.klasterMapper = klasterMapper;
        this.sajtMapper = sajtMapper;
        this.funkcijaMapper = funkcijaMapper;
        this.odeljenjeMapper = odeljenjeMapper;
        this.nosilacMapper = nosilacMapper;
        this.listaProveraAktMapper = listaProveraAktMapper;;
    }

    @Override
    public GembaDTO toDto(ListaProvera entity) {
        if (entity == null) return null;
        
        GembaDTO dto = new GembaDTO();
        
        
        dto.setIDLisProvere(entity.getiDLisProvere());
        dto.setDatum(entity.getDatum());
        dto.setStatus(entity.getStatus());
        
       
        dto.setUserUnos(entity.getUserUnos());
        dto.setDatumUnos(entity.getDatumUnos());
        dto.setUserIzmena(entity.getUserIzmena());
        dto.setDatumIzmena(entity.getDatumIzmena());
        
        
        if (entity.getiDVrstaGem()!= null) {
            dto.setVrstaGembe(vrstaGembeMapper.toDto(entity.getiDVrstaGem()));
        }
        
        if (entity.getiDCluster()!= null) {
            dto.setKlaster(klasterMapper.toDto(entity.getiDCluster()));
        }
        
        if (entity.getiDSajt()!= null) {
            dto.setSajt(sajtMapper.toDto(entity.getiDSajt()));
        }
        
        if (entity.getiDFun()!= null) {
            dto.setFunkcija(funkcijaMapper.toDto(entity.getiDFun()));
        }
        
        if (entity.getiDOdeljenje()!= null) {
            dto.setOdeljenje(odeljenjeMapper.toDto(entity.getiDOdeljenje()));
        }
        
        if (entity.getiDNos()!= null) {
            dto.setNosilac(nosilacMapper.toDto(entity.getiDNos()));
        }
        
       
        
if (entity.getListaProveraAktCollection() != null && !entity.getListaProveraAktCollection().isEmpty()) {
    List<ListaProveraAktDTO> aktivnostiList = new ArrayList<>();
    
    for (Object obj : entity.getListaProveraAktCollection()) {
        if (obj instanceof ListaProveraAkt) {
            ListaProveraAkt akt = (ListaProveraAkt) obj;
            aktivnostiList.add(listaProveraAktMapper.toBasicDto(akt));  
        }
    }
    
    dto.setAktivnosti(aktivnostiList); 
    dto.setZakljucanoVrstaGemba(!aktivnostiList.isEmpty());
}
        
    

Integer status = entity.getStatus();
if (status != null) {
    dto.setZakljucano(status == EnumGembaStatus.ARHIVIRANO.getStep());
} else {
    dto.setZakljucano(false);
}

        return dto;
    }

    @Override
    public ListaProvera toEntity(GembaDTO dto) {
        if (dto == null) return null;
        
        ListaProvera entity = new ListaProvera();
        entity.setiDLisProvere(dto.getIDLisProvere());
        entity.setDatum(dto.getDatum());
        entity.setStatus(dto.getStatus());
        
        entity.setUserUnos(dto.getUserUnos());
        entity.setDatumUnos(dto.getDatumUnos());
        entity.setUserIzmena(dto.getUserIzmena());
        entity.setDatumIzmena(dto.getDatumIzmena());
        
        return entity;
    }
}
