package com.api.superaapi.controllers;


import com.api.superaapi.entities.Transaction;
import com.api.superaapi.services.TransactionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/transferencias")
public class TransactionController {
    final TransactionService service;

    public TransactionController(TransactionService service){
        this.service = service;
    }
    @GetMapping
    public ResponseEntity<Page<Transaction>> getAll(@PageableDefault(page = 0, size = 10, sort = "id", direction = Sort.Direction.ASC) Pageable pageable){
        return ResponseEntity.status(HttpStatus.OK).body(service.findAll(pageable));
    }

    @GetMapping("/amount")
    public ResponseEntity<Float> getAmount(){
        return ResponseEntity.status(HttpStatus.OK).body(service.sumAmountValues());
    }

    @GetMapping("/amountbyperiod")
    public ResponseEntity<Float> getAmountByPeriod(
            @RequestParam(value="minDate") String minDate,
            @RequestParam(value="maxDate")String maxDate
            ){
        return ResponseEntity.status(HttpStatus.OK).body(service.sumAmountValuesByPeriod(minDate,maxDate));
    }

    @GetMapping("/filter")
    public ResponseEntity<Page<Transaction>> getTransferenciaByFilters(
            @RequestParam(value="minDate") String minDate,
            @RequestParam(value="maxDate")String maxDate,
            @RequestParam(value = "nomeOperador")String operador,
            @PageableDefault(page = 0, size = 10, sort = "id", direction = Sort.Direction.ASC) Pageable pageable){
        return ResponseEntity.status(HttpStatus.OK).body(service.findTransferenciaByFilters(minDate,maxDate,operador,pageable));
    }

}
