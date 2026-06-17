package com.betacom.pv.interfaces;

import java.util.List;

import com.betacom.pv.dto.input.MotoReq;
import com.betacom.pv.dto.output.MotoDTO;

public interface IMotoService {
	void create(MotoReq req) throws Exception;
	void update(MotoReq req) throws Exception;
	void delete(Integer id) throws Exception;
	MotoDTO getById(Integer id) throws Exception;
	List<MotoDTO> getAll() throws Exception;
}