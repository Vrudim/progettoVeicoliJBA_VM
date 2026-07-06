package com.betacom.pv.interfaces;

import java.util.List;

import com.betacom.pv.dto.input.RicercaReq;
import com.betacom.pv.dto.output.VeicoliDTO;


public interface IVeicoliService {
	List<VeicoliDTO> getAll() throws Exception;
	List<VeicoliDTO> ricerca(RicercaReq req) throws Exception;
	void delete(Integer id) throws Exception;
	
}
