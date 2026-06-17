package com.betacom.pv.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.betacom.pv.dto.input.BiciReq;
import com.betacom.pv.dto.input.ValidationGroups;
import com.betacom.pv.dto.output.BiciDTO;
import com.betacom.pv.dto.output.ResponseDTO;
import com.betacom.pv.interfaces.IBiciService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/rest/bici")
public class BiciController {

    private final IBiciService biciS;

    @PostMapping("create")
    public ResponseEntity<ResponseDTO> create(@RequestBody(required = true) @Validated(ValidationGroups.Create.class) BiciReq req) throws Exception {
        biciS.create(req);
        return ResponseEntity.ok(ResponseDTO.builder().msg("created...").build());
    }

    @PutMapping("update")
    public ResponseEntity<ResponseDTO> update(@RequestBody(required = true) @Validated(ValidationGroups.Update.class) BiciReq req) throws Exception {
        biciS.update(req);
        return ResponseEntity.ok(ResponseDTO.builder().msg("updated...").build());
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<ResponseDTO> delete(@PathVariable Integer id) throws Exception {
        biciS.delete(id);
        return ResponseEntity.ok(ResponseDTO.builder().msg("deleted...").build());

    }

    @GetMapping("getById")
    public ResponseEntity<Object> getById(@RequestParam Integer id) throws Exception {

        return ResponseEntity.ok(biciS.getById(id));
    }

    @GetMapping("getAll")
    public ResponseEntity<List<BiciDTO>> getAll() throws Exception {
        return ResponseEntity.ok(biciS.getAll());
    }
}