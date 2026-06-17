package com.betacom.pv.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.betacom.pv.dto.input.MacchinaReq;
import com.betacom.pv.dto.input.ValidationGroups;
import com.betacom.pv.dto.output.MacchinaDTO;
import com.betacom.pv.dto.output.ResponseDTO;
import com.betacom.pv.interfaces.IMacchinaService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/rest/macchina")
public class MacchinaController {

    private final IMacchinaService macS;

    @PostMapping("create")
    public ResponseEntity<ResponseDTO> create(@RequestBody(required = true) @Validated(ValidationGroups.Create.class) MacchinaReq req) throws Exception {
        macS.create(req);
        return ResponseEntity.ok(ResponseDTO.builder().msg("created...").build());
    }

    @PutMapping("update")
    public ResponseEntity<ResponseDTO> update(@RequestBody(required = true) @Validated(ValidationGroups.Update.class) MacchinaReq req) throws Exception {
        macS.update(req);
        return ResponseEntity.ok(ResponseDTO.builder().msg("updated...").build());
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<ResponseDTO> delete(@PathVariable Integer id) throws Exception {
        macS.delete(id);
        return ResponseEntity.ok(ResponseDTO.builder().msg("deleted...").build());
    }

    @GetMapping("getById")
    public ResponseEntity<Object> getById(@RequestParam Integer id) throws Exception {
        return ResponseEntity.ok(macS.getById(id));
    }

    @GetMapping("getAll")
    public ResponseEntity<List<MacchinaDTO>> getAll() throws Exception {
        return ResponseEntity.ok(macS.getAll());
    }
}