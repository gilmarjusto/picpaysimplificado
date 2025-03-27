package com.picpaysimplificado.repositories;

import com.picpaysimplificado.DTOs.TransactionDTO;
import org.springframework.data.jpa.repository.JpaRepository;

import com.picpaysimplificado.domain.transaction.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long>{

}
