package com.betacom.pv.interfaces;

import java.util.List;

import com.betacom.pv.dto.input.AlimentazioneReq;
import com.betacom.pv.dto.output.AlimentazioneDTO;

public interface ITipoAlimentazioneService {
	void create(AlimentazioneReq req) throws Exception;
	List<AlimentazioneDTO> getAll() throws Exception;

}
