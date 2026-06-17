package com.betacom.pv.interfaces;

import java.util.List;

import com.betacom.pv.dto.input.MacchinaReq;
import com.betacom.pv.dto.output.MacchinaDTO;

public interface IMacchinaService {
	void create(MacchinaReq req) throws Exception;
	void update(MacchinaReq req) throws Exception;
	void delete(Integer id) throws Exception;
	MacchinaDTO getById(Integer id) throws Exception;
	List<MacchinaDTO> getAll() throws Exception;
}