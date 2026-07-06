package com.betacom.pv.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.betacom.pv.dto.input.SospensioneReq;
import com.betacom.pv.dto.input.ValidationGroups;
import com.betacom.pv.dto.output.ResponseDTO;
import com.betacom.pv.dto.output.SospensioneDTO;
import com.betacom.pv.interfaces.ITipoSospensioneService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/rest/TipiSospensione")
public class SospensioneController {
	private final ITipoSospensioneService sospS;
	
	@PostMapping("create")
    public ResponseEntity<ResponseDTO> create(@RequestBody(required = true) @Validated(ValidationGroups.Create.class) SospensioneReq req) throws Exception {
		sospS.create(req);
        return ResponseEntity.ok(ResponseDTO.builder().msg("created...").build());
    }
	
	 @GetMapping("getAll")
	 public ResponseEntity<List<SospensioneDTO>> getAll() throws Exception {
		 return ResponseEntity.ok(sospS.getAll());
	 }
	 
	 @DeleteMapping("delete/{id}")
	 public ResponseEntity<ResponseDTO> delete(@PathVariable String id) throws Exception {
		 sospS.delete(id);
	     return ResponseEntity.ok(ResponseDTO.builder().msg("deleted...").build());
	 }
}
