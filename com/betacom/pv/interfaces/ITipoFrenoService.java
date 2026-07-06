package com.betacom.pv.interfaces;

import java.util.List;

import com.betacom.pv.dto.input.FrenoReq;
import com.betacom.pv.dto.output.FrenoDTO;

public interface ITipoFrenoService {
	void create(FrenoReq req) throws Exception;
	List<FrenoDTO> getAll() throws Exception;
	void delete(String freno) throws Exception;

}
