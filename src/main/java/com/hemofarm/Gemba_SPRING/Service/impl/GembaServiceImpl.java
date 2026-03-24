/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hemofarm.Gemba_SPRING.Service.impl;

import com.hemofarm.Gemba_SPRING.DTO.AktivnostDTO;
import com.hemofarm.Gemba_SPRING.DTO.FunkcijaDTO;
import com.hemofarm.Gemba_SPRING.DTO.GembaDTO;
import com.hemofarm.Gemba_SPRING.DTO.IshodDTO;
import com.hemofarm.Gemba_SPRING.DTO.KlasterDTO;
import com.hemofarm.Gemba_SPRING.DTO.ListaProveraAktDTO;
import com.hemofarm.Gemba_SPRING.DTO.ListaProveraAktZamerkaDTO;
import com.hemofarm.Gemba_SPRING.DTO.NosilacDTO;
import com.hemofarm.Gemba_SPRING.DTO.OdeljenjeDTO;
import com.hemofarm.Gemba_SPRING.DTO.SajtDTO;
import com.hemofarm.Gemba_SPRING.DTO.VrstaGembeDTO;
import com.hemofarm.Gemba_SPRING.DTO.ZamerkaDTO;
import com.hemofarm.Gemba_SPRING.Entity.Aktivnost;
import com.hemofarm.Gemba_SPRING.Entity.Ishod;
import com.hemofarm.Gemba_SPRING.Entity.ListaProvera;
import com.hemofarm.Gemba_SPRING.Entity.ListaProveraAkt;
import com.hemofarm.Gemba_SPRING.Entity.ListaProveraAktZamerka;
import com.hemofarm.Gemba_SPRING.Entity.Zamerka;
import com.hemofarm.Gemba_SPRING.Mapper.impl.AktivnostMapperImpl;
import com.hemofarm.Gemba_SPRING.Mapper.impl.FunkcijaMapperImpl;
import com.hemofarm.Gemba_SPRING.Mapper.impl.GembaMapperImpl;
import com.hemofarm.Gemba_SPRING.Mapper.impl.IshodMapperImpl;
import com.hemofarm.Gemba_SPRING.Mapper.impl.KlasterMapperImpl;
import com.hemofarm.Gemba_SPRING.Mapper.impl.ListaProveraAktMapperImpl;
import com.hemofarm.Gemba_SPRING.Mapper.impl.ListaProveraAktZamerkaMapperImpl;
import com.hemofarm.Gemba_SPRING.Mapper.impl.NosilacMapperImpl;
import com.hemofarm.Gemba_SPRING.Mapper.impl.OdeljenjeMapperImpl;
import com.hemofarm.Gemba_SPRING.Mapper.impl.SajtMapperImpl;
import com.hemofarm.Gemba_SPRING.Mapper.impl.VrstaGembeMapperImpl;
import com.hemofarm.Gemba_SPRING.Repository.AktivnostRepository;
import com.hemofarm.Gemba_SPRING.Repository.FunkcijaRepository;
import com.hemofarm.Gemba_SPRING.Repository.IshodRepository;
import com.hemofarm.Gemba_SPRING.Repository.KlasterRepository;
import com.hemofarm.Gemba_SPRING.Repository.ListaProveraAktRepository;
import com.hemofarm.Gemba_SPRING.Repository.ListaProveraAktZamerkaRepository;
import com.hemofarm.Gemba_SPRING.Repository.ListaProveraRepository;
import com.hemofarm.Gemba_SPRING.Repository.NosilacRepository;
import com.hemofarm.Gemba_SPRING.Repository.OdeljenjeRepository;
import com.hemofarm.Gemba_SPRING.Repository.SajtRepository;
import com.hemofarm.Gemba_SPRING.Repository.VrstaGembeRepository;
import com.hemofarm.Gemba_SPRING.Repository.ZamerkaRepository;
import com.hemofarm.Gemba_SPRING.Service.GembaService;
import com.hemofarm.Gemba_SPRING.util.EnumGembaStatus;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

