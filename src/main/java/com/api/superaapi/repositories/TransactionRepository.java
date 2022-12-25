package com.api.superaapi.repositories;

import com.api.superaapi.entities.Transaction;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.UUID;


public interface TransactionRepository extends JpaRepository<Transaction, UUID>{
    @Query("SELECT obj FROM Transaction obj WHERE obj.data_transferencia BETWEEN :min AND :max ORDER BY obj.valor DESC")
    Page<Transaction> findTransferenciaByDate(LocalDate min, LocalDate max, Pageable pageable);

    @Query("SELECT obj FROM Transaction obj WHERE obj.nome_operador_transacao = :operador ORDER BY obj.valor DESC")
    Page<Transaction> findTransferenciaByName(String operador, Pageable pageable);

    @Query("SELECT obj FROM Transaction obj WHERE obj.nome_operador_transacao = :operador AND obj.data_transferencia BETWEEN :min AND :max ORDER BY obj.valor DESC")
    Page<Transaction> findTransferenciaByFilters(LocalDate min, LocalDate max, String operador, Pageable pageable);

    @Query("SELECT SUM(valor) FROM Transaction")
    Float sumAmountValues();

    @Query("SELECT SUM(obj.valor) FROM Transaction obj WHERE obj.data_transferencia BETWEEN :min AND :max ")
    Float sumAmountValuesByPeriod(LocalDate min, LocalDate max);
}
