package com.betacom.pv.implementations;

import java.util.List;

import org.springframework.stereotype.Service;

import com.betacom.pv.dto.input.FrenoReq;
import com.betacom.pv.dto.output.FrenoDTO;
import com.betacom.pv.interfaces.ITipoFrenoService;
import com.betacom.pv.mapping.FrenoMapper;
import com.betacom.pv.models.TipoFreno;
import com.betacom.pv.repository.ITipoFrenoRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class FrenoImpl implements ITipoFrenoService{

	private final ITipoFrenoRepository frenoR;

	@Override
	public void create(FrenoReq req) throws Exception {
		TipoFreno frn = new TipoFreno();
		frn.setDescrizione(req.getDescrizione());
		
		frenoR.save(frn);
	}

	@Override
	public List<FrenoDTO> getAll() throws Exception {
		return frenoR.findAll().stream()
				.map(f -> FrenoMapper.toDTO(f))
				.toList();
	}
}
