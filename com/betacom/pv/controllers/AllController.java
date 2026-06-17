package com.betacom.pv.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.betacom.pv.interfaces.IBiciService;
import com.betacom.pv.interfaces.IMacchinaService;
import com.betacom.pv.interfaces.IMotoService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/rest/GetAll")
public class AllController {
    private final IMotoService motoS;
    private final IMacchinaService macS;
    private final IBiciService biciS;
    
    @GetMapping("/getAll")
    public ResponseEntity<List<Object>> getAll() throws Exception {
    	List<Object> ris = new ArrayList<Object>();
    	ris.addAll(motoS.getAll());
    	ris.addAll(macS.getAll());
    	ris.addAll(biciS.getAll());
    	
    	return ResponseEntity.ok(ris);
    }
}
