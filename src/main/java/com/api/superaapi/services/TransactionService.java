package com.api.superaapi.services;

import com.api.superaapi.entities.Transaction;
import com.api.superaapi.repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class TransactionService {
    final
    TransactionRepository transactionRepository;

    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public Page<Transaction> findAll(Pageable pageable) {
        return transactionRepository.findAll(pageable);
    }

    public Float sumAmountValues() {
        return transactionRepository.sumAmountValues();
    }

    public Page<Transaction> findTransferenciaByFilters(String minDate, String maxDate, String operador, Pageable pageable){
        if (isEmptyName(operador) && isContainDateFilter(minDate,maxDate) )
            return transactionRepository.findTransferenciaByDate(LocalDate.parse(minDate),LocalDate.parse(maxDate),pageable);

        if (!isEmptyName(operador) && !isContainDateFilter(minDate,maxDate))
            return transactionRepository.findTransferenciaByName(operador,pageable);

        if( isEmptyName(operador) && !isContainDateFilter(minDate,maxDate) )
            return  transactionRepository.findAll(pageable);

        return transactionRepository.findTransferenciaByFilters(LocalDate.parse(minDate),LocalDate.parse(maxDate),operador,pageable);
    }

    public boolean isEmptyName(String operador){
        return operador.equals("");
    }
    public boolean isContainDateFilter(String minDate,String maxDate){
        return !minDate.equals("") || !maxDate.equals("");
    }

    public Float sumAmountValuesByPeriod(String minDate, String maxDate) {
        return transactionRepository.sumAmountValuesByPeriod(LocalDate.parse(minDate),LocalDate.parse(maxDate));
    }
}
