package com.picpaysimplificado.controllers;
import com.picpaysimplificado.DTOs.TransactionDTO;
import com.picpaysimplificado.domain.transaction.Transaction;
import com.picpaysimplificado.repositories.TransactionRepository;
import com.picpaysimplificado.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/transfer")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @PostMapping
    public ResponseEntity<Transaction> createTransaction(@RequestBody TransactionDTO transactionDTO) throws Exception {

        Transaction transactionNew = transactionService.createTransaction(transactionDTO);
        return new ResponseEntity<>(transactionNew, HttpStatus.CREATED);
    }
}
