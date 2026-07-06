package com.betacom.pv.implementations;

import java.util.List;

import org.springframework.stereotype.Service;

import com.betacom.pv.dto.input.RicercaReq;
import com.betacom.pv.dto.output.VeicoliDTO;
import com.betacom.pv.exceptions.AcademyException;
import com.betacom.pv.interfaces.IBiciService;
import com.betacom.pv.interfaces.IMacchinaService;
import com.betacom.pv.interfaces.IMotoService;
import com.betacom.pv.interfaces.IVeicoliService;
import com.betacom.pv.mapping.VeicoliMapper;
import com.betacom.pv.models.Veicoli;
import com.betacom.pv.repository.IVeicoloRepository;
import com.betacom.pv.utils.Validazione;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
@Service
@RequiredArgsConstructor
@Slf4j
public class VeicoliImpl implements IVeicoliService{
	private final IVeicoloRepository veicR;
	private final IBiciService Bserv;
	private final IMotoService Moserv;
	private final IMacchinaService Maserv;
	@Override
	public List<VeicoliDTO> getAll() throws Exception {
		return veicR.findAll().stream()
                .map(v -> VeicoliMapper.toDTO(v))
                .toList();
	}

	@Override
    public List<VeicoliDTO> ricerca(RicercaReq req) throws Exception {
		return veicR.ricerca(
				Validazione.clean(req.getTipoVeicolo()),
				Validazione.clean(req.getMarca()),
				Validazione.clean(req.getModello()),
				Validazione.clean(req.getColore()),
				Validazione.clean(req.getAlimentazione()),
				Validazione.clean(req.getCategoria()),
				Validazione.clean(req.getTarga())
	            ).stream()
				.map(v -> VeicoliMapper.toDTO(v))
				.toList();
    }
	@Override
	public void delete(Integer id) throws Exception {
	    Veicoli v = veicR.findById(id)
	            .orElseThrow(() -> new AcademyException("veicolo.not.found"));

	    if ("bici".equalsIgnoreCase(v.getTipoVeicolo().getTipo())) {
	    	Bserv.delete(v.getBici().getId());
	    } else if ("moto".equalsIgnoreCase(v.getTipoVeicolo().getTipo())) {
	    	Moserv.delete(v.getMoto().getId());
	    } else if ("macchina".equalsIgnoreCase(v.getTipoVeicolo().getTipo())) {
	    	Maserv.delete(v.getMacchina().getId());
	    }
	}
}