/**
 *
 * @author zpercinov
 */
@Service
public class GembaServiceImpl implements GembaService {

    private final ListaProveraRepository listaProveraRepository;
    private final VrstaGembeRepository vrstaGembeRepository;
    private final KlasterRepository klasterRepository;
    private final FunkcijaRepository funkcijaRepository;
    private final OdeljenjeRepository odeljenjeRepository;
    private final NosilacRepository nosilacRepository;
    private final SajtRepository sajtRepository;
    private final IshodRepository ishodRepository;
    private final AktivnostRepository aktivnostRepository;
    private final ListaProveraAktRepository listaProveraAktRepository;
    
    private final VrstaGembeMapperImpl vrstaGembeMapper;
    private final KlasterMapperImpl klasterMapper;
    private final FunkcijaMapperImpl funkcijaMapper;
    private final OdeljenjeMapperImpl odeljenjeMapper;
    private final NosilacMapperImpl nosilacMapper;
    private final SajtMapperImpl sajtMapper;
    private final IshodMapperImpl ishodMapper;
    private final AktivnostMapperImpl aktivnostMapper;
    private final ListaProveraAktMapperImpl listaProveraAktMapper;
    private final GembaMapperImpl gembaMapper;
    private final ZamerkaRepository zamerkaRepository;
    private final ListaProveraAktZamerkaRepository listaProveraAktZamerkaRepository;
    private final ListaProveraAktZamerkaMapperImpl listaProveraAktZamerkaMapperImpl;

    public GembaServiceImpl(
            ListaProveraRepository listaProveraRepository,
            VrstaGembeRepository vrstaGembeRepository,
            KlasterRepository klasterRepository,
            FunkcijaRepository funkcijaRepository,
            OdeljenjeRepository odeljenjeRepository,
            NosilacRepository nosilacRepository,
            SajtRepository sajtRepository,
            IshodRepository ishodRepository,
            AktivnostRepository aktivnostRepository,
            ListaProveraAktRepository listaProveraAktRepository,
            VrstaGembeMapperImpl vrstaGembeMapper,
            KlasterMapperImpl klasterMapper,
            FunkcijaMapperImpl funkcijaMapper,
            OdeljenjeMapperImpl odeljenjeMapper,
            NosilacMapperImpl nosilacMapper,
            SajtMapperImpl sajtMapper,
            IshodMapperImpl ishodMapper,
            AktivnostMapperImpl aktivnostMapper,
            ListaProveraAktMapperImpl listaProveraAktMapper,
            GembaMapperImpl gembaMapper,
            ZamerkaRepository zamerkaRepository,
            ListaProveraAktZamerkaRepository listaProveraAktZamerkaRepository,
            ListaProveraAktZamerkaMapperImpl listaProveraAktZamerkaMapperImpl) {
        this.listaProveraRepository = listaProveraRepository;
        this.vrstaGembeRepository = vrstaGembeRepository;
        this.klasterRepository = klasterRepository;
        this.funkcijaRepository = funkcijaRepository;
        this.odeljenjeRepository = odeljenjeRepository;
        this.nosilacRepository = nosilacRepository;
        this.sajtRepository = sajtRepository;
        this.ishodRepository = ishodRepository;
        this.aktivnostRepository = aktivnostRepository;
        this.listaProveraAktRepository = listaProveraAktRepository;
        this.vrstaGembeMapper = vrstaGembeMapper;
        this.klasterMapper = klasterMapper;
        this.funkcijaMapper = funkcijaMapper;
        this.odeljenjeMapper = odeljenjeMapper;
        this.nosilacMapper = nosilacMapper;
        this.sajtMapper = sajtMapper;
        this.ishodMapper = ishodMapper;
        this.aktivnostMapper = aktivnostMapper;
        this.listaProveraAktMapper = listaProveraAktMapper;
        this.gembaMapper = gembaMapper;
        this.zamerkaRepository = zamerkaRepository;
        this.listaProveraAktZamerkaRepository = listaProveraAktZamerkaRepository;
        this.listaProveraAktZamerkaMapperImpl = listaProveraAktZamerkaMapperImpl;
        
    }

