package com.api.superaapi.repositories;

import com.api.superaapi.entities.Transferencia;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TransferenciaRepository extends JpaRepository<Transferencia, UUID>{
}
