package com.betacom.pv.interfaces;

import java.util.List;

import com.betacom.pv.dto.input.SospensioneReq;
import com.betacom.pv.dto.output.SospensioneDTO;

public interface ITipoSospensioneService {
	void create(SospensioneReq req) throws Exception;
	List<SospensioneDTO> getAll() throws Exception;

}