    @Override
    public GembaDTO createNewGemba() {
        GembaDTO dto = new GembaDTO();
        dto.setDatum(new Date());
        dto.setStatus(EnumGembaStatus.START.getStep());
        return dto;
    }

    @Override
    public GembaDTO findGembaById(Integer id) {
        ListaProvera entity = listaProveraRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Gemba nije pronađena"));
        return gembaMapper.toDto(entity);
    }

    @Override
    public List<VrstaGembeDTO> findAllVrstaGembe() {
        return vrstaGembeRepository.findAll().stream()
                .map(vrstaGembeMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<KlasterDTO> findAllKlasteri() {
        return klasterRepository.findAll().stream()
                .map(klasterMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<FunkcijaDTO> findAllFunkcije() {
        return funkcijaRepository.findAll().stream()
                .map(funkcijaMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<OdeljenjeDTO> findAllOdeljenja() {
        return odeljenjeRepository.findAll().stream()
                .map(odeljenjeMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<NosilacDTO> findAllNosioci() {
        return nosilacRepository.findAll().stream()
                .map(nosilacMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<SajtDTO> findAllSajtovi() {
        return sajtRepository.findAll().stream()
                .map(sajtMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<IshodDTO> findAllIshodi() {
        return ishodRepository.findAll().stream()
                .map(ishodMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<AktivnostDTO> findAktivnostiByVrstaGembe(Integer idVrstaGembe) {
        return aktivnostRepository.findByVrstaGembeId(idVrstaGembe).stream()
                .map(aktivnostMapper::toDto)
                .collect(Collectors.toList());
    }

 @Override
@Transactional
public Integer saveGemba(GembaDTO gembaDTO, String loggedUser) {
    ListaProvera entity;
    
    if (gembaDTO.getIDLisProvere() == null) {
        // Novi unos
        entity = new ListaProvera();
        entity.setDatumUnos(new Date());
        entity.setUserUnos(String.valueOf(loggedUser));
        entity.setStatus(EnumGembaStatus.GEMBA_REGISTROVANA.getStep());
    } else {
        
        entity = listaProveraRepository.findById(gembaDTO.getIDLisProvere())
                .orElseThrow(() -> new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Gemba nije pronađena"));
        entity.setDatumIzmena(new Date());
        entity.setUserIzmena(String.valueOf(loggedUser));
    }
    
   
    entity.setDatum(gembaDTO.getDatum());
    
    
    if (gembaDTO.getVrstaGembe() != null && gembaDTO.getVrstaGembe().getIDVrstaGem() != null) {
        entity.setiDVrstaGem(vrstaGembeRepository.findById(gembaDTO.getVrstaGembe().getIDVrstaGem())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Vrsta gembe nije pronađena")));
    }
    
    if (gembaDTO.getKlaster() != null && gembaDTO.getKlaster().getIDCluster() != null) {
        entity.setiDCluster(klasterRepository.findById(gembaDTO.getKlaster().getIDCluster())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Klaster nije pronađen")));
    }
    
    if (gembaDTO.getSajt() != null && gembaDTO.getSajt().getIDSajt() != null) {
        entity.setiDSajt(sajtRepository.findById(gembaDTO.getSajt().getIDSajt())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Sajt nije pronađen")));
    }
    
    if (gembaDTO.getFunkcija() != null && gembaDTO.getFunkcija().getIDFun() != null) {
        entity.setiDFun(funkcijaRepository.findById(gembaDTO.getFunkcija().getIDFun())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Funkcija nije pronađena")));
    }
    
    if (gembaDTO.getOdeljenje() != null && gembaDTO.getOdeljenje().getIDOdeljenje() != null) {
        entity.setiDOdeljenje(odeljenjeRepository.findById(gembaDTO.getOdeljenje().getIDOdeljenje())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Odeljenje nije pronađeno")));
    }
    
    if (gembaDTO.getNosilac() != null && gembaDTO.getNosilac().getIDNos() != null) {
        entity.setiDNos(nosilacRepository.findById(gembaDTO.getNosilac().getIDNos())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Nosilac nije pronađen")));
    }
    
    ListaProvera savedEntity = listaProveraRepository.save(entity);
    return savedEntity.getiDLisProvere();  // ← Vraća ID sačuvane gembe
}

 @Override
@Transactional
public void inicijalizujAktivnosti(Integer gembaId, Integer idVrstaGem, String loggedUserUsername) {
    ListaProvera gemba = listaProveraRepository.findById(gembaId)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Gemba nije pronađena"));
    
   
    List<Aktivnost> aktivnosti = aktivnostRepository.findByVrstaGembeId(idVrstaGem);
    
    if (aktivnosti == null || aktivnosti.isEmpty()) {
       
        return;
    }
    
    Ishod defaultIshod = ishodRepository.findById(3)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Default ishod nije pronađen"));
    
    int added = 0;
    
    for (Aktivnost akt : aktivnosti) {
        
        // Provera duplikata
        boolean exists = listaProveraAktRepository.existsByListaProveraAndAktivnost(gembaId, akt.getiDAktivnosti());
        
        if (!exists) {
            ListaProveraAkt lpa = new ListaProveraAkt();
            lpa.setiDAktivnosti(akt);
            lpa.setiDLisProvere(gemba);
            lpa.setDatumUnos(new Date());
            lpa.setUserUnos(String.valueOf(loggedUserUsername));
            lpa.setiDIshod(defaultIshod);
            lpa.setHasZamerka(false);
            
            listaProveraAktRepository.save(lpa);
            added++;
        }
    }
    
    if (added > 0) {
        gemba.setStatus(EnumGembaStatus.AKTIVNOSTI_INICIJALIZOVANE.getStep());
        listaProveraRepository.save(gemba);
    }
}
    @Override
public List<ListaProveraAktDTO> findAktivnostiByGembaId(Integer gembaId) {
    List<ListaProveraAkt> aktivnosti = listaProveraAktRepository.findByListaProveraId(gembaId);
    
    // Postavi hasZamerka flag za svaku aktivnost
    for (ListaProveraAkt a : aktivnosti) {
        boolean hasZamerka = a.getListaProveraAktZamerkaCollection() != null && 
                             !a.getListaProveraAktZamerkaCollection().isEmpty();
        a.setHasZamerka(hasZamerka);
    }
    
    return aktivnosti.stream()
            .map(listaProveraAktMapper::toDto)  // ← vraća ListaProveraAktDTO
            .collect(Collectors.toList());
}


@Override
public boolean hasAktivnosti(Integer gembaId) {
    List<ListaProveraAktDTO> aktivnosti = findAktivnostiByGembaId(gembaId);
    return aktivnosti != null && !aktivnosti.isEmpty();
}

    @Override
    @Transactional
    public void updateIshod(Integer idLisProvereAkt, Integer ishodId, String loggedUserUsername) {
        ListaProveraAkt aktivnost = listaProveraAktRepository.findById(idLisProvereAkt)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Aktivnost nije pronađena"));
        
        Ishod ishod = ishodRepository.findById(ishodId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Ishod nije pronađen"));
        
        aktivnost.setiDIshod(ishod);
        aktivnost.setDatumIzmena(new Date());
        aktivnost.setUserIzmena(String.valueOf(loggedUserUsername));
        
        listaProveraAktRepository.save(aktivnost);
        
        // Provera da li su sve aktivnosti završene
        List<ListaProveraAkt> sveAktivnosti = listaProveraAktRepository.findByListaProveraId(
                aktivnost.getiDLisProvere().getiDLisProvere());
        
        boolean sveZavrsene = sveAktivnosti.stream()
                .allMatch(a -> a.getiDIshod() != null && 
                        (a.getiDIshod().getNaziv().equalsIgnoreCase("OK") || 
                         a.getiDIshod().getNaziv().equalsIgnoreCase("NIJE OK")));
        
        ListaProvera gemba = aktivnost.getiDLisProvere();
        if (sveZavrsene) {
            gemba.setStatus(EnumGembaStatus.ZAVRSENO.getStep());
        } else {
            gemba.setStatus(EnumGembaStatus.FINALIZACIJA_U_TOKU.getStep());
        }
        
        listaProveraRepository.save(gemba);
    }

    @Override
    @Transactional
    public void deleteAktivnost(Integer idLisProvereAkt) {
        ListaProveraAkt aktivnost = listaProveraAktRepository.findById(idLisProvereAkt)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Aktivnost nije pronađena"));
        
        // Provera da li ima zamerki
        if (aktivnost.isHasZamerka()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, 
                    "Aktivnost nije moguće obrisati jer postoje kreirane zamerke.");
        }
        
        listaProveraAktRepository.deleteById(idLisProvereAkt);
    }

    @Override
    @Transactional
    public void deleteGemba(Integer id) {
        ListaProvera gemba = listaProveraRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Gemba nije pronađena"));
        
        // Provera da li ima aktivnosti
        List<ListaProveraAkt> aktivnosti = listaProveraAktRepository.findByListaProveraId(id);
        if (!aktivnosti.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, 
                    "Brisanje nije moguće. Gemba ima zavisne stavke (aktivnosti).");
        }
        
        listaProveraRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void archiveGemba(Integer id, Integer loggedUserId) {
        ListaProvera gemba = listaProveraRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Gemba nije pronađena"));
        
        gemba.setStatus(EnumGembaStatus.ARHIVIRANO.getStep());
        gemba.setDatumIzmena(new Date());
        gemba.setUserIzmena(String.valueOf(loggedUserId));
        
        listaProveraRepository.save(gemba);
    }
    
    @Override
public List<ZamerkaDTO> findAllZamerke() {
    return zamerkaRepository.findAll().stream()
            .map(z -> {
                ZamerkaDTO dto = new ZamerkaDTO();
                dto.setIDZamerka(z.getiDZamerka());
                dto.setNaziv(z.getNaziv());
                return dto;
            })
            .collect(Collectors.toList());
}

@Override
public ListaProveraAktZamerkaDTO findZamerkaById(Integer id) {
    ListaProveraAktZamerka entity = listaProveraAktZamerkaRepository.findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Zamerka nije pronađena"));
    return listaProveraAktZamerkaMapperImpl.toDto(entity);
}

@Override
public List<ListaProveraAktZamerkaDTO> findZamerkeByAktivnostId(Integer aktivnostId) {
    return listaProveraAktZamerkaRepository.findByListaProveraAktId(aktivnostId).stream()
            .map(listaProveraAktZamerkaMapperImpl::toDto)
            .collect(Collectors.toList());
}

@Override
@Transactional
public Integer saveZamerka(ListaProveraAktZamerkaDTO zamerkaDTO, String aktivnostNaziv, String loggedUser) {
    ListaProveraAktZamerka entity;
    
    if (zamerkaDTO.getIDLisProvereAktZamerka() == null) {
        // Novi unos
        entity = new ListaProveraAktZamerka();
        entity.setDatumUnos(new Date());
        entity.setUserUnos(loggedUser);
    } else {
        // Izmena
        entity = listaProveraAktZamerkaRepository.findById(zamerkaDTO.getIDLisProvereAktZamerka())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Zamerka nije pronađena"));
        entity.setDatumIzmena(new Date());
        entity.setUserIzmena(loggedUser);
    }
    
    
    entity.setNapomena(zamerkaDTO.getNapomena());
    
   
    if (zamerkaDTO.getZamerka() != null && zamerkaDTO.getZamerka().getIDZamerka()!= null) {
        Zamerka zamerka = zamerkaRepository.findById(zamerkaDTO.getZamerka().getIDZamerka())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Zamerka nije pronađena"));
        entity.setiDZamerka(zamerka);
    }
    
   
    if (zamerkaDTO.getListaProveraAkt() != null && zamerkaDTO.getListaProveraAkt().getIDLisProvereAkt() != null) {
        ListaProveraAkt aktivnost = listaProveraAktRepository.findById(zamerkaDTO.getListaProveraAkt().getIDLisProvereAkt())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Aktivnost nije pronađena"));
        entity.setiDLisProvereAkt(aktivnost);
        
        // Postavi hasZamerka flag na aktivnosti
        aktivnost.setHasZamerka(true);
        listaProveraAktRepository.save(aktivnost);
    }
    
    ListaProveraAktZamerka saved = listaProveraAktZamerkaRepository.save(entity);
    return saved.getiDLisProvereAktZamerka();
}

@Override
@Transactional
public void deleteZamerka(Integer id) {
    ListaProveraAktZamerka zamerka = listaProveraAktZamerkaRepository.findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Zamerka nije pronađena"));
    
    // Ukloni flag sa aktivnosti
    ListaProveraAkt aktivnost = zamerka.getiDLisProvereAkt();
    if (aktivnost != null) {
        // Proveri da li ima još zamerki
        List<ListaProveraAktZamerka> preostaleZamerke = listaProveraAktZamerkaRepository
                .findByListaProveraAktId(aktivnost.getiDLisProvereAkt());
        
        if (preostaleZamerke.size() <= 1) { // samo ova koju brišemo
            aktivnost.setHasZamerka(false);
            listaProveraAktRepository.save(aktivnost);
        }
    }
    
    listaProveraAktZamerkaRepository.deleteById(id);
}

@Override
public List<ZamerkaDTO> findZamerkeByMasterAktivnostId(Integer aktivnostId) {
    return zamerkaRepository.findByAktivnostId(aktivnostId).stream()
            .map(z -> {
                ZamerkaDTO dto = new ZamerkaDTO();
                dto.setIDZamerka(z.getiDZamerka());
                dto.setNaziv(z.getNaziv());
                return dto;
            })
            .collect(Collectors.toList());
}

@Override
public AktivnostDTO findAktivnostById(Integer id) {
    Aktivnost aktivnost = aktivnostRepository.findById(id)
            .orElseThrow(() -> new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Aktivnost nije pronađena"));
    
    AktivnostDTO dto = new AktivnostDTO();
    dto.setIDAktivnosti(aktivnost.getiDAktivnosti());
    dto.setNaziv(aktivnost.getNaziv());
    
    return dto;
}

@Override
public boolean canAddZamerka(Integer idListaAktivnosti) {
    ListaProveraAkt aktivnost = listaProveraAktRepository.findById(idListaAktivnosti)
            .orElseThrow(() -> new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Aktivnost nije pronađena"));
    
    
    if (aktivnost.getiDIshod() == null) {
        return false;
    }
    
    return "NIJE OK".equalsIgnoreCase(aktivnost.getiDIshod().getNaziv());
}

@Override
public String getIshodStatus(Integer idListaAktivnosti) {
    ListaProveraAkt aktivnost = listaProveraAktRepository.findById(idListaAktivnosti)
            .orElseThrow(() -> new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Aktivnost nije pronađena"));
    
    if (aktivnost.getiDIshod() == null) {
        return "NEMA ISHODA";
    }
    
    return aktivnost.getiDIshod().getNaziv();
}
}