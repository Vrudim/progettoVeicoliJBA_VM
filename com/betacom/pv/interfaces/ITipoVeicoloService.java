package com.betacom.pv.interfaces;

import java.util.List;

import com.betacom.pv.dto.input.TipoVeicoloReq;
import com.betacom.pv.dto.output.TipoDTO;

public interface ITipoVeicoloService {
	void create(TipoVeicoloReq req) throws Exception;
	List<TipoDTO> getAll() throws Exception;
	void delete(String tipo) throws Exception;
}
