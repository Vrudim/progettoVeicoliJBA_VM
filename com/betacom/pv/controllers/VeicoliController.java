package com.betacom.pv.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.betacom.pv.dto.input.RicercaReq;
import com.betacom.pv.dto.output.ResponseDTO;
import com.betacom.pv.dto.output.VeicoliDTO;
import com.betacom.pv.interfaces.IVeicoliService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/rest/Veicoli")
public class VeicoliController {
	private final IVeicoliService veicS;
	
	@GetMapping("/getAll")
	public ResponseEntity<List<VeicoliDTO>> getAll() throws Exception {
	    return ResponseEntity.ok(veicS.getAll());
	}
	
	@GetMapping("/ricerca")
	public ResponseEntity<List<VeicoliDTO>> ricerca(RicercaReq req) throws Exception {
	    return ResponseEntity.ok(veicS.ricerca(req));	
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<ResponseDTO> delete(@PathVariable Integer id) throws Exception {
	    veicS.delete(id);
	    return ResponseEntity.ok(ResponseDTO.builder().msg("deleted...").build());
	}
}
