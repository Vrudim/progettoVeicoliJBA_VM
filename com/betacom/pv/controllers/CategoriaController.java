package com.betacom.pv.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.betacom.pv.dto.input.CategoriaVeicoliReq;
import com.betacom.pv.dto.input.ValidationGroups;
import com.betacom.pv.dto.output.CategoriaVeicoliDTO;
import com.betacom.pv.dto.output.ResponseDTO;
import com.betacom.pv.interfaces.ICategoriaService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/rest/CategoriaVeicoli")
public class CategoriaController {
	
	private final ICategoriaService catS;
	
	@PostMapping("create")
    public ResponseEntity<ResponseDTO> create(@RequestBody(required = true) @Validated(ValidationGroups.Create.class) CategoriaVeicoliReq req) throws Exception {
		catS.create(req);
        return ResponseEntity.ok(ResponseDTO.builder().msg("created...").build());
    }
	
	 @GetMapping("getAll")
	 public ResponseEntity<List<CategoriaVeicoliDTO>> getAll() throws Exception {
		 return ResponseEntity.ok(catS.getAll());
	 }

}
