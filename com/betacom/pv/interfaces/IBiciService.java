package com.betacom.pv.interfaces;

import java.util.List;

import com.betacom.pv.dto.input.BiciReq;
import com.betacom.pv.dto.output.BiciDTO;

public interface IBiciService {
	void create(BiciReq req) throws Exception;
	void update(BiciReq req) throws Exception;
	void delete(Integer id) throws Exception;
	BiciDTO getById(Integer id) throws Exception;
	List<BiciDTO> getAll() throws Exception;
}