package com.betacom.pv.implementations;

import java.util.List;

import org.springframework.stereotype.Service;

import com.betacom.pv.dto.input.SospensioneReq;
import com.betacom.pv.dto.output.SospensioneDTO;
import com.betacom.pv.interfaces.ITipoSospensioneService;
import com.betacom.pv.mapping.SospensioneMapper;
import com.betacom.pv.models.TipoSospensione;
import com.betacom.pv.repository.ITipoSospensioneRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class SospensioneImpl implements ITipoSospensioneService{
	
	private final ITipoSospensioneRepository sospR;
	
	@Override
	public void create(SospensioneReq req) throws Exception {
		TipoSospensione sosp = new TipoSospensione();
		sosp.setDescrizione(req.getSospensione());
		
		sospR.save(sosp);
	}

	@Override
	public List<SospensioneDTO> getAll() throws Exception {
		return sospR.findAll().stream()
                .map(a -> SospensioneMapper.toDTO(a))
                .toList();
	}

}
