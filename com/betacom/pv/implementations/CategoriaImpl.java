package com.betacom.pv.implementations;

import java.util.List;

import org.springframework.stereotype.Service;

import com.betacom.pv.dto.input.CategoriaVeicoliReq;
import com.betacom.pv.dto.output.CategoriaVeicoliDTO;
import com.betacom.pv.interfaces.ICategoriaService;
import com.betacom.pv.mapping.CategoriaMapper;
import com.betacom.pv.models.CategoriaVeicolo;
import com.betacom.pv.models.TipoVeicolo;
import com.betacom.pv.repository.ICategoriaVeicoloRepository;
import com.betacom.pv.utils.Validazione;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class CategoriaImpl implements ICategoriaService{

	private final ICategoriaVeicoloRepository catR;
    private final Validazione valida;
    
	@Override
	public void create(CategoriaVeicoliReq req) throws Exception {
		TipoVeicolo tipo = valida.validaTipoVeicolo(req.getTipo());
		CategoriaVeicolo a = new CategoriaVeicolo();
        a.setDescrizione(req.getDescrizione());
        a.setTipoVeicolo(tipo);
        
        catR.save(a);		
		
	}

	@Override
	public List<CategoriaVeicoliDTO> getAll() throws Exception {
		return catR.findAll().stream()
                .map(a -> CategoriaMapper.toDTO(a))
                .toList();
	}


}
