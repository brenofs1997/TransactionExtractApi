package com.api.superaapi.controllers;


import com.api.superaapi.entities.Transferencia;
import com.api.superaapi.services.TransferenciaService;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/transferencia")
public class TransferenciaController {

    final TransferenciaService service;

    public TransferenciaController(TransferenciaService service){
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<Page<Transferencia>> getAll(@PageableDefault(page = 0, size = 10, sort = "id", direction = Sort.Direction.ASC) Pageable pageable){
        return ResponseEntity.status(HttpStatus.OK).body(service.findAll(pageable));
    }



}
