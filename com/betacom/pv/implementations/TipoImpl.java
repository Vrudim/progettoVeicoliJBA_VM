package com.betacom.pv.implementations;

import java.util.List;

import org.springframework.stereotype.Service;

import com.betacom.pv.dto.input.TipoVeicoloReq;
import com.betacom.pv.dto.output.TipoDTO;
import com.betacom.pv.interfaces.ITipoVeicoloService;
import com.betacom.pv.mapping.TipiVeicoliMapper;
import com.betacom.pv.models.TipoVeicolo;
import com.betacom.pv.repository.ITipoVeicoloRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
@Service
@RequiredArgsConstructor
@Slf4j
public class TipoImpl implements ITipoVeicoloService {

	private final ITipoVeicoloRepository tipoR;

	@Override
	public void create(TipoVeicoloReq req) throws Exception {
		TipoVeicolo tipo = new TipoVeicolo();
		tipo.setTipo(req.getTipoVeicolo());
		tipoR.save(tipo);
		
	}

	@Override
	public List<TipoDTO> getAll() throws Exception {
		return tipoR.findAll().stream()
                .map(a -> TipiVeicoliMapper.toDTO(a))
                .toList();
	}
}
