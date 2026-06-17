package com.betacom.pv.interfaces;

import java.util.List;

import com.betacom.pv.dto.input.CategoriaVeicoliReq;
import com.betacom.pv.dto.output.CategoriaVeicoliDTO;

public interface ICategoriaService {
	void create(CategoriaVeicoliReq req) throws Exception;
	List<CategoriaVeicoliDTO> getAll() throws Exception;
}
