package com.betacom.pv.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.betacom.pv.dto.input.MotoReq;
import com.betacom.pv.dto.input.ValidationGroups;
import com.betacom.pv.dto.output.MotoDTO;
import com.betacom.pv.dto.output.ResponseDTO;
import com.betacom.pv.interfaces.IMotoService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/rest/moto")
public class MotoController {

    private final IMotoService motoS;

    @PostMapping("create")
    public ResponseEntity<ResponseDTO> create(@RequestBody(required = true) @Validated(ValidationGroups.Create.class) MotoReq req) throws Exception {
        motoS.create(req);
        return ResponseEntity.ok(ResponseDTO.builder().msg("created...").build());
    }

    @PutMapping("update")
    public ResponseEntity<ResponseDTO> update(@RequestBody(required = true)@Validated(ValidationGroups.Update.class) MotoReq req) throws Exception {
        motoS.update(req);
        return ResponseEntity.ok(ResponseDTO.builder().msg("updated...").build());
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<ResponseDTO> delete(@PathVariable Integer id) throws Exception {
        motoS.delete(id);
        return ResponseEntity.ok(ResponseDTO.builder().msg("deleted...").build());
    }

    @GetMapping("getById")
    public ResponseEntity<Object> getById(@RequestParam Integer id) throws Exception {
        return ResponseEntity.ok(motoS.getById(id));
    }

    @GetMapping("getAll")
    public ResponseEntity<List<MotoDTO>> getAll() throws Exception {
        return ResponseEntity.ok(motoS.getAll());
    }
}