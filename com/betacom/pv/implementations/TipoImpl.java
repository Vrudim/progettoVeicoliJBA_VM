package com.betacom.pv.implementations;

import java.util.List;

import org.springframework.stereotype.Service;

import com.betacom.pv.dto.input.TipoVeicoloReq;
import com.betacom.pv.dto.output.TipoDTO;
import com.betacom.pv.exceptions.AcademyException;
import com.betacom.pv.interfaces.IMessaggiServices;
import com.betacom.pv.interfaces.ITipoVeicoloService;
import com.betacom.pv.mapping.TipiVeicoliMapper;
import com.betacom.pv.models.TipoVeicolo;
import com.betacom.pv.repository.ITipoVeicoloRepository;
import com.betacom.pv.utils.Validazione;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
@Service
@RequiredArgsConstructor
@Slf4j
public class TipoImpl implements ITipoVeicoloService {

	private final ITipoVeicoloRepository tipoR;
    private final Validazione valida;
    private final IMessaggiServices msgS;

	@Override
	@Transactional
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

	@Transactional
	@Override
	public void delete(String id) throws Exception {
		TipoVeicolo tipo = tipoR.findById(id)
                .orElseThrow(() -> new AcademyException(msgS.get("tipo.no.present")));
		valida.checkTipo(tipo);
		tipoR.delete(tipo);
	}
}
