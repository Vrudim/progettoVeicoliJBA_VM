package com.betacom.pv.implementations;

import java.util.List;

import org.springframework.stereotype.Service;

import com.betacom.pv.dto.input.AlimentazioneReq;
import com.betacom.pv.dto.output.AlimentazioneDTO;
import com.betacom.pv.interfaces.ITipoAlimentazioneService;
import com.betacom.pv.mapping.AlimentazioneMapper;
import com.betacom.pv.models.TipoAlimentazione;
import com.betacom.pv.models.TipoVeicolo;
import com.betacom.pv.repository.ITipoAlimentazioneRepository;
import com.betacom.pv.utils.Validazione;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class AlimentazioneImpl implements ITipoAlimentazioneService{

	private final ITipoAlimentazioneRepository alimR;
    private final Validazione valida;
	
	@Override
	public void create(AlimentazioneReq req) throws Exception {
        TipoVeicolo tipo = valida.validaTipoVeicolo(req.getTipo());
        TipoAlimentazione a = new TipoAlimentazione();
        a.setDescrizione(req.getDescrizione());
        a.setTipoVeicolo(tipo);
        
        alimR.save(a);		
	}
	
	@Override
	public List<AlimentazioneDTO> getAll() throws Exception {
		return alimR.findAll().stream()
                .map(a -> AlimentazioneMapper.toDTO(a))
                .toList();
	}


}
