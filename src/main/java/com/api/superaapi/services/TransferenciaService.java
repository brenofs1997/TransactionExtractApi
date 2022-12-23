package com.api.superaapi.services;

import com.api.superaapi.entities.Transferencia;
import com.api.superaapi.repositories.TransferenciaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class TransferenciaService {
    final
    TransferenciaRepository transferenciaRepository;

    public TransferenciaService(TransferenciaRepository transferenciaRepository) {
        this.transferenciaRepository = transferenciaRepository;
    }

    public Page<Transferencia> findAll(Pageable pageable) {
        return transferenciaRepository.findAll(pageable);
    }

}
