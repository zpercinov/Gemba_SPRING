/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.hemofarm.Gemba_SPRING.Service;

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
import java.util.List;

/**
 *
 * @author zpercinov
 */
public interface GembaService {
    
    GembaDTO createNewGemba();
    
 
    GembaDTO findGembaById(Integer id);
    
  
    List<VrstaGembeDTO> findAllVrstaGembe();
    List<KlasterDTO> findAllKlasteri();
    List<FunkcijaDTO> findAllFunkcije();
    List<OdeljenjeDTO> findAllOdeljenja();
    List<NosilacDTO> findAllNosioci();
    List<SajtDTO> findAllSajtovi(); 
    List<IshodDTO> findAllIshodi();
    List<AktivnostDTO> findAktivnostiByVrstaGembe(Integer idVrstaGembe);
    
    
    Integer saveGemba(GembaDTO gembaDTO, String loggedUser);
    
    
    void inicijalizujAktivnosti(Integer gembaId, Integer idVrstaGem, String loggedUserusername);
    List<ListaProveraAktDTO> findAktivnostiByGembaId(Integer gembaId);
    boolean hasAktivnosti(Integer gembaId);
    void updateIshod(Integer idLisProvereAkt, Integer ishodId, String loggedUserUsername);
    void deleteAktivnost(Integer idLisProvereAkt);
    AktivnostDTO findAktivnostById(Integer id);
    
    
    void deleteGemba(Integer id);
    void archiveGemba(Integer id, Integer loggedUserId);


    List<ZamerkaDTO> findAllZamerke();
    ListaProveraAktZamerkaDTO findZamerkaById(Integer id);
    List<ListaProveraAktZamerkaDTO> findZamerkeByAktivnostId(Integer aktivnostId);
    Integer saveZamerka(ListaProveraAktZamerkaDTO zamerkaDTO, String aktivnostNaziv, String loggedUser);
    void deleteZamerka(Integer id);
    List<ZamerkaDTO> findZamerkeByMasterAktivnostId(Integer aktivnostId);
    
      boolean canAddZamerka(Integer idListaAktivnosti);
    String getIshodStatus(Integer idListaAktivnosti);

}


